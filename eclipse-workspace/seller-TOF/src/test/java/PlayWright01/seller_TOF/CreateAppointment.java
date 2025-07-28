package PlayWright01.seller_TOF;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAppointment extends BaseClass {
	private String phoneNumber;
    private CreateLeadPage createLeadPage;
    private CreateAppointmentPage createAppointmentPage;
    private RescheduleAppointmentPage rescheduleAppointmentPage;
    private CancelAppointmentPage cancelAppointmentPage;

    @BeforeMethod
    public void initializePages() {
        try {
            phoneNumber = UtilityClass.generateUniquePhoneNumber();
            createLeadPage = new CreateLeadPage(page, phoneNumber);
            createAppointmentPage = new CreateAppointmentPage(page);
            rescheduleAppointmentPage = new RescheduleAppointmentPage(page);
            cancelAppointmentPage = new CancelAppointmentPage(page);
            ExtentReportManager.logStep("info", "Pages initialized successfully");
        } catch (Exception e) {
            ExtentReportManager.logStep("fail", "Failed to initialize pages: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 1, description = "Create a new lead for car selling")
    public void createLead() {
    	
        try {
            ExtentReportManager.logStep("info", "Starting createLead test");
            
            createLeadPage.selectCarDetails();
            ExtentReportManager.logStep("pass", "Car details selected successfully");
            
            createLeadPage.enterLocationDetails();
            ExtentReportManager.logStep("pass", "Location details entered successfully");
            
            createLeadPage.enterPhoneNumberAndSubmit();
            ExtentReportManager.logStep("pass", "Phone number submitted successfully");
            
            createLeadPage.enterOTPAndContinue();
            ExtentReportManager.logStep("pass", "OTP entered successfully");
            
            createLeadPage.clickContinueButton();
            ExtentReportManager.logStep("pass", "Continue button clicked successfully");          
         
           
            
            ExtentReportManager.logStep("pass", "createLead test completed successfully");
        } catch (Exception e) {
            ExtentReportManager.logStep("fail", "createLead test failed: " + e.getMessage());
            ExtentReportManager.addScreenshot(page, "createLead_Failure");
            throw e;
        }
    }

    @Test(priority = 2, dependsOnMethods = "createLead", description = "Create appointment for car inspection")
    public void createAppointment() {
        try {
            ExtentReportManager.logStep("info", "Starting createAppointment test");
            
            createAppointmentPage.bookCarInspection();
            ExtentReportManager.logStep("pass", "Car inspection booked");
            
            createAppointmentPage.selectHomeInspection();
            ExtentReportManager.logStep("pass", "Home inspection selected");
            
            createAppointmentPage.enterLocationDetails();
            ExtentReportManager.logStep("pass", "Location details entered");
            
            createAppointmentPage.enterAddressDetails();
            ExtentReportManager.logStep("pass", "Address details entered");
            
            createAppointmentPage.selectDateAndTime();
            ExtentReportManager.logStep("pass", "Date and time selected");
            
//            createAppointmentPage.enterName();
//            ExtentReportManager.logStep("pass", "Name entered");
            
//            createAppointmentPage.selectPlanAndBook();
//            ExtentReportManager.logStep("pass", "Plan selected and booked");
            
            createAppointmentPage.verifyAppointmentConfirmation();
            ExtentReportManager.logStep("pass", "Appointment confirmation verified");
            
            ExtentReportManager.logStep("pass", "createAppointment test completed successfully");
        } catch (Exception e) {
            ExtentReportManager.logStep("fail", "createAppointment test failed: " + e.getMessage());
            ExtentReportManager.addScreenshot(page, "createAppointment_Failure");
            throw e;
        }
    }

    @Test(priority = 3, dependsOnMethods = "createAppointment", description = "Reschedule the appointment")
    public void rescheduleAppointment() {
        try {
            ExtentReportManager.logStep("info", "Starting rescheduleAppointment test");
            
            rescheduleAppointmentPage.clickReschedule();
            ExtentReportManager.logStep("pass", "Clicked on reschedule button");
            
            rescheduleAppointmentPage.selectNearestBranch();
            ExtentReportManager.logStep("pass", "Nearest branch selected");
            
            rescheduleAppointmentPage.selectTomorrow();
            ExtentReportManager.logStep("pass", "Tomorrow date selected");
            
            rescheduleAppointmentPage.confirmAppointment();
            ExtentReportManager.logStep("pass", "Appointment confirmed");
            
//            rescheduleAppointmentPage.completeBooking();
//            ExtentReportManager.logStep("pass", "Booking completed");
            
            rescheduleAppointmentPage.closeConfirmation();
            ExtentReportManager.logStep("pass", "Confirmation closed");
            
            ExtentReportManager.logStep("pass", "rescheduleAppointment test completed successfully");
        } catch (Exception e) {
            ExtentReportManager.logStep("fail", "rescheduleAppointment test failed: " + e.getMessage());
            ExtentReportManager.addScreenshot(page, "rescheduleAppointment_Failure");
            throw e;
        }
    }

    @Test(priority = 4, dependsOnMethods = "rescheduleAppointment", description = "Cancel the appointment")
    public void cancelAppointment() {
        try {
            ExtentReportManager.logStep("info", "Starting cancelAppointment test");
            
            cancelAppointmentPage.cancelAppointment();
            ExtentReportManager.logStep("pass", "Appointment cancelled successfully");
            
            ExtentReportManager.logStep("pass", "cancelAppointment test completed successfully");
        } catch (Exception e) {
            ExtentReportManager.logStep("fail", "cancelAppointment test failed: " + e.getMessage());
            ExtentReportManager.addScreenshot(page, "cancelAppointment_Failure");
            throw e;
        }
    }
}
