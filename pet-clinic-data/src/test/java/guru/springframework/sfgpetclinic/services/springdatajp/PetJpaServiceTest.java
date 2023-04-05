package guru.springframework.sfgpetclinic.services.springdatajp;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PetJpaServiceTest {

    PetJpaService petJpaService;

    @Mock
    PetRepository petRepository;



    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        petJpaService = new PetJpaService(petRepository);
    }

    @Test
    public void findAll() {
        Set<Pet> petSet = new HashSet<>();
        petSet.add(new Pet());
        Mockito.when(petJpaService.findAll()).thenReturn(petSet);

        Set<Pet> all = petJpaService.findAll();
        Assertions.assertThat(all).isNotNull();
        Assertions.assertThat(all).hasSize(1);

        verify(petRepository, times(1)).findAll();
    }
}