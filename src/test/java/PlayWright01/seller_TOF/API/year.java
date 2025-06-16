package PlayWright01.seller_TOF.API;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class year {
	 private static final String BASE_URI = "https://vehicle-service-stage.qac24svc.dev";
	    private static final String ENDPOINT = "make/21/years";
	    private static final String AUTHORIZATION = "Basic cmV0YWlsOldQb21TUXcxM1JFTEdXeEpkMV95RDNhWG1JcFJzV0NX";
	    private static final String DEVICE_CATEGORY = "m-web";
	    private static final String COOKIE = "statsigStableId=4929ee09-1a67-40a3-9f02-60610b6f8103; JSESSIONID=F0291AB44F56B7150F143C23C44D82A6";

	    public static Response makeYear() {
	        RestAssured.baseURI = BASE_URI;

	        Response response = RestAssured
	                .given()
	                    .header("Authorization", AUTHORIZATION)
	                    .header("devicecategory", DEVICE_CATEGORY)
	                    .header("Content-Type", ContentType.JSON)
	                    .header("Cookie", COOKIE)
	                .when()
	                    .get(ENDPOINT)
	                .then()
	                    .assertThat()
	                    .statusCode(200)
	                    .body("type", Matchers.equalTo("Success"))
	                    .extract()
	                    .response();

	        System.out.println("API Response: " + response.getBody().asString());
	        return response;
	}
}

