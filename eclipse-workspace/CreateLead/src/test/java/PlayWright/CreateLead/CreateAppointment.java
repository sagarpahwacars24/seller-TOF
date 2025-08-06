
package PlayWright.CreateLead;
import java.util.regex.Pattern;
import PlayWright.CreateLead.UtilityClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

public class CreateAppointment extends BaseClass {


	@Test(priority = 1)
	public void createLead() {
		page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("MARUTI SUZUKI")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("skip")).click();
		page.getByText("2023").click();
		page.getByText("Alto").first().click();
		page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Petrol")).click();
		page.getByText("LXI O").click();
		page.getByText("HR Haryana").click();
		page.getByText("26").click();
		page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("- 30,000 km")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Noida Noida")).click();
		page.getByText("-2 weeks").click();
		page.getByRole(AriaRole.TEXTBOX).click();
		page.getByRole(AriaRole.TEXTBOX).fill(phoneNumber);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("GET CAR PRICE")).click();
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("0")).first().fill("1");
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("0")).nth(1).fill("1");
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("0")).nth(2).fill("1");
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("0")).nth(3).fill("1");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("I’ve used it for too long")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Doctor")).click();
		page.locator("div")
				.filter(new Locator.FilterOptions().setHasText(Pattern.compile("^0\\/500Skip this questionContinue$")))
				.getByRole(AriaRole.LINK).click();

		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^ggg$"))).locator("span")
				.click();
		System.out.println("clicked on ggs");

		page.locator("div")
				.filter(new Locator.FilterOptions().setHasText(Pattern.compile("^0\\/500Skip this questionContinue$")))
				.getByRole(AriaRole.LINK).click();

		Locator continueButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue"))
				.first();


		continueButton.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));


		long startTime = System.currentTimeMillis();
		long timeout = 10000; 

		while (!continueButton.isEnabled()) {
			System.out.println("Waiting for button to be enabled...");
			page.waitForTimeout(500);

			if (System.currentTimeMillis() - startTime > timeout) {
				throw new RuntimeException("Timeout: Continue button is not getting enabled!");
			}
		}
		
		for (int i = 0; i < 5; i++) {
			continueButton.scrollIntoViewIfNeeded();
			page.waitForTimeout(500); 
			try {
				continueButton.click(new Locator.ClickOptions().setForce(true)); 
				System.out.println("Clicked on Continue (Attempt " + (i + 1) + ")");

				
				if (page.url().contains("expected-url") || page.locator("expected-selector-after-click").isVisible()) {
					System.out.println("Click successful, stopping retries.");
					break;
				}

			} catch (Exception e) {
				System.out.println("Click failed on Attempt " + (i + 1) + ", retrying...");
				page.waitForTimeout(1000);
			}
		}
		System.out.println("Finished clicking Continue.");

	}

	@Test(priority = 2)
	public void CreateAppt() {
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book car inspection")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Home")).click();
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search by area/street name/")).click();
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search by area/street name/"))
				.fill("cars24 tech");
		page.getByText("Cars24 Tech Office").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm location")).click();
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("House/Flat No/Street name*")).click();
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("House/Flat No/Street name*"))
				.fill("test 123");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit address")).click();
//		      page.locator("span").first().click();
		Locator selectDate = page.locator("span").first();
		if (selectDate.isVisible()) {
			selectDate.click();
		} else {
			page.locator("span").nth(1).click();
		}
		page.getByText(":00 PM - 04:00 PM").click();

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("PROCEED")).click();

		page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("PLAN_1")).first().click();
		page.waitForTimeout(2000);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book inspection")).click();
//		     
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^CONFIRMATION PENDING$")))
				.getByRole(AriaRole.IMG).click();
		page.getByText("Appointment id:").dblclick();
	}

	@Test(priority = 3)
	public void reschedule() {
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("RESCHEDULE")).click();
		page.getByText("Nearest Branch").click();
		page.getByRole(AriaRole.LIST).locator("div")
				.filter(new Locator.FilterOptions().setHasText("Lux store gurgaonTest address")).first().click();


		Locator selectDate = page.locator("span").first();
		if (selectDate.isVisible()) {
			selectDate.click();
		} else {
			page.locator("span").nth(1).click();
		}

		
		Locator tomorrowOption = page.getByText("Tomorrow");

	
		tomorrowOption.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));


		tomorrowOption.scrollIntoViewIfNeeded();
		tomorrowOption.click();
		System.out.println("Clicked on 'Tomorrow'");

	
		page.waitForTimeout(1000);

		page.getByRole(AriaRole.LIST).locator("div")
				.filter(new Locator.FilterOptions().setHasText("Lux store gurgaonTest address")).first().click();
		tomorrowOption.click();

		Locator confirmButton = page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("CONFIRM APPOINTMENT"));

	
		boolean isConfirmVisible = false;
		try {
			confirmButton.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(3000));
			isConfirmVisible = true;
		} catch (Exception e) {
			System.out.println("⚠ CONFIRM APPOINTMENT not visible, clicking 'Tomorrow' again...");
		}


		if (!isConfirmVisible) {
			tomorrowOption.scrollIntoViewIfNeeded();
			tomorrowOption.click();
			System.out.println("Clicked on 'Tomorrow' again");
			page.waitForTimeout(1000);
		}


		confirmButton.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));


		while (!confirmButton.isEnabled()) {
			System.out.println("⏳ Waiting for 'CONFIRM APPOINTMENT' to be enabled...");
			page.waitForTimeout(500);
		}

		confirmButton.scrollIntoViewIfNeeded();
		confirmButton.click();

		System.out.println("Clicked on 'CONFIRM APPOINTMENT'");

		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^FREE₹0$"))).locator("span")
				.click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book inspection")).click();

		
		page.waitForTimeout(2000); 

		
		Locator cross = page.getByRole(AriaRole.BUTTON)
				.filter(new Locator.FilterOptions().setHasText(Pattern.compile("^$")));

		
		cross.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));

		cross.scrollIntoViewIfNeeded();
		cross.click(new Locator.ClickOptions().setForce(true));

		System.out.println("Clicked on the close button successfully!");
	}

	@Test(priority = 4)
	public void cancel() {
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("CANCEL")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel booking")).click();
		page.getByText("I’ve sold my car elsewhere").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Okay")).click();
		page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("close")).click();
	}
}
