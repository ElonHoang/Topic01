package com.fis.dao.jdbcUlti;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;

public class Database {
    public static final String URL = "jdbc:mysql://localhost:3306/evidence_db";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "2002dev";

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    public static ComboPooledDataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl(URL);
        cpds.setUser(USERNAME);
        cpds.setPassword(PASSWORD);

        cpds.setInitialPoolSize(5);
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(100);
        return cpds;
    }

    public static Connection getConnection() throws  Exception{
        // No connection pool
        // Connection con = DriverManager.getConnection (URL, USER_NAME, PASSWORD);

        // Has connection pool
        // C3P0
        //Connection con = getDataSource().getConnection();

        // HikariCP
        Connection con = ds.getConnection();
        return con;
    }

    static {
        config.setJdbcUrl(URL);
        config.setUsername( USERNAME );
        config.setPassword( PASSWORD );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );

        ds = new HikariDataSource( config );
    }
}
