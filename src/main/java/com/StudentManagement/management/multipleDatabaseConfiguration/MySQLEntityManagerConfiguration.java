//package com.StudentManagement.management.configuration;
//
//
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableJpaRepositories(
//        basePackages = "com.StudentManagement.management.mysqldao",
//        entityManagerFactoryRef = "mySqlEntityManagerBean"
//)
//public class MySQLEntityManagerConfiguration {
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean mySqlEntityManagerBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder, @Qualifier("mySqlDataSource") DataSource dataSource){
//        return entityManagerFactoryBuilder
//                .dataSource(dataSource)
//                .packages("com.StudentManagement.management.entities.MySQLstudentsRelated")
//                .build();
//    }
//
//}
