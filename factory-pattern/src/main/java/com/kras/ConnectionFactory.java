package com.kras;

import java.sql.Connection;

public interface ConnectionFactory {
    Connection createConnection();
}
