package org.meliodas.web.controller.service;

import org.meliodas.persistence.model.ShoppingList;
import org.meliodas.persistence.service.IShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/shop")
public class ShoppingListController {

    @Autowired
    private IShoppingListService shoppingListService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public java.util.List<ShoppingList> getAll() {
        return shoppingListService.getAll();
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void getHello() {
        System.out.println("@@@@ HIIIIIII THERE");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ShoppingList get(@PathVariable String id) {
        return shoppingListService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ShoppingList create(@RequestBody ShoppingList shoppingList) {
        shoppingListService.create(shoppingList);
        return shoppingList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ShoppingList update(@PathVariable String id,
                               @RequestBody ShoppingList shoppingList) {
        shoppingListService.update(id, shoppingList);
        return shoppingList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void delete(@PathVariable String id) {
        shoppingListService.delete(id);
    }

}
