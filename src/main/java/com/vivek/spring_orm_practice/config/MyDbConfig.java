package com.vivek.spring_orm_practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
public class MyDbConfig {


    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_orm");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    public Properties hibernateProperties(){
        Properties properties=new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.show_sql",true);
        properties.put("hibernate.hbm2ddl.auto","update");
        return properties;
    }


    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactoryBean= new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.setAnnotatedClasses(com.vivek.spring_orm_practice.entities.Student.class,
                com.vivek.spring_orm_practice.entities.Employee.class);
        return sessionFactoryBean;
    }


    @Bean
    public HibernateTemplate getHibernateTemplate(){
        HibernateTemplate hibernateTemplate=new HibernateTemplate();
        hibernateTemplate.setSessionFactory(sessionFactory().getObject());
        return hibernateTemplate;
    }

    @Bean
    public TransactionManager getTransactionManager(){
         HibernateTransactionManager transactionManager = new HibernateTransactionManager();
         transactionManager.setSessionFactory(sessionFactory().getObject());
         return transactionManager;
    }
}
