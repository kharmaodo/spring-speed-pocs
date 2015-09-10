package org.slevin.ds.integration.repositories.product;

import org.slevin.ds.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
