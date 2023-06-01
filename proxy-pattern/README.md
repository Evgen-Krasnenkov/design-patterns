# task1 Proxy design pattern

### Written code overview

**ConnectionPool** (com.kras.impl) poll which contains all created real connections.
**RealConnection** (com.kras.impl) connection which implements interfaceConnection (com.kras) and used in
the connection pool.

## Task - Implement proxy pattern for connection.

1. Implement interface Connection  in the ProxyConnection class (com.kras.impl)
2. Close method should return connection to the ConnectionPool 
3. Write reallyClose() method in the ProxyConnection class which close real connection.


