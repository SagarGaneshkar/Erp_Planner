package university.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Conn{
  Connection connection;
  Statement statement;
  Conn(){
    try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagement", "root", "root");
      statement=connection.createStatement(); 
    }catch(Exception e)
    {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    new Conn(); // Creates an object to test connection
}
}