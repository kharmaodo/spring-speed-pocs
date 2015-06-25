package org.meliodas.persistence.repositories;

import org.meliodas.persistence.model.ShoppingList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingListRepository extends
        MongoRepository<ShoppingList, String> {

}
