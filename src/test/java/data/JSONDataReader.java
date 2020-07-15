package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JSONDataReader {
	public String fName,lName , mail ,password;
	public void jsonReader() throws FileNotFoundException, IOException, ParseException {
		
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.json";
		File srcFile = new File(filePath);
		JSONParser parser = new JSONParser();
		JSONArray jArray = (JSONArray) parser.parse(new FileReader(srcFile));
		for (Object jsonObj : jArray) {
			
			JSONObject user =  (JSONObject) jsonObj;
			fName = (String) user.get("firstName");
			System.out.println(fName);
			
			lName = (String) user.get("lastName");
			System.out.println(lName);

			mail = (String) user.get("mail");
			System.out.println(mail);

			password = (String) user.get("password");
			System.out.println(password);

		}

	}
}
