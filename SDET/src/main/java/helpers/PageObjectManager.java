package helpers;

import org.openqa.selenium.WebDriver;

//import io.cucumber.core.runner.Runner;
import pom.AdminPage;
import pom.LoginPage;

public class PageObjectManager {

	WebDriver driver;

	private LoginPage log;
	private AdminPage admin;

	public PageObjectManager(WebDriver driver2) {
System.out.println("PomofPom initialize");
		this.driver = driver2;

	}

	public LoginPage getLoginPage() {

		if (log == null) {

			log = new LoginPage(driver);
		}
		return log;

	}

	public AdminPage getAdminPage() {
		if (admin == null) {
			admin = new AdminPage(driver);
		}
		return admin;
	}

}

