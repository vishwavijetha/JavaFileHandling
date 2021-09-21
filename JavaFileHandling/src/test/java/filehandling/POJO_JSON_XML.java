package filehandling;

import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;

public class POJO_JSON_XML {

	public static void main(String[] args) throws SerializeException, ParseException {
		// TODO Auto-generated method stub

		// Serialization
		// POJO to JSON
		CarPOJO car = new CarPOJO("Maruti Suzuki", "Swift", "ZXI", "Red", 2021, 1000000, new String[]{"Bimal Maruti", "Kalyani Motors"});
		JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;
		String json = jsonSerializer.serialize(car);
		System.out.println("------------------- JSON -------------------");
		System.out.println(json);
		
		// POJO to XML
		XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
		String xml = xmlSerializer.serialize(car);
		System.out.println("------------------- XML -------------------");
		System.out.println(xml);
		
		// POJO to HTML
		HtmlSerializer htmlSerializer = HtmlSerializer.DEFAULT_SQ_READABLE;
		String html = htmlSerializer.serialize(car);
		System.out.println("------------------- HTML -------------------");
		System.out.println(html);
		
		// Deserialization
		// JSON to POJO
		JsonParser jsonParser = JsonParser.DEFAULT;
		CarPOJO myCar = jsonParser.parse(json, CarPOJO.class);
		System.out.println(myCar);
		System.out.println(myCar.getName());
		System.out.println(myCar.getOnRoadPrice());
	}

}
