package filehandling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONDemo {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub

		// Write
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Vishwa");
		jsonObject.put("age", 32);

		Map<String, String> address = new HashMap<>();
		address.put("city", "Bangalore");
		address.put("state", "Karnataka");
		address.put("country", "India");
		address.put("pin", "560076");
		jsonObject.putAll(address);

		JSONArray jsonArray = new JSONArray();
		Map<String, String> phone = new LinkedHashMap<>();
		phone.put("type", "Home");
		phone.put("number", "+ 91 9845098450");
		jsonArray.add(phone);

		phone = new LinkedHashMap<>();
		phone.put("type", "Work");
		phone.put("number", "+ 91 7845078450");
		jsonArray.add(phone);

		jsonObject.put("phone", jsonArray);

		String path = "src/test/resources/jsonfile.json";
		File file = new File(path);
		FileWriter fileWriter = new FileWriter(path);
		fileWriter.write(jsonObject.toJSONString());
		fileWriter.flush();
		fileWriter.close();

		// Read
		// parsing file "JSONExample.json"
		Object obj = new JSONParser().parse(new FileReader(path));
		// typecasting obj to JSONObject
		JSONObject jsonObject2 = (JSONObject) obj;
		System.out.println(jsonObject2.get("name"));
		System.out.println(jsonObject2.get("phone"));
	}

}
