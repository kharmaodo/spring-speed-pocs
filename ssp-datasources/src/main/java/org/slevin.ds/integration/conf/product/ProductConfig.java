package org.slevin.ds.integration.conf.product;

import org.slevin.ds.model.Product;
import org.slevin.ds.integration.repositories.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "productEntityManagerFactory",
        transactionManagerRef = "productTransactionManager",
        basePackageClasses = ProductRepository.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class})
public class ProductConfig {

    @Autowired
    private JpaProperties jpaProperties;


    @Primary
    @Bean(name = "productDataSource")
    @ConfigurationProperties(prefix = "spring.productDataSource")
    public DataSource barDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Autowired
    @Bean(name = "productEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder factoryBuilder,
                                                                       @Qualifier("productDataSource") DataSource bds) {
        return factoryBuilder
                .dataSource(bds)
                .packages(Product.class)
                .persistenceUnit("productPersistenceUnit")
                        // Using Hibernate and Not using JTA.  (Change the next line if your context is different.)
                .properties(this.jpaProperties.getHibernateProperties(bds))
                .build();
    }

    @Autowired
    @Bean(name = "productTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("productEntityManagerFactory") EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }

}
