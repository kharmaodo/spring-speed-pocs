package org.meliodas.persistence.repository;

import org.meliodas.persistence.model.ShoppingList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingListRepository extends
        MongoRepository<ShoppingList, String> {

}
