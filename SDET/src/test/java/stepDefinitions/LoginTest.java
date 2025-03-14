package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import helpers.PageObjectManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {

	static WebDriver driver = null;

	static PageObjectManager pom;

	@Before
	public void setUp() {
		System.out.println("Initialize driver");
		driver = new ChromeDriver();
		 pom = new PageObjectManager(driver);

	}

	@Given("User on login page")
	public void user_on_login_page() {
		System.out.println("step1");

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		System.out.println("step2");
		pom.getLoginPage().getUsername().sendKeys("Admin");
		pom.getLoginPage().getPassword().sendKeys("admin123");
		pom.getLoginPage().getSignIn().click();
	}

	@Then("User navigates to dashboard page")
	public void user_navigates_to_dashboard_page() {
		System.out.println("step3");

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		org.junit.Assert.assertEquals(pom.getAdminPage().getTextDashboard().getText(), "Dashboard");
	}

	@When("User add new Admin")
	public void user_add_new_admin() throws Throwable {
		System.out.println("step4");

		pom.getAdminPage().adminButton().click();
		pom.getAdminPage().addUserButton().click();
		pom.getAdminPage().userRoleDropdown().click();
		pom.getAdminPage().opionAdmin().click();
		pom.getAdminPage().statusDropDown().click();
		pom.getAdminPage().optionEnabled().click();
		pom.getAdminPage().employeeName().sendKeys("Heisenberg");
		Thread.sleep(3000);

		pom.getAdminPage().selectEmp().click();

		pom.getAdminPage().userName().sendKeys("ToBeDeleted");
		pom.getAdminPage().password().sendKeys("zxxccv1@");
		pom.getAdminPage().confirmPassword().sendKeys("zxxccv1@");
		Thread.sleep(3000);
		pom.getAdminPage().saveButton().click();
	}

	@Then("User gets added to the list")
	public void user_gets_added_to_the_list() throws Throwable {
		System.out.println("step5");

		Thread.sleep(6000);
		pom.getAdminPage().searchAdmin().sendKeys("ToBeDeleted");
		pom.getAdminPage().searchButton().click();
		String listedName = pom.getAdminPage().adminInList().getText().trim();
		assertEquals(listedName, "ToBeDeleted");

	}

	@Then("User deletes the new Admin")
	public void user_deletes_the_new_admin() {
		System.out.println("step6");

		pom.getAdminPage().deleteAdmin().click();
		pom.getAdminPage().acceptDelete().click();

	}

	@Then("user gets deleted from list")
	public void user_gets_deleted_from_list() {
		System.out.println("step7");

		pom.getAdminPage().searchButton().click();

		assertFalse(false);

	}
	

	@Then("Admin adds a new empoyee with {string} and {string}")
	public void admin_adds_a_new_empoyee_with_and(String string, String string2) {

		System.out.println(string + string2);
	
	}

	@After
	public void tearDown() {
		// Quit the WebDriver after each scenario
		if (driver != null) {
			driver.quit();
			driver = null; // Ensure the driver is set to null after quitting
		}
	}
}
