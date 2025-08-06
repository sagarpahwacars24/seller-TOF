package PlayWright01.seller_TOF.API;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class geoData {
	 private static final String BASE_URI = "https://lead-service-java-stage.qac24svc.dev";
//	 private static final String ENDPOINT = "/lead/{token}/geo-data";
	  private static final String DEVICE_CATEGORY = "m-web";
	    private static final String AUTHORIZATION = "Basic cmV0YWlsOldQb21TUXcxM1JFTEdXeEpkMV95RDNhWG1JcFJzV0NX";
	    private static final String COOKIE = "statsigStableId=4929ee09-1a67-40a3-9f02-60610b6f8103; JSESSIONID=F0291AB44F56B7150F143C23C44D82A6";
	   
	 
	    static Response token = createLead.lead();  
	    
	    static String requestBody = String.format("""
				{
  "userLat": 28.44118,
  "userLng": 77.03982,
  "geoAddress": "Cars24 Corporate Head Office, Tower C, 7th Floor, SAS Building, Ch Baktawar Singh Rd, Medicity, I, Sector 38, Gurugram, Haryana, 122005, India",
  "address1": "cc1234",
  "address2": "",
  "addressType": "home"
}""");
	    
	    
	    
	    public static Response geoDataUpdate() {
	    	RestAssured.baseURI = BASE_URI;
	    	
	    	String token = TokenManager.getToken();
	    	String ENDPOINT = String.format("/lead/%s/geo-data", token);
	    	System.out.println(ENDPOINT);
	    	
	    	
	    	Response response = RestAssured
	    			.given()
	    			 .header("Authorization", AUTHORIZATION)
	                    .header("devicecategory", DEVICE_CATEGORY)
	                    .header("Content-Type", ContentType.JSON)
	                    .header("Cookie", COOKIE)
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
