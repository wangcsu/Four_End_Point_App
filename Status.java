import java.sql.ResultSet;
import java.sql.SQLException;

public class Status {
	public static void show(){
		DataBase db = new DataBase("UserDB");
		String query = "SHOW GLOBAL STATUS";
		ResultSet rs = db.execute(query);
		
		try {
			while(rs.next()){
				System.out.printf("%s  %s\n", rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
