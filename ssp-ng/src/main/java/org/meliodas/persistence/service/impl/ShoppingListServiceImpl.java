package org.meliodas.persistence.service.impl;

import org.meliodas.persistence.model.ShoppingList;
import org.meliodas.persistence.service.IShoppingListService;
import org.meliodas.persistence.repositories.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShoppingListServiceImpl implements IShoppingListService {

    @Autowired
    ShoppingListRepository shoppingListRepository;

    @Override
    public List<ShoppingList> getAll() {
        return shoppingListRepository.findAll(new Sort(Direction.DESC,
                "lastViewDate"));
    }

    @Override
    public ShoppingList findOne(String id) {
        ShoppingList shoppingList = shoppingListRepository.findOne(id);
        shoppingList.setLastViewDate(new Date());
        shoppingListRepository.save(shoppingList);
        return shoppingList;
    }

    @Override
    public void create(ShoppingList shoppingList) {
        shoppingList.setLastViewDate(new Date());
        shoppingListRepository.save(shoppingList);
    }

    @Override
    public void update(String id, ShoppingList shoppingList) {
        shoppingList.setLastViewDate(new Date());
        shoppingList.setId(id);
        shoppingListRepository.save(shoppingList);
    }

    @Override
    public void delete(String id) {
        shoppingListRepository.delete(id);
    }

    @Override
    public Long count() {
        return shoppingListRepository.count();
    }


}
