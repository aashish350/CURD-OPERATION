package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
       static {
    	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
  private static Connection con;
	
	public static Connection getJdbcConnection() throws SQLException {
		String url="jdbc:mysql://localhost:3306/Aashish";
		String uname="root";
		String pass="root";
		 con=DriverManager.getConnection(url,uname, pass);
		return con;
	}
	
	public static void getLose() throws SQLException {
		con.close();
	}
}
