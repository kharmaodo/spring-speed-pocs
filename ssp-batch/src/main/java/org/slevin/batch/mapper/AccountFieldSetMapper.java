package org.slevin.batch.mapper;

import org.slevin.common.Account;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * Created by jacky on 05/04/15.
 */
public class AccountFieldSetMapper implements FieldSetMapper<Account> {


    public Account mapFieldSet(FieldSet fieldSet) throws BindException {
        Account account = new Account();
        account.setUsername(fieldSet.readString(0));
        account.setPassword(fieldSet.readString(1));
        account.setEmail(fieldSet.readString(2));
        account.setEnabled(fieldSet.readBoolean(3));
        return account;
    }
}
