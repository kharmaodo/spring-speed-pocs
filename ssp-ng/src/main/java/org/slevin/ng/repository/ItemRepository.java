package org.slevin.ng.repository;

import java.util.List;

import org.slevin.ng.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ItemRepository extends JpaRepository<Item, Integer> {

  @Query("SELECT i FROM Item i WHERE i.checked=true")
  List<Item> findChecked();
}
