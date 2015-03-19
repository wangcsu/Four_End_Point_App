import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.parser.*;
import org.json.simple.JSONObject;

public class UserAuth {
	private static final String filepath = "/Users/Frank/Documents/personal_projects/Four_Endpoint_App/src/userinfo.json";
	public static void Authenticate() throws IOException, ParseException{
		
		FileReader reader = new FileReader(filepath);
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(reader);
		
		String username = (String) obj.get("username");
		String password = (String) obj.get("password");
		
		DataBase db = new DataBase("UserDB");
		String query = "SELECT password FROM user WHERE username = '" + username + "'";
		ResultSet rs = db.execute(query);
		try {
			while(rs.next()){
				if (password.equals(rs.getString("password"))){
					System.out.println("User Authenticated!");
				}else{
					System.out.println("Wrong username/password combination!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
