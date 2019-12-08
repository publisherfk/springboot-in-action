package com.heshi.transaction.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBConfig {

    private Logger logger = LoggerFactory.getLogger(DBConfig.class);

    @Bean
    public Connection getConnection() throws SQLException {
        String userName = "root";
        String password = "1";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/oauth2?serverTimezone=Asia/Chongqing&characterEncoding=UTF-8";
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage(), e);
        }
        return DriverManager.getConnection(url, userName, password);
    }
}
