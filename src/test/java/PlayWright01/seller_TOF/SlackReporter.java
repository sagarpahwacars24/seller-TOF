package PlayWright01.seller_TOF;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;



public class SlackReporter {
    private static final String SLACK_WEBHOOK_URL = "https://hooks.slack.com/services/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";
    private static final java.net.http.HttpClient HTTP_CLIENT = java.net.http.HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .version(java.net.http.HttpClient.Version.HTTP_2)
            .build();

  
    public static void sendTestResults(int passed, int failed, byte[] screenshot) {
        try {
            // 1. Build JSON payload
            String jsonPayload = buildSlackMessage(passed, failed, screenshot);
            
            // 2. Create HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(SLACK_WEBHOOK_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                    .timeout(Duration.ofSeconds(5))
                    .build();
            
            // 3. Send and handle response
            HttpResponse<String> response = HTTP_CLIENT.send(
                    request, 
                    HttpResponse.BodyHandlers.ofString()
            );
            
            // 4. Verify successful delivery
            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                System.out.println("✅ Slack notification sent successfully");
            } else {
                System.err.println("❌ Failed to send notification. Status: " + response.statusCode());
                System.err.println("Response: " + response.body());
            }
        } catch (Exception e) {
            System.err.println("⚠️ Error sending to Slack:");
            e.printStackTrace();
        }
        }
        private static String buildSlackMessage(int passed, int failed, byte[] screenshot) {
            StringBuilder sb = new StringBuilder("{");
            sb.append("\"text\":\"Test Execution Results\\n");
            sb.append("• ✅ Passed: ").append(passed).append("\\n");
            sb.append("• ❌ Failed: ").append(failed).append("\"");
            
            sb.append("}");
            return sb.toString();
        }
    }
