package com.kras.impl;

import com.kras.ConnectionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

class H2ConnectionFactoryTest {
    private static String file;
    @BeforeAll
    static void setUp(){
        file = "h2.properties";
    }

    @Test
    void givenH2Prop_whenConnectionFactory_thenNewH2Connection() {
        ConnectionFactory factory = new H2ConnectionFactory(file);
        Connection connection = factory.createConnection();
        Assertions.assertNotNull(connection);
        Assertions.assertEquals(H2ConnectionFactory.class, factory.getClass());
    }

}