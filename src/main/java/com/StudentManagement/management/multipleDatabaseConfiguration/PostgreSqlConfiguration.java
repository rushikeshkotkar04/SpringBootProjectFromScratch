//package com.StudentManagement.management.configuration;
//
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class PostgreSqlConfiguration {
//
//    // to make sure connections get assigned to it properly
//    @ConfigurationProperties("spring.datasource.pg")
//    @Bean
//    public DataSourceProperties pgDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//
//    @Bean
//    public DataSource pgSqlDataSource() {
//        // this is one way to do also just return DataSourceProperties() class it also works
////        DriverManagerDataSource dataSource=new DriverManagerDataSource();
////        dataSource.setUsername(pgDataSourceProperties().getUsername());
////        dataSource.setPassword(pgDataSourceProperties().getPassword());
////        dataSource.setUrl(pgDataSourceProperties().getUrl());
////        dataSource.setDriverClassName(pgDataSourceProperties().getDriverClassName());
////        return dataSource;
//        return pgDataSourceProperties().initializeDataSourceBuilder().build();
//    }
//}
