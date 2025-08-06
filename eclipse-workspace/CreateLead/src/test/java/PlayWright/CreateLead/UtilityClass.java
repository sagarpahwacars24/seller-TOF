package PlayWright.CreateLead;

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
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEdMMM");
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
	 public static void waitForAndClickElement(Page page, Locator locator, String expectedUrl, int maxRetries, int timeoutMs) {
	        // Step 1: Wait for the element to become visible
	        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(timeoutMs));
	        System.out.println("Element is now visible: " + locator.toString());

	        // Step 2: Wait for the element to become enabled
	        long startTime = System.currentTimeMillis();
	        while (!locator.isEnabled()) {
	            System.out.println("Waiting for element to be enabled...");
	            page.waitForTimeout(500); // Wait for 500ms between checks

	            if (System.currentTimeMillis() - startTime > timeoutMs) {
	                throw new RuntimeException("Timeout: Element is not enabled within the given timeout!");
	            }
	        }
	        System.out.println("Element is now enabled: " + locator.toString());

	        // Step 3: Try to click the element with retries
	        for (int i = 0; i < maxRetries; i++) {
	            locator.scrollIntoViewIfNeeded();
	            page.waitForTimeout(500); // Small delay between retries
	            try {
	                // Attempt to click the element forcefully
	                locator.click(new Locator.ClickOptions().setForce(true));
	                System.out.println("Clicked element successfully on attempt " + (i + 1));

	                // Step 4: Check if the expected condition (URL or element) is satisfied
	                if ((expectedUrl != null && page.url().contains(expectedUrl)) ||
	                        (expectedUrl == null && locator.isVisible())) {
	                    System.out.println("Click successful, stopping retries.");
	                    break;
	                }

	            } catch (Exception e) {
	                System.out.println("Click attempt " + (i + 1) + " failed, retrying...");
	                page.waitForTimeout(1000); // Wait before retrying
	            }

	            // If all retries fail, throw an exception
	            if (i == maxRetries - 1) {
	                throw new RuntimeException("Failed to click the element after " + maxRetries + " attempts.");
	            }
	        }

	        System.out.println("Finished clicking the element: " + locator.toString());
	    }
	 public static void doubleClickElement(Page page, Locator locator) {
		    locator.scrollIntoViewIfNeeded(); // Ensure the element is in view
		    locator.dblclick(); // Perform the double-click action
		    System.out.println("Double-clicked on element: " + locator.toString());
	
}
}