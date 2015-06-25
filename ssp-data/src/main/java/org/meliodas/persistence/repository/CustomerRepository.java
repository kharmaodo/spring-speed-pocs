package org.meliodas.persistence.repository;


import org.meliodas.persistence.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByEmail(String email);

}
