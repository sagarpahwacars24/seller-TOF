package PlayWright01.seller_TOF.API;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VerifyOTP {
	 private static final String BASE_URI = "https://lead-service-java-stage.qac24svc.dev";
	    private static final String AUTHORIZATION = "Basic cmV0YWlsOldQb21TUXcxM1JFTEdXeEpkMV95RDNhWG1JcFJzV0NX";
	    private static final String COOKIE = "statsigStableId=4929ee09-1a67-40a3-9f02-60610b6f8103; JSESSIONID=F0291AB44F56B7150F143C23C44D82A6";
	   
	    private static String otp ="1111";
	    static String phoneNumber = GeneratePhone.generateUniquePhoneNumber();
	    
	    static Response token = createLead.lead();  
	    
	    
	    
	    public static Response verify() {
	    	RestAssured.baseURI = BASE_URI;
	    	
	    	String token = TokenManager.getToken();
	    	String ENDPOINT = String.format("/pvt/%s/verify-otp/%s", token, otp);
	    	System.out.println(ENDPOINT);
	    	
	    	
	    	Response response = RestAssured
	    			.given()
	    			.header("Authorization",AUTHORIZATION )
	    			.header("cookie",COOKIE )
	    			
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
