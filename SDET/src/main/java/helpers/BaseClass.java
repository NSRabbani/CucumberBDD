package helpers;
import java.awt.AWTException;

import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;


public class BaseClass {
	public static WebDriver driver;
	public static Robot r;
	public static Actions a;
	public static Select s;
	public static JavascriptExecutor js;

//---------------------------------------------------------------------------------------------------------
	public static WebDriver getbrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
		
			driver = new EdgeDriver();
		
		}return driver;
	}
//--------------------------------------------------------------------------------------------------------
	public static void clickonelement(WebElement element) {
		element.click();
	}

	public static void passkeys(WebElement element, String input) {
		element.sendKeys(input);
	}
	
	public static void clear(WebElement element) {
		element.clear();
	}

//-------------------------------------------------------------------------------------------------------
	public static String getatt(String type, WebElement element) {
		String attributePl;
		String attributeVa;
		String out = null;
		if (type.equalsIgnoreCase("place holder")) {
			attributePl = element.getAttribute("place holder");
			out = attributePl;
		} else if (type.equalsIgnoreCase("value")) {
			attributeVa = element.getAttribute("value");
			out = attributeVa;
		}
		return out;
	}

	public static String gettext(WebElement Element) {
		String text = Element.getText();
		return text;
	}

	public static  void geturl(String input) {
		driver.get(input);
	}
	
	public static String gettitle() {

		return driver.getTitle();
		
	}
	public boolean presentOrNot(WebElement elem) {

		return elem.isDisplayed();
		
	}

	public static String currenturl(WebDriver element) {
		String currentUrl = element.getCurrentUrl();
		System.out.println(currentUrl);
		return currentUrl;
	}

//-------------------SELECT CLASS-----------------------------------------------------------------------
	public static void dropdown(String type, WebElement element, String value) {
		Select s = new Select(element);
		if (type.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
			s.selectByIndex(index);
		} else if (type.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		} else if (type.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (type.equalsIgnoreCase("deselectindex")) {
			int index = Integer.parseInt(value);
			s.deselectByIndex(index);
		} else if (type.equalsIgnoreCase("desulectvalue")) {
			s.deselectByValue(value);
		} else if (type.equalsIgnoreCase("deselecttext")) {
			s.deselectByVisibleText(value);
		} else if (type.equalsIgnoreCase("ismultiple")) {
			boolean multiple = s.isMultiple();
			System.out.println(multiple);
		}else if (type.equalsIgnoreCase("get first selected")) {
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			System.out.println(firstSelectedOption);
		}
	}

	public static WebElement getfirstselected() {
		WebElement fsl = s.getFirstSelectedOption();
		return fsl;
	}

//-------------------------ACTION CLASS---------------------------------------------------------------
	public static void moveToelement(WebElement element) {
		a.moveToElement(element).perform();
	}

	public static void clickaction(WebElement element) {
		a.click(element).perform();
	}

	public static void rightclick(WebElement element) {
		a.contextClick(element).perform();
	}

//--------------------------SCREEN SHOT----------------------------------------------------------------
	public static void Screenshot(String imagename) throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File s = t.getScreenshotAs(OutputType.FILE);
		File d = new File("D:\\Selenium\\Workspace\\Selenium\\screenst\\" + imagename + ".png");
		Files.copy(s, d);
	}

	public static void screenshotFullwindow(String file_name) throws HeadlessException, AWTException, IOException {
		BufferedImage image4 = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image4, "png",
				new File("D:\\Selenium\\Workspace\\Selenium\\screenst_buff\\" + file_name + ".png"));
	}

//-----------------------------wait--------------------------------------------------------------------	
	public static void sleep(int sec) throws InterruptedException {
		Thread.sleep(sec);
	}

//------------------------------JS click and scroll in to view---------------------------------------------------------------------
	public static void Jse(String type, WebElement element) {
		if (type.equalsIgnoreCase("click")) {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} else if ("scroll in to view".contains(type)) {
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
	}
//-----------------------------JS drag and drop------------------------------------------------------
	public static void jsDradandDrop(WebElement source, WebElement destination) {
		js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
				+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
				+ "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
				+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
				+ "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
				+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
				+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
				+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
				+ "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
				+ "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
				+ "var dropEvent = createEvent('drop');\n"
				+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
				+ "var dragEndEvent = createEvent('dragend');\n"
				+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
				+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
				+ "simulateHTML5DragAndDrop(source,destination);", source, destination);
	}
}