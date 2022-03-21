
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn{

	Connection c=null;
	Statement s=null;
	
	
     public Conn() {
    	 try {
    		 Class.forName("com.mysql.cj.jdbc.Driver");
    		 c = DriverManager.getConnection("jdbc:mysql://localhost:3308/airline","root","");
    		 s =  c.createStatement();
    	 }
    	 catch(ClassNotFoundException | SQLException e){
             System.out.println(e);
         }
     }
	
}