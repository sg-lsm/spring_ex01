package org.lsm.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectTest {
    @Test
    public void test1(){
        int v1 = 10;
        int v2 = 10;
        Assertions.assertEquals(v1, v2);
    }
    @Test
    public void testConnection() throws ConnectException,ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/spring5fs?characterEncoding=utf8",
                "spring5",
                "spring5"
        );
        Assertions.assertNotNull(conn);
        conn.close();
    }

    @Test
    public void testHikariCP() throws Exception{
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
        config.setUsername("spring5");
        config.setPassword("spring5");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();
    }
}
