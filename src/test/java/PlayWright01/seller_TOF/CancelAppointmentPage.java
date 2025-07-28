package PlayWright01.seller_TOF;



import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
  // Correct import path

public class CancelAppointmentPage {
    private final Page page;

    public CancelAppointmentPage(Page page) {
        this.page = page;
    }

    public void cancelAppointment() {
        try {
        	 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel")).click();
        	
        	 
            
            ExtentReportManager.logStep("pass", "Clicked Cancel button");
            
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel booking")).click();
            
            ExtentReportManager.logStep("pass", "Clicked Cancel booking button");
            
            page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("I don’t want to sell my car")).locator("span").click();
            
            ExtentReportManager.logStep("pass", "Selected cancellation reason");
            
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
            
            ExtentReportManager.logStep("pass", "Clicked Submit button");
            
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Okay")).click();
            
            ExtentReportManager.logStep("pass", "Clicked Okay button");
            
            page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("close")).click();
            
            ExtentReportManager.logStep("pass", "Closed the dialog");
        } catch (Exception e) {
            ExtentReportManager.logStep("fail", "Failed to cancel appointment: " + e.getMessage());
            ExtentReportManager.addScreenshot(page, "cancelAppointment_Failure");
            throw e;
        }
    }
}