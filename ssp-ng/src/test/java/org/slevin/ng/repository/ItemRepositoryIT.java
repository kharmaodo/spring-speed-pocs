package org.slevin.ng.repository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slevin.ng.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.assertj.core.api.Assertions.assertThat;

@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
  TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@DatabaseSetup(ItemRepositoryIT.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { ItemRepositoryIT.DATASET })
@DirtiesContext
public class ItemRepositoryIT {
  protected static final String DATASET = "classpath:datasets/it-items.xml";
  private static final String FIRST_ITEM = "Item 1";
  private static final String THIRD_ITEM = "Item 3";
  private static final String DESCRIPTION_FIELD = "description";
  @Autowired
  private ItemRepository repository;

  @Test
  public void findCheckedShouldReturnTwoItems() {
    assertThat(repository.findChecked())
      .hasSize(2)
      .extracting(DESCRIPTION_FIELD)
      .containsOnly(FIRST_ITEM, THIRD_ITEM);
  }

}
