package CreateAppointment;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;

//import PlayWright01.seller_TOF.API.GeneratePhone;
//import PlayWright01.seller_TOF.API.TokenManager;
//import PlayWright01.seller_TOF.API.createLead;
//import PlayWright01.seller_TOF.API.dateTime;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CreateLead {
	  private static final String BASE_URI = "https://lead-service-java-stage.qac24svc.dev";
	    private static final String ENDPOINT = "/create-lead?source=original";
	    private static final String BOOK_APPT_ENDPOINT = "/appointment";
	    private static final String AUTHORIZATION = "Basic cmV0YWlsOldQb21TUXcxM1JFTEdXeEpkMV95RDNhWG1JcFJzV0NX";
	    private static final String DEVICE_CATEGORY = "m-web";
	    private static final String COOKIE = "statsigStableId=4929ee09-1a67-40a3-9f02-60610b6f8103; JSESSIONID=F0291AB44F56B7150F143C23C44D82A6";
		
	    
	    private String eligiblePath;
	    private String requestPath;
	    private String outputPath;
	    private String  bookRequestPath;
	    private String completeRequestBody;
	    private String token;
//	    static String[] date;
//	    static String futureDate;
//	    static String futureTime;

	    String phoneNumber = GeneratePhone.generateUniquePhoneNumber();
	    
	    
	  
	    

	    @BeforeClass
	    public void setup() throws Exception {
	        // Initialize paths
	        eligiblePath = "src/test/java/resources/MMVY";  // Added file extension
	        requestPath = "src/test/java/resources/createLeadReqBody";        // Added file extension
	        bookRequestPath = "src/test/java/resources/bookAppointment";
	        outputPath = "src/test/java/resources/enhanced_lead.json";
	        
	        // Process files
	        JsonNode eligibleData = JsonMapperUtil.readJsonFile(eligiblePath);
	        JsonNode leadRequest = JsonMapperUtil.readJsonFile(requestPath);
	        JsonNode bookAppt =JsonMapperUtil.readJsonFile(bookRequestPath);
	        

	        this.completeRequestBody = leadRequestEnhancer.getCompleteRequestBody(
	                eligibleData, 
	                leadRequest,
	                phoneNumber,
	                "gs_eligible"
	            );
	            
	            System.out.println("Complete Request Body:");
	            System.out.println(completeRequestBody);
	            System.out.println(phoneNumber);

	    }

    
    
    
	@Test(priority=1)
	 public void createLead() {
		RestAssured.baseURI = BASE_URI;
		RequestSpecification requestSpec = given()
		            .header("Authorization", AUTHORIZATION)
		            .header("devicecategory", DEVICE_CATEGORY)
		            .header("Content-Type", ContentType.JSON)
		            .header("Cookie", COOKIE)
		            .body(completeRequestBody);
		            Response response = Retry.makeApiRequestWithRetry(ENDPOINT, requestSpec, 5);

		    if (response == null) {
		        throw new RuntimeException("API request failed after retries");
		    }
		    
		    // Extract token
		    token = response.jsonPath().getString("detail.token");
		    if (token != null) {
		        TokenManager.setToken(token);
		    } else {
		        System.err.println("Token extraction failed");
		    }
		    
		    // Validate response
		    response.then()
		        .assertThat()
		        .statusCode(200)
		        .body("type",Matchers.equalTo("success"));
		    System.out.println("API Response: " + response.getBody().asString());
		}
	
	@Test(priority=2)
	public void bookAppointment() throws IOException {
			String newBookApptReqBody  = BookApptEnhancer.apptReqBody();
			RestAssured.baseURI = BASE_URI;
			String token = TokenManager.getToken();
			 Response response = RestAssured
		    			.given()
		    			.header("authorization",AUTHORIZATION)
		    			.header("devicecategory",DEVICE_CATEGORY)
		    			.header("cookie",COOKIE)
		    			.header("Content-Type","application/json")
		                .queryParam("token", token)                
		    			.body(newBookApptReqBody)
		    			.when()
		    			.post(BOOK_APPT_ENDPOINT);
		    			String pubApptId = response.jsonPath().getString("detail.pub_appt_id");
		    		    System.out.println("Public Appointment ID: " + pubApptId);
		    		    
		    			response.then()
		    			.assertThat()
		    			.statusCode(200)
		    			 .body("type", Matchers.equalTo("success"))
		    			 .extract()
		    			 .response();
		    	  System.out.println("API Response: " + response.getBody().asString());
      
		
	}
	
	
	
	}


	