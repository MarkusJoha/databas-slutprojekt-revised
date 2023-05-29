package models;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public class Database {
    private static MysqlDataSource dataSource;

    static String url = "localhost";
    static int port = 3308;
    static String database = "Slutprojekt";
    static String username = "root";
    static String password = "";


    private static void initializeDataSource() {
        try {
            System.out.println("Configuring data source...");
            dataSource = new MysqlDataSource();
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.setUrl("jdbc:mysql://" + url + ":" + port + "/" + database + "?serverTimezone=UTC");
            dataSource.setUseSSL(false);
            System.out.println("done!\n");
        } catch (SQLException e) {
            System.out.println("failed!\n");
            System.exit(0);
        }
    }

    public static Connection getConnection() {
        if (dataSource == null) {
            initializeDataSource();
        }

        try {
            System.out.println("Fetching connection to database...");
            Connection connection = dataSource.getConnection();
            System.out.println("done!\n");
            return connection;

        } catch (SQLException e) {
            System.out.println("failed!\n");
            System.exit(0);
        }

        return null;
    }

    protected MysqlDataSource getDataSource() {
        return dataSource;
    }
}

