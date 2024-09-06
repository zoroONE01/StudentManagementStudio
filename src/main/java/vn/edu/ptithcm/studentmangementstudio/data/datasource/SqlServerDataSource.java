package vn.edu.ptithcm.studentmangementstudio.data.datasource;

import lombok.Getter;
import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.core.utils.AppLogger;

import java.sql.*;
import java.util.*;


@Getter
public class SqlServerDataSource {

    private static SqlServerDataSource instance;
    private Connection connection;

    private SqlServerDataSource() {
    }

    public static SqlServerDataSource getInstance() {
        if (instance == null) {
            instance = new SqlServerDataSource();
        }
        return instance;
    }

    private boolean isConnected() throws SQLException {
        if (connection == null) return false;
        return !connection.isClosed();
    }

    public void connectToServerAsRoot() throws SQLException {
        connect(Resource.ROOT_ADDRESS, Resource.ADMIN_USER, Resource.ADMIN_PASS);
    }

    public void connectToServerAsStudent(String serverName) throws SQLException {
        connect(getServer(serverName), Resource.STUDENT_USER, Resource.ADMIN_PASS);
    }

    public void connect(String serverAddress, String username, String pass) throws SQLException {
        if (isConnected()) return;
        var url = "jdbc:sqlserver://" + serverAddress + ";databaseName=QLDSV_TC;encrypt=true;trustServerCertificate=true";
        try {
            Class.forName(Resource.DRIVER); // Nạp driver
            connection = DriverManager.getConnection(url, username, pass);
            AppLogger.log("Connected to database: " + serverAddress, this.getClass().toString());
        } catch (ClassNotFoundException e) {
            throw new SQLException(K.Strings.NOT_FOUND_SQL_SERVER_DRIVER, e);
        } catch (SQLException e) {
            throw new SQLException(K.Strings.ACCOUNT_OR_PASSWORD_INCORRECT, e);
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        var ps = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return ps.executeQuery();
    }

    public ResultSet executeQuery(String query, Object... params) throws SQLException {
        var ps = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        for (int i = 0; i < params.length; i++) ps.setObject(i + 1, params[i]);
        return ps.executeQuery();
    }

    public void close() throws SQLException {
        if (isConnected()) {
            connection.close();
            AppLogger.log("Close connect database", this.getClass().toString());
        }
    }

    public static String getServer(String serverName) {
        return Resource.SERVER.get(serverName);
    }

    public static class Resource {
        public static final Map<String, String> SERVER = new HashMap<>() {
            {
                put("DESKTOP-LPVOS13\\MSSQLSERVER0", "10.211.55.7:1430");
                put("DESKTOP-LPVOS13\\MSSQLSERVER1", "10.211.55.7:1431");
                put("DESKTOP-LPVOS13\\MSSQLSERVER2", "10.211.55.7:1432");
                put("DESKTOP-LPVOS13\\MSSQLSERVER3", "10.211.55.7:1433");
            }
        };
        private static final String ROOT_ADDRESS = SERVER.get("DESKTOP-LPVOS13\\MSSQLSERVER0");
        private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        private static final String ADMIN_USER = "sa";
        private static final String STUDENT_USER = "SINHVIEN";
        private static final String ADMIN_PASS = "adminadmin";
    }
}
