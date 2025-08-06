package PlayWright01.seller_TOF.API;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Reschedule {
	private static final String BASE_URI = "https://lead-service-java-stage.qac24svc.dev";
//    private static final String ENDPOINT = "/appointment/reschedule/{{token}}";
    private static final String username = "retail";
    private static final String password = "WPomSQw13RELGWxJd1_yD3aXmIpRsWCW";
   
    private static final String AUTHORIZATION = "Basic " + java.util.Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
    private static final String DEVICE_CATEGORY = "m-web";
    private static final String COOKIE = "statsigStableId=4929ee09-1a67-40a3-9f02-60610b6f8103; JSESSIONID=F0291AB44F56B7150F143C23C44D82A6";
	
    
    static Response token = createLead.lead();  
	static String phoneNumber = GeneratePhone.generateUniquePhoneNumber();
	
	static String[] date = dateTime.getFutureDateAndTime();
	   static String futureDate = date[0];
    static String futureTime = date[1];

	static String requestBody = String.format("""
		{
    "appointment": {
        "location": 299,
        "date": "%s",
        "time": "%s",
        "pincode": 122001,
        "city_id": 5,
          "loc": 3,
"reschedule_source":"original",
"zone_id": 48
    },
    "appointment_geo": {
        "user_lat": 28.595716247558594,
        "user_lng": 77.140126953125,
       "appointment_address": "Cars24 Tech Office, CH Baktawar Singh Road, near Medanta, Medicity, Islampur Colony, Sector 38, Gurugram, Haryana, India",
        "address1": "b2-403, blossom greeens",
        "address2": "CP, near Palika Bazar"
    }
}
		""", futureDate,futureTime);
    
    
    public static Response rescheduleAppointment() {
    	
    	 RestAssured.baseURI = BASE_URI;
    	 BookAppointment.appointmentConfirm();
    	 String token = TokenManager.getToken();
    	 String ENDPOINT = String.format("/appointment/reschedule/%s", token);
	    	System.out.println(ENDPOINT);
    	 
    	  Response response = RestAssured
    			.given()
    			.header("authorization",AUTHORIZATION)
    			.header("devicecategory",DEVICE_CATEGORY)
    			.header("cookie",COOKIE)
    			.header("Content-Type","application/json")
    			.body(requestBody)
    			.when()
    			.put(ENDPOINT)
    			.then()
    			.assertThat()
    			.statusCode(200)
    			 .body("type", Matchers.equalTo("success"))
    			 .extract()
    			 .response();
    	  System.out.println("API Response: " + response.getBody().asString());
    			 
    	
    	  return response;
    	
    }
	
}
