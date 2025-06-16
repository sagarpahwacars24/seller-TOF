package PlayWright01.seller_TOF.API;





import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class createLead {

	private static final String BASE_URI = "https://lead-service-java-stage.qac24svc.dev";
    private static final String ENDPOINT = "/create-lead?source=original";
    private static final String AUTHORIZATION = "Basic cmV0YWlsOldQb21TUXcxM1JFTEdXeEpkMV95RDNhWG1JcFJzV0NX";
    private static final String DEVICE_CATEGORY = "m-web";
    private static final String COOKIE = "statsigStableId=4929ee09-1a67-40a3-9f02-60610b6f8103; JSESSIONID=F0291AB44F56B7150F143C23C44D82A6";
    public static String token;
    

    public static Response lead() {
    	 
    	String phoneNumber = GeneratePhone.generateUniquePhoneNumber();

    	String requestBody = String.format("""
			{
			    "phone": "%s",
			    "make_id": 21,
			    "model_id": 146,
			    "year_id": 31361,
			    "variant_id": 7704,
			    "kms": 40000,
			    "lat": null,
			    "lng": null,
			    "state_id": 2,
			    "whatsapp_consent": false,
			    "vehicle_reg_no": "AP31BP6789",
			    "rto_id": null,
			    "fullname": "Saurav",
			    "user_city_id": 5,
			    "ans_id": 1,
			    "app_version": "10.12.5",
			    "postal_code": "201301",
			    "dup": true
			}
			""", phoneNumber);

    	RestAssured.baseURI = BASE_URI;

    	 RequestSpecification requestSpec = RestAssured
    	            .given()
    	                .header("Authorization", AUTHORIZATION)
    	                .header("devicecategory", DEVICE_CATEGORY)
    	                .header("Content-Type", ContentType.JSON)
    	                .header("Cookie", COOKIE)
    	                .body(requestBody);

    	        Response response = Retry.makeApiRequestWithRetry(ENDPOINT, requestSpec, 5);

    	        if (response != null) {
    	        	
    	        	token = response.jsonPath().getString("detail.token");
    	            System.out.println("Final API Response: " + response.getBody().asString());
    	        } else {
    	            throw new RuntimeException("API call failed after retries");
    	        }
    	        
    	    	if (token != null) {
    				TokenManager.setToken(token);

    			} else {
    				System.err.println("Token is null. Verify the JSON path and response.");
    			}

    	        return response;
    	    }
    	}
