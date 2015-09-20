package org.slevin.ds.integration.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slevin.ds.integration.conf.AppConfig;
import org.slevin.ds.integration.repositories.catego.CategoRepository;
import org.slevin.ds.integration.repositories.product.ProductRepository;
import org.slevin.ds.model.Catego;
import org.slevin.ds.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AppConfig.class})
@ActiveProfiles("test")
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoRepository categoRepository;

    @Autowired
    @Qualifier("jdbcCatego")
    private JdbcTemplate jdbc;

    @Test
    public void test(){
        Product pro1 = new Product();
        pro1.setName("yo");
        repository.saveAndFlush(pro1);

        Catego cat1 = new Catego();
        cat1.setName("blabla");
        categoRepository.saveAndFlush(cat1);

        Assert.assertEquals(1, repository.findAll().size());
        Assert.assertEquals(1, categoRepository.findAll().size());
        Assert.assertNotNull(getItem("blabla"));

    }

    private Catego getItem(String name) {
        return jdbc.queryForObject("SELECT * FROM Catego.catego WHERE id=?", itemMapper, 1L);
    }

    private static final RowMapper<Catego> itemMapper = new RowMapper<Catego>() {
        public Catego mapRow(ResultSet rs, int rowNum) throws SQLException {
            Catego item = new Catego();
            item.setId(rs.getLong("id"));
            item.setName(rs.getString("name"));
            return item;
        }
    };


}
