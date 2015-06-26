package org.meliodas.persistence;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.meliodas.Main.Application;
import org.meliodas.persistence.model.Customer;
import org.meliodas.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testCustomerRepository(){
        customerRepository.save(new Customer("rim", "ouannane", "rim.ouannane@springboot.com"));
        customerRepository.save(new Customer("rim2", "ouannane2", "rim.ouannane2@springboot.com"));
        customerRepository.save(new Customer("kamal", "azaddyne", "kamal.azaddyne@springboot.com"));

        Assert.assertEquals(customerRepository.findOne(1L).getEmail(), "rim.ouannane@springboot.com");
        Assert.assertEquals(customerRepository.findOne(2L).getEmail(),"rim.ouannane2@springboot.com");
        Assert.assertEquals(customerRepository.findOne(3L).getEmail(),"kamal.azaddyne@springboot.com");
        Assert.assertEquals(customerRepository.findByLastName("azaddyne").get(0).getEmail(), "kamal.azaddyne@springboot.com");

    }


}
