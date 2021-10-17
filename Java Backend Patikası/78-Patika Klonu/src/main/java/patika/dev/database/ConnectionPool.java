package patika.dev.database;

import patika.dev.manager.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {

    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
            return conn;
        } catch (Exception e) { e.printStackTrace(); return null; }
    }

    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        }
        catch (SQLException e) {}
    }

}
