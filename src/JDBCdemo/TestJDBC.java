package JDBCdemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args){
        
        String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "root";
        String password = "";
        
        try{ 
            System.out.println("connecting to database!"+jdbcURL);
            
            Connection connection = DriverManager.getConnection(jdbcURL, user, password);
            
            System.out.println("Connection successful!!!");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
