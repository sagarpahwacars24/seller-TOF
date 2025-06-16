package PlayWright01.seller_TOF;


import java.util.regex.Pattern;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

import PlayWright01.seller_TOF.API.BookAppointment;
import PlayWright01.seller_TOF.API.appointmentDetail;
import PlayWright01.seller_TOF.API.geoData;
import PlayWright01.seller_TOF.API.leadDetails;
import PlayWright01.seller_TOF.API.leadUpdate;
import PlayWright01.seller_TOF.API.sellerPackage;
import PlayWright01.seller_TOF.API.storeZone;



public class CreateAppointmentPage {
	 
	    private final Page page;

	    public CreateAppointmentPage(Page page) {
	        this.page = page;
	    }

	    public void bookCarInspection() {
	        try {
	        	leadDetails.leadDetail();
	        	 ExtentReportManager.logStep("pass", "Lead details API");

	        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book inspection")).click();
	            ExtentReportManager.logStep("pass", "Clicked Book car inspection button");
	        } catch (Exception e) {
	            ExtentReportManager.logStep("fail", "Failed to book car inspection: " + e.getMessage());
	            ExtentReportManager.addScreenshot(page, "bookCarInspection_Failure");
	            throw e;
	        }
	    }

	    public void selectHomeInspection() {
	        try {
	            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Home")).click();
	            ExtentReportManager.logStep("pass", "Selected Home inspection option");
	            
	            leadUpdate.updateLead();
	            ExtentReportManager.logStep("pass", "Lead Update API");
	        } catch (Exception e) {
	            ExtentReportManager.logStep("fail", "Failed to select home inspection: " + e.getMessage());
	            ExtentReportManager.addScreenshot(page, "selectHomeInspection_Failure");
	            throw e;
	        }
	    }

	    public void enterLocationDetails() {
	        try {
	            page.getByRole(AriaRole.TEXTBOX, 
	                    new Page.GetByRoleOptions().setName("Search by area/street name/")).click();
	            ExtentReportManager.logStep("pass", "Clicked location search field");
	            
	            page.getByRole(AriaRole.TEXTBOX, 
	                    new Page.GetByRoleOptions().setName("Search by area/street name/")).fill("cars24 tech");
	            ExtentReportManager.logStep("pass", "Entered location search text");
	            
	            page.getByText("Cars24 Tech Office").click();
	            ExtentReportManager.logStep("pass", "Selected Cars24 Tech Office");
	            
	            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm location")).click();
	            ExtentReportManager.logStep("pass", "Confirmed location");

	            storeZone.storeAndZone();
	            ExtentReportManager.logStep("pass", "Store and Zone API");
	            
	            
	        } catch (Exception e) {
	            ExtentReportManager.logStep("fail", "Failed to enter location details: " + e.getMessage());
	            ExtentReportManager.addScreenshot(page, "enterLocationDetails_Failure");
	            throw e;
	        }
	    }

