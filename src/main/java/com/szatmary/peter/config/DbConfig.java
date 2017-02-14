package com.szatmary.peter.config;


import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Autowired
    private Environment env;

    // vagrant-mysql
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(byEnvironment("datasource.mysql.driver"));
        dataSource.setUrl(byEnvironment("datasource.mysql.url"));
        dataSource.setUsername(byEnvironment("datasource.mysql.user"));
        dataSource.setPassword(byEnvironment("datasource.mysql.password"));
        return dataSource;
    }


    private String byEnvironment(String before) {
        String key = before + "." + env.getProperty("environment");
        return env.getProperty(key);
    }


}
