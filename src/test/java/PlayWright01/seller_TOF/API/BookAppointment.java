package PlayWright01.seller_TOF.API;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BookAppointment {
	private static final String BASE_URI = "https://lead-service-java-stage.qac24svc.dev";
    private static final String ENDPOINT = "/appointment";
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
        "date": "%s",
        "device_category": "m-web",
        "fullname": "Customer",
        "loc": 3,
         "location": 299,
       
        "phone": "%s",
        "time": "%s",
         "zone_id": 48,
         
        "appointment_type": "original",
        "whatsapp_consent": true,
        "pincode": "122001",
        "gaClientId": "1501695385.1742996388",
        "cibil_consent": "yes",
        "service_history_consent": true,
        "autoverify":"yes"
    },
    "appointment_geo": {
        "user_lat": 28.4410323,
        "user_lng": 77.03964049999999,
        "appointment_address": "Cars24 Tech Office, CH Baktawar Singh Road, near Medanta, Medicity, Islampur Colony, Sector 38, Gurugram, Haryana, India",
        "address1": "ccc",
        "address2": null,
        "address_type": "home"
    }
}
		""",futureDate, phoneNumber,futureTime);
    

    
    public static Response appointmentConfirm() {
    	
    	 RestAssured.baseURI = BASE_URI;
    	 String token = TokenManager.getToken();

    	 
    	  Response response = RestAssured
    			.given()
    			.header("authorization",AUTHORIZATION)
    			.header("devicecategory",DEVICE_CATEGORY)
    			.header("cookie",COOKIE)
    			.header("Content-Type","application/json")
                .queryParam("token", token)                
    			.body(requestBody)
    			.when()
    			.post(ENDPOINT)
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
