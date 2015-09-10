package org.slevin.ds.integration.repositories;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slevin.ds.integration.conf.AppConfig;
import org.slevin.ds.integration.repositories.catego.CategoRepository;
import org.slevin.ds.integration.repositories.product.ProductRepository;
import org.slevin.ds.model.Catego;
import org.slevin.ds.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AppConfig.class})
@ActiveProfiles("test")
@Slf4j
public class ProductRepositoryTest {

    @Autowired
    ProductRepository repository;

    @Autowired
    CategoRepository categoRepository;

    @Test
    public void test(){
        Product pro1 = new Product();
        pro1.setName("yo");
        repository.saveAndFlush(pro1);

        Catego cat1 = new Catego();
        cat1.setName("blabla");
        categoRepository.saveAndFlush(cat1);

        Assert.assertEquals(1, repository.findAll().size());
        Assert.assertEquals(1,categoRepository.findAll().size());
    }



}
