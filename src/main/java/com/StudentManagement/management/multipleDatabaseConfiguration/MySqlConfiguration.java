//package com.StudentManagement.management.configuration;
//
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class MySqlConfiguration {
//
//    // to make sure connections get assigned to it properly
//    @ConfigurationProperties("spring.datasource.mysql")
//    @Bean
//    public DataSourceProperties mySqlDataSourceProperties(){
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    public DataSource mySqlDataSource(){
//        // this is one way to do also just return DataSourceProperties() class it also works
////        DriverManagerDataSource dataSource=new DriverManagerDataSource();
////        dataSource.setUsername(mySqlDataSourceProperties().getUsername());
////        dataSource.setPassword(mySqlDataSourceProperties().getPassword());
////        dataSource.setUrl(mySqlDataSourceProperties().getUrl());
////        dataSource.setDriverClassName(mySqlDataSourceProperties().getDriverClassName());
////        return dataSource;
//        return mySqlDataSourceProperties().initializeDataSourceBuilder().build();
//    }
//
//
//
//}
