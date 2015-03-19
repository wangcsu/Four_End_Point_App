import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DisplayUsers {
	public static void Display(){
		HashMap<String,String> parameters = new HashMap<>();
		try {
			URL url = new URL("https://twitter.com/search?q=gracenote&src=typd&lang=en");
			String query = url.getQuery();
			String[] params = query.split("&");
			for (String p : params){
				String[] split = p.split("=");
				parameters.put(split[0], split[1]);
			}
			DataBase db = new DataBase("UserDB");
			String DBquery = "SELECT GROUP_CONCAT(username) FROM user WHERE src = '" + parameters.get("src") + "' GROUP BY lang";
			ResultSet rs = db.execute(DBquery);
			while(rs.next()){
				System.out.println(rs.getString("GROUP_CONCAT(username)"));
			}
		} catch (MalformedURLException | SQLException e) {
			e.printStackTrace();
		}
	}
}
