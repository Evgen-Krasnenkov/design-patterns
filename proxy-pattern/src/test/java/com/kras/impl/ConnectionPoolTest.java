package com.kras.impl;

import com.kras.Connection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConnectionPoolTest {

    @Test
    void givenConnectionPool_whenClose_thenReturnRealConnectionToPool() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Assertions.assertFalse(connection.isClosed());
        Assertions.assertEquals(9, pool.getFreeConnectionsCount());
        Assertions.assertEquals(1, pool.getUsedConnectionsCount());
        connection.close();
        Assertions.assertEquals(10, pool.getFreeConnectionsCount());
        Assertions.assertEquals(0, pool.getUsedConnectionsCount());
        pool.destroyPool();

    }

}