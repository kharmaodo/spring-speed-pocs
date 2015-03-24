package org.slevin.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.slevin.common.Account;
import org.slevin.dao.AccountDao;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacky on 23/03/15.
 */
public class DaoTests {

    private static AccountDao accountService;

    @BeforeClass
    public static void init() throws Exception{
        MockTheDao();
    }



    @Test
    public void findAllTest() throws Exception {
        List<Account> accounts = accountService.findAll();
        assertEquals(1, accounts.size());
        assertTrue(accounts.get(0).isEnabled());
        assertEquals("kamal.azaddyne@gmail.com", accounts.get(0).getEmail());
    }


    private static void MockTheDao() throws Exception {
        accountService = mock(AccountDao.class);
        Account account = new Account();
        account.setEmail("kamal.azaddyne@gmail.com");
        account.setPassword("");
        account.setEnabled(true);
        ArrayList<Account> accountList = new ArrayList<Account>();
        accountList.add(account);
        when(accountService.findAll()).thenReturn(accountList);
    }


}
