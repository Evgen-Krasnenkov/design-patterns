package com.kras.impl;

import com.kras.ConnectionFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    private static Properties props = new Properties();;
    private final String driver;
    private final String url;
    private final String user;
    private final String psw;

    public H2ConnectionFactory(String file){
        try (InputStream stream = H2ConnectionFactory.class.getClassLoader().getResourceAsStream(file)) {
            props.load(stream);
        } catch (IOException e) {
            throw new RuntimeException("Can't read DB properties", e);
        }
        driver = props.getProperty("jdbc_driver");
        url = props.getProperty("db_url");
        user = props.getProperty("user");
        psw = props.getProperty("password");
    }

    @Override
    public Connection createConnection() {
        try {
            return DriverManager.getConnection(url, user, psw);
        } catch (SQLException e) {
            throw new RuntimeException("Can't open connection");
        }
    }
}

