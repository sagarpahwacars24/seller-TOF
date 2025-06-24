package PlayWright01.seller_TOF;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class UtilityClass {
	public static void main(String[] args) {
		System.out.println("Generated Unique Phone Number: " + generateUniquePhoneNumber());
	}

	private static final Set<String> generatedNumbers = new HashSet<>();
	private static final Random random = new Random();

	public static String generateUniquePhoneNumber() {
		String phoneNumber;
		do {
			// Ensure the first digit is between 6 and 9
			int firstDigit = 6 + random.nextInt(4); // 6, 7, 8, or 9

			// Generate the remaining 9 digits
			StringBuilder sb = new StringBuilder();
			sb.append(firstDigit);
			for (int i = 1; i < 10; i++) {
				int digit = random.nextInt(10); // Random digit between 0 and 9
				sb.append(digit);
			}
			phoneNumber = sb.toString();
		} while (generatedNumbers.contains(phoneNumber)); // Ensure uniqueness

		generatedNumbers.add(phoneNumber);
		return phoneNumber;

	}
	
	public static String SelectTomorrowDate() {
	  
	        // Get tomorrow's date
	        LocalDate tomorrow = LocalDate.now().plusDays(2);

	        // Format it as "EEE d MMM" (e.g., "Sat 22 Mar")
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEd MMM");
	        String tomorrowFormatted = tomorrow.format(formatter);
	       return tomorrowFormatted;
 
	}
	public static void waitForElement(Page page, Locator locator, int timeout) {
	    locator.waitFor(new Locator.WaitForOptions()
	        .setState(WaitForSelectorState.VISIBLE) // Use the enum here
	        .setTimeout(timeout));
	    System.out.println("Element is visible: " + locator.toString());
	}

	
	public static void clickElement(Page page, Locator locator) {
        locator.scrollIntoViewIfNeeded();
        locator.click();
        System.out.println("Clicked element: " + locator.toString());
    }
	public static void fillElement(Page page, Locator locator, String value) {
        locator.fill(value);
        System.out.println("Filled element with value: " + value);
    }
	 public static boolean isElementEnabled(Page page, Locator locator, int timeoutMs) {
	        long startTime = System.currentTimeMillis();
	        while (!locator.isEnabled()) {
	            System.out.println("Waiting for element to be enabled: " + locator.toString());
	            page.waitForTimeout(500);

	            if (System.currentTimeMillis() - startTime > timeoutMs) {
	                System.out.println("Timeout reached waiting for element to be enabled.");
	                return false;
	            }
	        }
	        return true;
	    }
	 
	 public static boolean isElementVisible(Page page, Locator locator) {
	        try {
	            locator.scrollIntoViewIfNeeded();
	            boolean isVisible = locator.isVisible();
	            System.out.println("Element visibility: " + isVisible);
	            return isVisible;
	        } catch (Exception e) {
	            System.out.println("Error while checking visibility: " + e.getMessage());
	            return false;
	        }
	    }
	 public static void waitForAndClickElement(Page page, Locator locator, int maxRetries) {
		    if (!page.url().contains("questionarre")) {
		        System.out.println("Skipping click - not on questionnaire page");
		        return;
		    }

		    try {
		        // Initial visibility check with longer timeout
		        locator.waitFor(new Locator.WaitForOptions()
		            .setState(WaitForSelectorState.VISIBLE)
		            .setTimeout(5000));
		    } catch (Exception e) {
		        throw new RuntimeException("Element never became visible: " + e.getMessage());
		    }

		    for (int attempt = 1; attempt <= maxRetries; attempt++) {
		        try {
		            System.out.println("Click attempt " + attempt);
		            
		            // Reduced visibility check for subsequent attempts
		            if (attempt > 1) {
		                locator.waitFor(new Locator.WaitForOptions()
		                    .setState(WaitForSelectorState.VISIBLE)
		                    .setTimeout(1000));
		            }

		            // Force click with visual feedback
		            locator.scrollIntoViewIfNeeded();
		            page.mouse().click(
		                locator.boundingBox().x + 5,
		                locator.boundingBox().y + 5
		            );
		            
		            System.out.println("Click executed");
		            
		            // Immediate success check
		            if (!page.url().contains("questionarre")) {
		                System.out.println("Navigation detected - stopping retries");
		                return;
		            }
		            
		            // Brief pause for same-page state changes
		            page.waitForTimeout(500);

		        } catch (Exception e) {
		            System.out.println("Attempt " + attempt + " failed: " + e.getMessage().split("\n")[0]);
		            
		            if (attempt == maxRetries) {
		                // Final check if we're still on the questionnaire page
		                if (page.url().contains("questionarre")) {
		                    throw new RuntimeException("Failed to progress after " + maxRetries + " attempts");
		                }
		                return; // If navigated away, consider successful
		            }
		            
		            page.waitForTimeout(1000);
		        }
		    }
		}
	 
	 public static void doubleClickElement(Page page, Locator locator) {
		    locator.scrollIntoViewIfNeeded(); // Ensure the element is in view
		    locator.dblclick(); // Perform the double-click action
		    System.out.println("Double-clicked on element: " + locator.toString());
	
}
	 
}