package org.meliodas.repositories;

import org.meliodas.domain.ShoppingList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingListRepository extends
        MongoRepository<ShoppingList, String> {

}
