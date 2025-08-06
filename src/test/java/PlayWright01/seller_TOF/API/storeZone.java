package PlayWright01.seller_TOF.API;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class storeZone {
	 private static final String BASE_URI = "https://location-service-stage.qac24svc.dev";
	    private static final String ENDPOINT = "/api/v2/slots/available/store-and-zone";
	    private static final String AUTHORIZATION = "Basic cmV0YWlsOldQb21TUXcxM1JFTEdXeEpkMV95RDNhWG1JcFJzV0NX";
	    private static final String DEVICE_CATEGORY = "m-web";
	    private static final String COOKIE = "statsigStableId=4929ee09-1a67-40a3-9f02-60610b6f8103; JSESSIONID=F0291AB44F56B7150F143C23C44D82A6";
	    
	    static Response token = createLead.lead();  
	    

	    public static Response storeAndZone() {
	        RestAssured.baseURI = BASE_URI;
	        String token = TokenManager.getToken();
	        
	        

	        Response response = RestAssured
	                .given()
	                    .header("Authorization", AUTHORIZATION)
	                    .header("devicecategory", DEVICE_CATEGORY)
	                    .header("Content-Type", ContentType.JSON)
	                    .header("Cookie", COOKIE)
	                    .header("Content-Type","application/json")
	                    .queryParam("lat", "28.440961837768555")
	                    .queryParam("lng", "77.0395278930664")
	                    .queryParam("token", token)
	                    .queryParam("pincode", "201001")
	                .when()
	                    .get(ENDPOINT)
	                .then()
	                    .assertThat()
	                    .statusCode(200)
	                    .body("message", Matchers.equalTo("Zone and store level slots result"))
	                    .extract()
	                    .response();

	        System.out.println("API Response: " + response.getBody().asString());
	        return response;
	}
	}


