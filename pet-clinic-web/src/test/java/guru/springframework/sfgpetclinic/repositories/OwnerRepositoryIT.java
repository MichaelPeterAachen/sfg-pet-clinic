package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OwnerRepositoryIT {

    @Autowired
    OwnerRepository ownerRepository;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByLastName() {
        Owner owner = ownerRepository.findByLastName("Pezer");
        assertEquals("Michael", owner.getFirstName());
    }
}