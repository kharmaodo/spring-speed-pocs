package org.slevin.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slevin.common.Account;
import org.slevin.common.Role;
import org.slevin.dao.AccountDao;
import org.slevin.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class persistenceTests {

    @Autowired
    AccountDao accountDao;

    @Autowired
    RoleDao roleDao;


    @Test
    public void testDaoImpl() throws Exception {
        Account user = new Account();
        user.setEmail("mail@google.com");
        user.setPassword("password");
        user.setUsername("user");
        user.setEnabled(true);
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        role.setUsername(user.getUsername());
        roleDao.persist(role);
        accountDao.persist(user);
        assertEquals(1, accountDao.count());
        assertEquals(1, roleDao.count());
    }


}
