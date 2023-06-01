package com.kras.impl;


import com.kras.Connection;

public class ProxyConnection implements Connection {
    private final ConnectionPool cp;
    private final RealConnection realConnection;

    public ProxyConnection(RealConnection realConnection) {
        this.cp = ConnectionPool.getInstance();
        this.realConnection = realConnection;
    }

    public void reallyClose() {
        realConnection.close();
    }

    @Override
    public void close() {
        cp.releaseConnection(this);
    }

    @Override
    public boolean isClosed() {
        return realConnection.isClosed();
    }
}