	    public void enterAddressDetails() {
	        try {
	            page.getByRole(AriaRole.TEXTBOX, 
	                    new Page.GetByRoleOptions().setName("House/Flat No/Street name*")).click();
	            ExtentReportManager.logStep("pass", "Clicked address field");
	            
	            page.getByRole(AriaRole.TEXTBOX, 
	                    new Page.GetByRoleOptions().setName("House/Flat No/Street name*")).fill("test 123");
	            ExtentReportManager.logStep("pass", "Entered address details");
	            
	            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit address")).click();
	            ExtentReportManager.logStep("pass", "Submitted address");
	            
	            geoData.geoDataUpdate();
	            ExtentReportManager.logStep("pass", "Geo Data update API");
	        } catch (Exception e) {
	            ExtentReportManager.logStep("fail", "Failed to enter address details: " + e.getMessage());
	            ExtentReportManager.addScreenshot(page, "enterAddressDetails_Failure");
	            throw e;
	        }
	    }
	    public void selectDateAndTime() {
	    	try {
	    	    Locator selectDate = page.locator("span").first();
	    	    Locator premiumSlot = page.getByText("PREMIUM SLOT");
	    	    Locator expressSlot = page.getByText("EXPRESS SLOT");
	    	    
	    	    if (selectDate.isVisible()) {
	    	        selectDate.click();
	    	        enterName();
	                return;
	    	      
	    	    } else if (premiumSlot.isVisible()) {
	    	        premiumSlot.click();
	    	        enterName();
	                return;
	    	    } else if (expressSlot.isVisible()) {
	    	        expressSlot.click();
	    	        enterName();
	                return;
	    	    } else {
	    	        page.getByText("Choose a slot").click(); // fallback option
	    	    }
	    	    
	    	    
	         String tomorrowFormatted = UtilityClass.SelectTomorrowDate();
	       
	            Locator today = page.getByText("Today");
	            Locator tomorrow = page.getByText("Tomorrow");
	            String dynamicDatePattern = "^" + tomorrowFormatted + "$";
	          
	            Locator specificDate = page.locator("div")
	                .filter(new Locator.FilterOptions()
	                    .setHasText(Pattern.compile(dynamicDatePattern)))
	                .first();
	            
	            if (today.isVisible()) {
	                today.click();
	            } else if (tomorrow.isVisible()) {
	                tomorrow.click();
	            } else if (specificDate.isVisible()) {
	                specificDate.click();
	            } else {
	                throw new RuntimeException("No date locator is visible");
	            }
	        

	            System.out.println("selecting slot");
	            selectTimeSlot();
	            System.out.println(" slot selected");
	           
	            ExtentReportManager.logStep("pass", "Selected time slot");
	            
	            enterName();
	            
	        } catch (Exception e) {
	            ExtentReportManager.logStep("fail", "Failed to select date and time: " + e.getMessage());
	            ExtentReportManager.addScreenshot(page, "selectDateAndTime_Failure");
	            throw e;
	        }
	    }
	    public void selectTimeSlot() {
	        final int maxAttempts = 5;
	        final String[] preferredSlots = {
	            ":00 PM - 09:00 AM",
	            ":00 PM - 10:00 AM",
	            ":00 PM - 11:00 AM",
	            ":00 PM - 12:00 AM",
	            ":00 PM - 01:00 PM",
	            ":00 PM - 02:00 PM",
	            ":00 PM - 03:00 PM",
	            ":00 PM - 04:00 PM",
	            ":00 PM - 05:00 PM",
	            ":00 PM - 06:00 PM",
	            ":00 PM - 07:00 PM",
	            ":00 PM - 08:00 PM",
	            ":00 PM - 09:00 PM",
	            ":00 PM - 10:00 PM",
	        };

	        // Pattern to match time slots (HH:MM AM/PM - HH:MM AM/PM)
	        final Pattern timeSlotPattern = Pattern.compile(
	            "^(0?[1-9]|1[0-2]):[0-5][0-9] (AM|PM) - (0?[1-9]|1[0-2]):[0-5][0-9] (AM|PM)$"
	        );

	        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
	            try {
	                // Wait for slots to be available
	                page.waitForSelector("div:has-text('-')", 
	                    new Page.WaitForSelectorOptions().setTimeout(10000));

	                // Find all potential time slots
	                Locator timeSlots = page.locator("div:has-text('-')")
	                    .filter(new Locator.FilterOptions()
	                        .setHasText(timeSlotPattern));

	                // Debug: Print all available slots
	                System.out.println("Available time slots (Attempt " + attempt + "):");
	                int slotCount = timeSlots.count();
	                for (int i = 0; i < slotCount; i++) {
	                    System.out.println("- " + timeSlots.nth(i).textContent());
	                }

	                // Try preferred slots first
	                for (String preferredSlot : preferredSlots) {
	                    for (int i = 0; i < slotCount; i++) {
	                        String slotText = timeSlots.nth(i).textContent();
	                        if (slotText.trim().equals(preferredSlot)) {
	                            if (tryClickSlot(timeSlots.nth(i), preferredSlot)) {
	                                return; // Success
	                            }
	                        }
	                    }
	                }

	                // Fallback: Click first available slot
	                if (slotCount > 0 && tryClickSlot(timeSlots.first(), timeSlots.first().textContent())) {
	                    return;
	                }

	            } catch (Exception e) {
	                if (attempt == maxAttempts) {
	                    ExtentReportManager.logStep("fail", "Failed to select time slot after " + maxAttempts + " attempts: " + e.getMessage());
	                    ExtentReportManager.addScreenshot(page, "time_slot_failure");
	                    throw new RuntimeException("Time slot selection failed", e);
	                }
	                page.waitForTimeout(2000); // Wait before retry
	            }
	            
	        }
	       
	    }

	    private boolean tryClickSlot(Locator slot, String slotText) {
	        try {
	            // Scroll into view and wait to be actionable
	            slot.scrollIntoViewIfNeeded();
	            slot.waitFor(new Locator.WaitForOptions()
	                .setState(WaitForSelectorState.ATTACHED)
	                .setTimeout(3000));

	            // Try multiple click methods
	            try {
	                slot.click();
	                if (isSlotSelected(slot)) return true;
	            } catch (Exception e) {
	                System.out.println("Standard click failed on '" + slotText + "'");
	            }

	            try {
	                slot.click(new Locator.ClickOptions().setForce(true));
	                if (isSlotSelected(slot)) return true;
	            } catch (Exception e) {
	                System.out.println("Force click failed on '" + slotText + "'");
	            }

	            try {
	                slot.evaluate("node => node.click()");
	                if (isSlotSelected(slot)) return true;
	            } catch (Exception e) {
	                System.out.println("JS click failed on '" + slotText + "'");
	            }

	        } catch (Exception e) {
	            System.out.println("Failed to interact with slot '" + slotText + "': " + e.getMessage());
	        }
	        return false;
	    }

	    private boolean isSlotSelected(Locator slot) {
	        page.waitForTimeout(500); // Allow UI to update
	        try {
	            String classValue = slot.getAttribute("class");
	            return classValue != null && 
	                   (classValue.contains("selected") || 
	                    classValue.contains("active") ||
	                    "true".equals(slot.getAttribute("aria-selected")));
	        } catch (Exception e) {
	            return false;
	        }
	        
	    }
	    
	    public void enterName() {
	    	 page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your name")).fill("Saurav");
	        	ExtentReportManager.logStep("pass", "Name Entered");
	        	
             page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book inspection")).click();
	         ExtentReportManager.logStep("pass", "Clicked PROCEED button");
	         
	         BookAppointment.appointmentConfirm();
	         ExtentReportManager.logStep("pass", "Booked Appointment API");
	    }
	        

	    public void selectPlanAndBook() {
	        try {
//	        	sellerPackage.pricePlan();
//	        	 ExtentReportManager.logStep("pass", "Seller Package API");
	        	 
	            page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("PLAN_1")).first().click();
	            ExtentReportManager.logStep("pass", "Selected PLAN_1");
	            
	            page.waitForTimeout(2000);
	            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book inspection")).click();
	            
	            page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^CONFIRMATION PENDING$")))
				.getByRole(AriaRole.IMG).click();
	
	            ExtentReportManager.logStep("pass", "Clicked Book inspection button");
	        } catch (Exception e) {
	            ExtentReportManager.logStep("fail", "Failed to select plan and book: " + e.getMessage());
	            ExtentReportManager.addScreenshot(page, "selectPlanAndBook_Failure");
	            throw e;
	        }
	    }

	    public void verifyAppointmentConfirmation() {
	        try {
	            page.getByText("Appointment id:").dblclick();
	            ExtentReportManager.logStep("pass", "Verified appointment confirmation");
	            appointmentDetail.appointmentDetailByToken();
	            ExtentReportManager.logStep("pass", "Appointment detail API");
	            
	        } catch (Exception e) {
	            ExtentReportManager.logStep("fail", "Failed to verify appointment confirmation: " + e.getMessage());
	            ExtentReportManager.addScreenshot(page, "verifyAppointmentConfirmation_Failure");
	            throw e;
	        }
	    }
	}