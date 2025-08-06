package PlayWright.CreateLead;

import java.util.regex.Pattern;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CreateApptPage {
	private final Page page;

    // Constructor
    public CreateApptPage(Page page) {
        this.page = page;
    }

    // Method to book car inspection
    public void bookCarInspection(String location, String houseDetails) {
        UtilityClass.clickElement(page, page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book car inspection")));
        UtilityClass.clickElement(page, page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Home")));
        UtilityClass.clickElement(page, page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search by area/street name/")));
        UtilityClass.fillElement(page, page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search by area/street name/")), location);
        UtilityClass.clickElement(page, page.getByText(location));
        UtilityClass.clickElement(page, page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm location")));
        UtilityClass.clickElement(page, page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("House/Flat No/Street name*")));
        UtilityClass.fillElement(page, page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("House/Flat No/Street name*")), houseDetails);
        UtilityClass.clickElement(page, page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit address")));
        
        UtilityClass.clickElement(page, page.getByText(":00 PM - 04:00 PM")); // Time slot example
        UtilityClass.clickElement(page, page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("PROCEED")));
        UtilityClass.clickElement(page, page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("PLAN_1")).first());
        UtilityClass.clickElement(page, page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book inspection")));
        UtilityClass.clickElement(page, page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^CONFIRMATION PENDING$"))).getByRole(AriaRole.IMG));
        UtilityClass.doubleClickElement(page, page.getByText("Appointment id:"));
    }

    // Method to reschedule an appointment
    public void rescheduleAppointment(String newLocation) {
        UtilityClass.clickElement(page, page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("RESCHEDULE")));
        UtilityClass.clickElement(page, page.getByText("Nearest Branch"));
        UtilityClass.clickElement(page, page.getByRole(AriaRole.LIST).locator("div").filter(new Locator.FilterOptions().setHasText("Lux store gurgaonTest address")).first());
        UtilityClass.clickElement(page, page.getByText("Tomorrow"));
        UtilityClass.clickElement(page, page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("CONFIRM APPOINTMENT")));
    }
}
