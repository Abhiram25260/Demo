package test;
import java.sql.*;
public class DBConnection {
	public static Connection con;
	private DBConnection() {}
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		}catch(Exception e) {}
	}
	public static Connection getcon(){
		return con;
	}

}
