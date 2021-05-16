package ua.ivashchuk.utils;




import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static String USER_NAME = "root";
    private static String USER_PASSWORD = "admin";
    private static String URL = "jdbc:mysql://localhost/i_shop";


    public static Connection openConnection() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        DOMConfigurator.configure("log4j.xml");
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
    }
}
