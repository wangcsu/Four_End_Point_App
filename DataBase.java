
import java.sql.*;
public class DataBase {
	private static final String driverName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/";
	private String dbname;
	private static final String DBuser = "root";
	private static final String DBpass = "19891016wk";
	
	public DataBase(String name) {
		 dbname = name;
		 url = url + dbname;
	}
	
	public ResultSet execute(String query) {
		ResultSet rs = null;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, DBuser, DBpass);
			Statement stmt = con.createStatement();
			stmt.execute(query);
			rs = stmt.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
