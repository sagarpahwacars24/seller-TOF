package PlayWright01.seller_TOF;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

import PlayWright01.seller_TOF.API.Reschedule;

public class RescheduleAppointmentPage {

	  
	    private Page page;


	   
	    public RescheduleAppointmentPage(Page page) {
	        this.page = page;

	    }
	   

	    public void clickReschedule() {
	        try {
	            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("RESCHEDULE")).click();
	            ExtentReportManager.logStep("pass", "Clicked RESCHEDULE button");
	        } catch (Exception e) {
	            ExtentReportManager.logStep("fail", "Failed to click RESCHEDULE: " + e.getMessage());
	            ExtentReportManager.addScreenshot(page, "clickReschedule_Failure");
	            throw e;
	        }
	    }
	    
	 
	    
	    public void selectNearestBranch() {
	        try {
	            page.getByText("Nearest Branch").click();
	            ExtentReportManager.logStep("pass", "Selected Nearest Branch option");
	            page.getByText("MG Road Sector").click();
//	            page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^MG Road Sector 14IOCL, Haryana Agro Fuel StationSector 142\\.75 km$"))).first().click();
	            
	            ExtentReportManager.logStep("pass", "MG Road Sector 14IOCL");
	        } catch (Exception e) {
	            ExtentReportManager.logStep("fail", "Failed to select nearest branch: " + e.getMessage());
	            ExtentReportManager.addScreenshot(page, "selectNearestBranch_Failure");
	            throw e;
	        }
	    }

	    public void selectTomorrow() {
	        try {
	            Locator selectDate = page.locator("span").first();
	            if (selectDate.isVisible()) {
	                selectDate.click();
	            } else {
	                page.locator("span").nth(1).click();
	            }
	            ExtentReportManager.logStep("pass", "Selected date");

	            Locator tomorrowOption = page.getByText("Tomorrow");
	            tomorrowOption.waitFor(new Locator.WaitForOptions()
	                    .setState(WaitForSelectorState.VISIBLE)
	                    .setTimeout(5000));
	            tomorrowOption.scrollIntoViewIfNeeded();
	            tomorrowOption.click();
	            ExtentReportManager.logStep("pass", "Selected Tomorrow date");
	        } catch (Exception e) {
	            ExtentReportManager.logStep("fail", "Failed to select tomorrow date: " + e.getMessage());
	            ExtentReportManager.addScreenshot(page, "selectTomorrow_Failure");
	            throw e;
	        }
	    }

	    public void confirmAppointment() {
	        try {
	            Locator confirmButton = page.getByRole(AriaRole.BUTTON, 
	                    new Page.GetByRoleOptions().setName("CONFIRM APPOINTMENT"));
	            
	            boolean isConfirmVisible = false;
	            try {
	                confirmButton.waitFor(new Locator.WaitForOptions()
	                        .setState(WaitForSelectorState.VISIBLE)
	                        .setTimeout(3000));
	                isConfirmVisible = true;
	            } catch (Exception e) {
	                ExtentReportManager.logStep("warning", "CONFIRM APPOINTMENT not immediately visible");
	            }

	            if (!isConfirmVisible) {
	                page.getByText("Tomorrow").click();
	                ExtentReportManager.logStep("info", "Clicked Tomorrow again");
	                page.waitForTimeout(1000);
	            }

	            confirmButton.waitFor(new Locator.WaitForOptions()
	                    .setState(WaitForSelectorState.VISIBLE)
	                    .setTimeout(5000));
	            
	            while (!confirmButton.isEnabled()) {
	                ExtentReportManager.logStep("info", "Waiting for CONFIRM APPOINTMENT to be enabled");
	                page.waitForTimeout(500);
	            }

	            confirmButton.scrollIntoViewIfNeeded();
	            confirmButton.click();
	            ExtentReportManager.logStep("pass", "Confirmed appointment");
	        } catch (Exception e) {
	            ExtentReportManager.logStep("fail", "Failed to confirm appointment: " + e.getMessage());
	            ExtentReportManager.addScreenshot(page, "confirmAppointment_Failure");
	            throw e;
	        }
	    }
	    
	       
	    public void completeBooking() {
	    	 page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("PLAN_1")).first().click();
	            ExtentReportManager.logStep("pass", "Selected PLAN_1");
	            
	            page.waitForTimeout(2000);
	            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book inspection")).click();
	            ExtentReportManager.logStep("pass", "Selected Book inspection");
//	            Reschedule.rescheduleAppointment();
//	            ExtentReportManager.logStep("pass", "Reschedule appointment API");
	    }

	    
	    public void closeConfirmation() {
	        try {
	            Locator cross = page.locator("svg.sc-cvzDha.fKKpst");
	            
	            cross.waitFor(new Locator.WaitForOptions()
	                    .setState(WaitForSelectorState.VISIBLE)
	                    .setTimeout(5000));
	            cross.scrollIntoViewIfNeeded();
	            cross.click(new Locator.ClickOptions().setForce(true));
	            ExtentReportManager.logStep("pass", "Closed confirmation dialog");
	        } catch (Exception e) {
	            ExtentReportManager.logStep("fail", "Failed to close confirmation: " + e.getMessage());
	            ExtentReportManager.addScreenshot(page, "closeConfirmation_Failure");
	            throw e;
	        }
	    }
	}