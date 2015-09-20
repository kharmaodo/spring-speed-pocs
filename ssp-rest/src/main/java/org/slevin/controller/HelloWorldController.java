package org.slevin.controller;


import org.meliodas.persistence.model.Customer;
import org.meliodas.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value="/{name}", method= RequestMethod.GET)
    @ResponseBody
    public Customer newCustomer(@PathVariable("name") String name) {
        Customer customer = new Customer(name,"azaddyne","@mail");
        customerRepository.save(customer);
        return customer;
    }

    @RequestMapping(value="/all", method= RequestMethod.GET)
    @ResponseBody
    public Iterable<Customer> all() throws Exception {
        return customerRepository.findAll();
    }

}
