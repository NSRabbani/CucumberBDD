package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	public static WebDriver driver;

	public WebElement getTextDashboard() {
		return textDashboard;
	}

	public WebElement adminButton() {
		return adminButtonElement;
	}

	public WebElement getAdminButtonElement() {
		return adminButtonElement;
	}

	public WebElement addUserButton() {
		return addUserButton;
	}

	public WebElement userRoleDropdown() {
		return userRoleDropdown;
	}

	public WebElement statusDropDown() {
		return statusDropDown;
	}

	public WebElement opionAdmin() {
		return opionAdmin;
	}

	public WebElement optionEnabled() {
		return optionEnabled;
	}

	public WebElement employeeName() {
		return employeeName;
	}

	public WebElement employeeNameSuggession() {
		return employeeNameSuggession;
	}

	public WebElement userName() {
		return userName;
	}

	public WebElement password() {
		return password;
	}

	public WebElement confirmPassword() {
		return confirmPassword;
	}

	public WebElement saveButton() {
		return saveButton;
	}

	public WebElement selectEmp() {
		return selectSuggession;
	}

	public WebElement searchAdmin() {
		return searchUserName;
	}

	public WebElement searchButton() {
		return searchButton;
	}

	public WebElement adminInList() {
		return adminInList;
	}
	
	public WebElement deleteAdmin() {
		return elementDelete;
	}
	
	public WebElement acceptDelete() {
		return acceptDelete;
	}
	
	

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement textDashboard;

	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement adminButtonElement;

	@FindBy(xpath = "//*[text()=' Add ']")
	private WebElement addUserButton;

	@FindBy(xpath = "//label[text()='User Role']/../../..//div[text()='-- Select --']")
	private WebElement userRoleDropdown;

	@FindBy(xpath = "//label[text()='Status']/../../..//div[text()='-- Select --']")
	private WebElement statusDropDown;

	@FindBy(xpath = "(//span[text()='Admin'])[2]/..")
	private WebElement opionAdmin;

	@FindBy(xpath = "//span[text()='Enabled']")
	private WebElement optionEnabled;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement employeeName;

	@FindBy(xpath = "//span[text()='Orange  Test']")
	private WebElement employeeNameSuggession;

	@FindBy(xpath = "//label[text()='Username']/../../..//input")
	private WebElement userName;

	@FindBy(xpath = "//label[text()='Password']/../../..//input")
	private WebElement password;

	@FindBy(xpath = "//label[text()='Confirm Password']/../../..//input")
	private WebElement confirmPassword;

	@FindBy(xpath = "//button[text()=' Save ']")
	private WebElement saveButton;

	@FindBy(xpath = "//span[text()='Heisenberg  Miller']")
	private WebElement selectSuggession;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement searchUserName;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;

	@FindBy(xpath = "(//div[@class='oxd-table-cell oxd-padding-cell'])[2]/div")
	private WebElement adminInList;

	@FindBy(xpath = "(//button[@type='button'])[7]")
	private WebElement elementDelete;
	
	@FindBy(xpath = "//button[text()=' Yes, Delete ']")
	private WebElement acceptDelete;
	
	public AdminPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
