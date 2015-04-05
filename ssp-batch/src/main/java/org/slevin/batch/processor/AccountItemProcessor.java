package org.slevin.batch.processor;

import org.slevin.common.Account;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by jacky on 02/04/15.
 */
public class AccountItemProcessor implements ItemProcessor<Account,Account> {


    public Account process(final Account account) throws Exception {
        final String email = account.getEmail();
        final String username = account.getUsername();
        System.out.println("processing :"+email+" - "+username);

        return account;
    }
}
