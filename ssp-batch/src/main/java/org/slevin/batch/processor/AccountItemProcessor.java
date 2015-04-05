package org.slevin.batch.processor;

import org.slevin.common.Account;
import org.slevin.dao.service.AccountService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jacky on 02/04/15.
 */
public class AccountItemProcessor implements ItemProcessor<Account,Account> {

    //@Autowired
    //AccountService service;

    public Account process(final Account account) throws Exception {
        final String email = account.getEmail();
        final String username = account.getUsername();

        System.out.println("processing :"+email+" - "+username);
       // service.merge(account);

        return account;
    }
}
