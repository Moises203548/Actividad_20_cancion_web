package com.cancionweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String HOST = "b7xokmwazkec8wnffrmc-mysql.services.clever-cloud.com";
    private static final String PORT = "3306";
    private static final String DATABASE = "b7xokmwazkec8wnffrmc";
    private static final String USER = "uec0p2k67tssxsov";
    private static final String PASSWORD = "wjyvjmRqfXcLx8mvPsMf";

    private static final String URL =
            "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE
                    + "?useSSL=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    public static Connection getConexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver de MySQL", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}