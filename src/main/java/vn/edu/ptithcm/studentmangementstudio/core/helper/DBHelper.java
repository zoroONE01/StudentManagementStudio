package vn.edu.ptithcm.studentmangementstudio.core.helper;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Getter
public class DBHelper {

    private static DBHelper instance;
    private Connection connection;

    private DBHelper() {
    }

    public static DBHelper getInstance() {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
    }


    public void initialize(int port, String username, String pass) throws SQLException {
        if (connection != null) {
            return;
        }
        var SERVER_ADDRESS = "10.211.55.7";
        var DB_NAME = "QLDSV_TC";
        var url = "jdbc:sqlserver://" + SERVER_ADDRESS + ":" + port + ";databaseName=" + DB_NAME + ";encrypt=true;trustServerCertificate=true";
        try {
            var DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(DRIVER); // Nạp driver
            connection = DriverManager.getConnection(url, username, pass);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không tìm thấy driver JDBC cho SQL Server.", e);
        }
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

}
