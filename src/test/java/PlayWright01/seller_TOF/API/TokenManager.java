package PlayWright01.seller_TOF.API;

import static io.restassured.RestAssured.given;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TokenManager {
    private static final String TOKEN_FILE_PATH = "token.txt"; // File path to store the token

    // Retrieve the token from file or fetch a new one if not present
    public static String getToken() {
        try {
            // Read the token from the file
            String token = new String(Files.readAllBytes(Paths.get(TOKEN_FILE_PATH)));
            System.out.println("Token fetched from file: " + token);
            return token; // Return the token if it exists in the file
        } catch (IOException e) {
            // If file reading fails, fetch a new token
            System.err.println("❌ Token file not found or unreadable, fetching a new token...");
            return fetchNewToken(); // Fetch and return a new token
        }
    }

    // Save the token to the file
    public static void setToken(String newToken) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TOKEN_FILE_PATH))) {
            writer.write(newToken); // Write the token to the file
            System.out.println("✅ Token saved to file: " + newToken);
        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to save the token.", e);
        }
    }

    // Fetch a new token from the authentication endpoint
    private static String fetchNewToken() {
        RestAssured.baseURI = "https://your-api-endpoint.com"; // Replace with actual base URI
        String endpoint = "/auth/token"; // Replace with actual token endpoint

        // Make the POST request to fetch a new token
        Response response = given()
                .header("Content-Type", ContentType.JSON)
                .body("{\"username\": \"your-username\", \"password\": \"your-password\"}") // Replace with credentials
                .when().post(endpoint)
                .then().assertThat().statusCode(200) // Validate 200 response
                .extract().response();

        // Extract the token from the response
        String newToken = response.jsonPath().getString("access_token"); // Adjust JSON path if needed
        System.out.println("✅ New token fetched: " + newToken);

        // Save the token for future use
        setToken(newToken);

        return newToken; // Return the fetched token
    }
}
