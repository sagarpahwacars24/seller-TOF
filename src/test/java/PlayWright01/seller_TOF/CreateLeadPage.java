package PlayWright01.seller_TOF;



import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import PlayWright01.seller_TOF.API.VerifyOTP;
import PlayWright01.seller_TOF.API.createLead;
import PlayWright01.seller_TOF.API.kmRange;
import PlayWright01.seller_TOF.API.make;
import PlayWright01.seller_TOF.API.model;
import PlayWright01.seller_TOF.API.rto;
import PlayWright01.seller_TOF.API.sendOTP;
import PlayWright01.seller_TOF.API.states;
import PlayWright01.seller_TOF.API.userCity;
import PlayWright01.seller_TOF.API.variant;
import PlayWright01.seller_TOF.API.year;


public class CreateLeadPage {
	private final Page page;
    private final String phoneNumber;
//    private UtilityClass UtilityClass;

    
    
    public CreateLeadPage(Page page, String phoneNumber) {
        this.page = page;
        this.phoneNumber = phoneNumber;
    }
    
    UtilityClass  UtilityClass = new UtilityClass();

    public void selectCarDetails() {
        try {
//          calling make API here
            make.callMakeApi();
            ExtentReportManager.logStep("pass", "Make API");
            
            page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("MARUTI SUZUKI")).click();
            ExtentReportManager.logStep("pass", "Selected MARUTI SUZUKI brand");
            
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("skip")).click();
            ExtentReportManager.logStep("pass", "Clicked skip button");
            
            year.makeYear();
            ExtentReportManager.logStep("pass", "Year API");
            page.getByText("2023").click();
            ExtentReportManager.logStep("pass", "Selected year 2023");
            
            model.makeModel();
            ExtentReportManager.logStep("pass", "model API");
            page.getByText("Alto").first().click();
            ExtentReportManager.logStep("pass", "Selected Alto model");
            
            variant.makeVariant();
            ExtentReportManager.logStep("pass", "variant API");
            page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Petrol")).click();
            ExtentReportManager.logStep("pass", "Selected Petrol fuel type");
            
            page.getByText("LXI O").click();
            ExtentReportManager.logStep("pass", "Selected LXI O variant");
            
            
        } catch (Exception e) {
            ExtentReportManager.logStep("fail", "Failed to select car details: " + e.getMessage());
            ExtentReportManager.addScreenshot(page, "selectCarDetails_Failure");
            throw e;
        }
    }

    public void enterLocationDetails() {
        try {
        	states.makeState();
        	ExtentReportManager.logStep("pass", "State API");
            page.getByText("HR Haryana").click();
            ExtentReportManager.logStep("pass", "Selected HR Haryana location");
            
            rto.makeRTO();
            ExtentReportManager.logStep("pass", "RTO API");
            page.getByText("26").click();
            ExtentReportManager.logStep("pass", "Selected 26 registration");
            
            kmRange.makeKM();
            ExtentReportManager.logStep("pass", "KM API");
            page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("- 30,000 km")).click();
            ExtentReportManager.logStep("pass", "Selected mileage range");
            
            userCity.makeUserCity();
            ExtentReportManager.logStep("pass", "City API");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Noida Noida")).click();
            ExtentReportManager.logStep("pass", "Selected Noida city");
            
            page.getByText("-2 weeks").click();
            ExtentReportManager.logStep("pass", "Selected purchase timeframe");
        } catch (Exception e) {
            ExtentReportManager.logStep("fail", "Failed to enter location details: " + e.getMessage());
            ExtentReportManager.addScreenshot(page, "enterLocationDetails_Failure");
            throw e;
        }
    }

    public void enterPhoneNumberAndSubmit() {
        try {
        	
            page.getByRole(AriaRole.TEXTBOX).click();
            page.getByRole(AriaRole.TEXTBOX).fill(phoneNumber);
            ExtentReportManager.logStep("pass", "Entered phone number: " + phoneNumber);
            
            
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("PROCEED")).click();
            ExtentReportManager.logStep("pass", "Clicked GET CAR PRICE button");
            
            sendOTP.OTP();
            ExtentReportManager.logStep("pass", "Send-OTP API");
        } catch (Exception e) {
            ExtentReportManager.logStep("fail", "Failed to enter phone number: " + e.getMessage());
            ExtentReportManager.addScreenshot(page, "enterPhoneNumber_Failure");
            throw e;
        }
    }

    public void enterOTPAndContinue() {
    	createLead.lead();
        ExtentReportManager.logStep("pass", "CreateLead API");
        try {
//        	page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("0")).first().fill("1");
            for (int i = 0; i < 4; i++) {
                page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("0")).nth(i).fill("1");
            }
            
            ExtentReportManager.logStep("pass", "Entered OTP successfully");
            
            VerifyOTP.verify();
            ExtentReportManager.logStep("pass", "Verify-OTP API");
           
           
//        } catch (Exception e) {
//            ExtentReportManager.logStep("fail", "Failed to enter OTP: " + e.getMessage());
//            ExtentReportManager.addScreenshot(page, "enterOTP_Failure");
//            throw e;
//        }
//    }
//
//    public void completeQuestionnaire() {
//        try {
            
//        	Locator locator=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("I've used it for too long"));
//        	
//        	PlayWright01.seller_TOF.UtilityClass.waitForAndClickElement(page, locator, 5); 
            
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Planning to buy a new car")).click();
            ExtentReportManager.logStep("pass", "Selected Role");
            
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Doctor")).click();
            ExtentReportManager.logStep("pass", "Selected profession");
            
            
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Skip this question")).first().click();
            
            ExtentReportManager.logStep("pass", "Skipped question");
            
            
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Skip this question")).click();
            ExtentReportManager.logStep("pass", "Clicked on ggs");
//            
//            page.locator("div")
//                .filter(new Locator.FilterOptions().setHasText("^0\\/500Skip this questionContinue$"))
//                .getByRole(AriaRole.LINK).click();
            ExtentReportManager.logStep("pass", "Skipped question");
        } catch (Exception e) {
            ExtentReportManager.logStep("fail", "Failed to complete questionnaire: " + e.getMessage());
            ExtentReportManager.addScreenshot(page, "completeQuestionnaire_Failure");
            throw e;
        }
    }

    public void clickContinueButton() {
        try {

//    		Locator continueButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue"))
//    				.first();
    		Locator continueButton = page.locator("(//p[contains(text(),'Skip this question')])[2]");
    				
    		
//            
            ExtentReportManager.logStep("info", "Waiting for Continue button to be enabled");
//            
            createLead.lead();
            
            PlayWright01.seller_TOF.UtilityClass.waitForAndClickElement(page, continueButton, 5);
         
           
            
//            ExtentReportManager.logStep("info", "Attempting to click Continue button");
//            PlayWright01.seller_TOF.UtilityClass.waitForAndClickElement(page, continueButton, 5);
            
            ExtentReportManager.logStep("pass", "Continue button clicked successfully");
        } catch (Exception e) {
            ExtentReportManager.logStep("fail", "Failed to click Continue button: " + e.getMessage());
            ExtentReportManager.addScreenshot(page, "clickContinue_Failure");
            throw e;
        }
    }
}