package org.meliodas.persistence.service;

import org.meliodas.domain.ShoppingList;

import java.util.List;

public interface IShoppingListService {

    public List<ShoppingList> getAll();

    ShoppingList findOne(String listId);

    public void create(ShoppingList shoppingList);

    void update(String id, ShoppingList shoppingList);

    void delete(String id);

    Long count();

}
