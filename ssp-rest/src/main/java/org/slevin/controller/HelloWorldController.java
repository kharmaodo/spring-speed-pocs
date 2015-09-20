package org.slevin.controller;

import org.slevin.common.Account;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value="/account/{name}", method= RequestMethod.POST)
    public Account greeting(@PathVariable("name") String name) {
        Account account = new Account();
        account.setUsername(name);
        account.setEmail(name+"@gmail.com");
        account.setPassword("pass");
        return account;
    }

}
