package PlayWright.CreateLead;

import java.util.regex.Pattern;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CreateLeadPage {
	  private final Page page;

	    // Constructor to initialize the page
	    public CreateLeadPage(Page page) {
	        this.page = page;
	    }

	    // Methods to interact with page elements
	    public void selectCarDetails() {
	        UtilityClass.clickElement(page, page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("MARUTI SUZUKI")));
	        UtilityClass.clickElement(page,page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("skip")));
	        UtilityClass.clickElement(page, page.getByText("2023"));
	        UtilityClass.clickElement(page, page.getByText("Alto").first());
	        UtilityClass.clickElement(page, page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Petrol")));
	        UtilityClass.clickElement(page, page.getByText("LXI O"));
	        UtilityClass.clickElement(page, page.getByText("HR Haryana"));
	        UtilityClass.clickElement(page, page.getByText("26"));
	        UtilityClass.clickElement(page, page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("- 30,000 km")));
	        UtilityClass.clickElement(page, page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Noida Noida")));
	        UtilityClass.clickElement(page, page.getByText("-2 weeks"));
	    }

	    public void enterPhoneNumber(String phoneNumber) {
	        UtilityClass.clickElement(page, page.getByRole(AriaRole.TEXTBOX));
	        UtilityClass.fillElement(page, page.getByRole(AriaRole.TEXTBOX), phoneNumber);
	        UtilityClass.clickElement(page, page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("GET CAR PRICE")));
	    }

	    public void handleOTP() {
	        UtilityClass.fillElement(page, page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("0")).first(), "1");
	        UtilityClass.fillElement(page, page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("0")).nth(1), "1");
	        UtilityClass.fillElement(page, page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("0")).nth(2), "1");
	        UtilityClass.fillElement(page, page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("0")).nth(3), "1");
	    }
	    public void addQuestion() {
	    	 UtilityClass.clickElement(page,page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("I’ve used it for too long")));
	    	 UtilityClass.clickElement(page,page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Doctor")));
	    	 UtilityClass.clickElement(page,page.locator("div")
	 				.filter(new Locator.FilterOptions().setHasText(Pattern.compile("^0\\/500Skip this questionContinue$")))
					.getByRole(AriaRole.LINK));
	    	 UtilityClass.clickElement(page, page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^ggg$"))).locator("span"));
	    	 UtilityClass.clickElement(page, page.locator("div")
	 				.filter(new Locator.FilterOptions().setHasText(Pattern.compile("^0\\/500Skip this questionContinue$")))
					.getByRole(AriaRole.LINK));
	    	 UtilityClass.clickElement(page, page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^ggg$"))).locator("span"));
	    	 UtilityClass.clickElement(page, page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^ggg$"))).locator("span"));
	    	 
	    	
	    	 
	    	 
	    }
	}
