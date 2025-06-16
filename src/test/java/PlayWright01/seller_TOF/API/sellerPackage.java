package PlayWright01.seller_TOF.API;





import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class sellerPackage {

	 private static final String BASE_URI = "https://lead-service-java-stage.qac24svc.dev";
	    private static final String AUTHORIZATION = "Basic cmV0YWlsOldQb21TUXcxM1JFTEdXeEpkMV95RDNhWG1JcFJzV0NX";
	    private static final String COOKIE = "statsigStableId=4929ee09-1a67-40a3-9f02-60610b6f8103; JSESSIONID=F0291AB44F56B7150F143C23C44D82A6";
	   
	   
	    static String phoneNumber = GeneratePhone.generateUniquePhoneNumber();
	    
	   	    public static  Response pricePlan() {
	    	RestAssured.baseURI = BASE_URI;
	    	BookAppointment.appointmentConfirm();
	    	String token = TokenManager.getToken();
	    	String ENDPOINT = String.format("/api/v1/seller-package/product-page/%s", token);
	    	System.out.println(ENDPOINT);

	    	
	    	
	    	Response response = RestAssured
	    			.given()
	    			.header("Authorization",AUTHORIZATION )
	    			.header("cookie",COOKIE )
	    			.header("Content-Type","application/json")
	    			
	    			.when()
	    			.get(ENDPOINT)
	    			.then()
//	    			.assertThat()
//	    			.statusCode(200)
	                .extract()
	                .response();

	        System.out.println("API Response: " + response.getBody().asString());
	        return response;
	    }
}
