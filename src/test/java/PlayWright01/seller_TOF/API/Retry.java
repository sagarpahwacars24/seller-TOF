package PlayWright01.seller_TOF.API;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Retry {
	public static Response makeApiRequestWithRetry(String endpoint, RequestSpecification requestSpec, int maxRetries) {
		int retryCount = 0;
		Response response = null;

		while (retryCount < maxRetries) {
			try {
				response = requestSpec.when().post(endpoint);

				if (response.getStatusCode() == 200 && response.getContentType().contains("application/json")) {
					break; // Only return if it's a valid JSON success response
				
				} else if (response.getStatusCode() == 502 || response.getStatusCode() == 504 || response.getStatusCode() == 503 || response.getStatusCode() == 405) {
					retryCount++;
					System.out.println("Retry attempt " + retryCount + " due to " + response.getStatusCode() + " error.");
				} else {
					break; // Exit for other errors
				}
			} catch (Exception e) {
				retryCount++;
				System.out.println("Retry attempt " + retryCount + " due to exception: " + e.getMessage());
			}

			// Delay between retries
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		return response;
	}
}