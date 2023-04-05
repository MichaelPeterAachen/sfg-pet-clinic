package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class OwnerControllerTest extends TestCase {

    private OwnerController ownerController;

    @Mock
    private OwnerService ownerService;

    @Mock
    private Model model;

    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController(ownerService);
    }

    @Test
    public void testListOwner() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(new Owner());
        Mockito.when(ownerService.findAll()).thenReturn(ownerSet);

        ArgumentCaptor<Set<Owner>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String result = ownerController.listOwner(model);

        Mockito.verify(model, times(1)).addAttribute(eq("owners"), argumentCaptor.capture());
        Set<Owner> ownersCaptured = argumentCaptor.getValue();
        assertThat(ownersCaptured).isEqualTo(ownerSet);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
        mockMvc.perform(get("/owners")).andExpect(status().isOk()).andExpect(view().name("owners/index"));
    }


}