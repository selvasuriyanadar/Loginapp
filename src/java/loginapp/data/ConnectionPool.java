package loginapp.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {

  private static String url = "jdbc:mysql://localhost:3306/loginapp?allowPublicKeyRetrieval=true&useSSL=false";
  private static String userName = "loginapp_user";
  private static String password = "sesame";

  private static ConnectionPool pool = null;

  private ConnectionPool() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    }
    catch (ClassNotFoundException e) {
      System.out.println(e);
    }
  }

  public static ConnectionPool getInstance() {
    if (pool == null) {
      pool = new ConnectionPool();
    }
    return pool;
  }

  public Connection getConnection() {
    try {
      return DriverManager.getConnection(url, userName, password);
    } catch (SQLException e) {
      System.out.println(e);
      return null;
    }
  }

  public void freeConnection(Connection c) {
    try {
      c.close();
    } catch (SQLException e) {
      System.out.println(e);
    }
  }
}
