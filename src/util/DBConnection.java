package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
  
  private static final String URL="jdbc:mysql://localhost:3306/payroll_db";
  private static final String USER="root";
  private static final String PASS="vaikash";

  public static Connection getConnection(){
    try{
      return
     // System.out.println("database connected");
      DriverManager.getConnection(URL, USER, PASS);
    }catch(Exception e){
      e.printStackTrace();
    }
    return null;
  }

}
