package CreateAppointment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class BookApptEnhancer {
	 static String[] date;
	    static String futureDate;
	    static String futureTime;
	    static String phoneNumber;
private static final ObjectMapper mapper=new ObjectMapper();
private static final String bookApptPath="src/test/java/resources/bookAppointment";
private BookApptEnhancer() {}

public static String  apptReqBody() throws IOException {
	  String baseRequestJson = Files.readString(Paths.get(bookApptPath));
	JsonNode requestNode=mapper.readTree(baseRequestJson);
	ObjectNode appointmentBody=(ObjectNode)requestNode.path("appointment");
	  phoneNumber = GeneratePhone.generateUniquePhoneNumber();
	date = dateTime.getFutureDateAndTime();
	    futureDate = date[0];
  futureTime = date[1];
	appointmentBody.put("date",futureDate );
	appointmentBody.put("time", futureTime);
	appointmentBody.put("phone", phoneNumber);
	return mapper.writeValueAsString(requestNode);
	
}
}

