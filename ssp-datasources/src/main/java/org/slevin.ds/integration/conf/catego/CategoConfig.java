package org.slevin.ds.integration.conf.catego;

import org.slevin.ds.integration.repositories.catego.CategoRepository;
import org.slevin.ds.model.Product;
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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "categoEntityManagerFactory",
        transactionManagerRef = "categoTransactionManager",
        basePackageClasses = CategoRepository.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class})
public class CategoConfig {

    @Autowired
    private JpaProperties jpaProperties;


    @Bean(name = "categoDataSource")
    @ConfigurationProperties(prefix = "spring.categoDataSource")
    public DataSource categoDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcCatego")
    public JdbcTemplate jdbcTemplate(@Qualifier("categoDataSource") DataSource categoDataSource) {
        return new JdbcTemplate(categoDataSource);
    }

    @Autowired
    @Bean(name = "categoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder factoryBuilder,
                                                                       @Qualifier("categoDataSource") DataSource bds) {
        return factoryBuilder
                .dataSource(bds)
                .packages(Product.class)
                .persistenceUnit("categoPersistenceUnit")
                        // Using Hibernate and Not using JTA.  (Change the next line if your context is different.)
                .properties(this.jpaProperties.getHibernateProperties(bds))
                .build();
    }

    @Autowired
    @Bean(name = "categoTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("categoEntityManagerFactory") EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }



}
