package PlayWright01.seller_TOF.API;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class leadUpdate {
	private static final String BASE_URI = "https://lead-service-java-stage.qac24svc.dev";
//    private static final String ENDPOINT = "update-lead?source=original-sell-online&token={token}";
    private static final String username = "retail";
    private static final String password = "WPomSQw13RELGWxJd1_yD3aXmIpRsWCW";
    
   
    private static final String AUTHORIZATION = "Basic " + java.util.Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
    private static final String DEVICE_CATEGORY = "m-web";
    private static final String COOKIE = "statsigStableId=4929ee09-1a67-40a3-9f02-60610b6f8103; JSESSIONID=F0291AB44F56B7150F143C23C44D82A6";
	
    
    static Response token = createLead.lead();  
	static String phoneNumber = GeneratePhone.generateUniquePhoneNumber();

	static String requestBody = String.format("""
		{
		    "phone": "%s",
		    "make_id": 21,
		    "model_id": 146,
		    "year_id": 31361,
		    "variant_id": 7704,
		    "kms": 80000,
		    "lat": null,
		    "lng": null,
		    "state_id": 2,
		    "whatsapp_consent": false,
		    "vehicle_reg_no": "AP31BP6789",
		    "rto_id": null,
		    "fullname": "Dinesh",
		    "user_city_id": 5,
		    "ans_id": 1,
		    "app_version": "10.12.5",
		    "postal_code": "201301",
		    "dup": true
		}
		""", phoneNumber);
    
    
    public static Response updateLead() {
    	
    	 RestAssured.baseURI = BASE_URI;
    	 String token = TokenManager.getToken();
    	 String ENDPOINT = String.format("/update-lead?source=original-sell-online&token=%s", token);
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
