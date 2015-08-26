package Functional_Scenarios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Page_Objects.App_Constants;

abstract public class BaseTestSanitySuite {
	protected static AndroidDriver driver = null;
	protected MobileElement element;
	protected WebDriverWait wait = null;
	protected WebDriver driver1 = null;
	//protected static EventFiringWebDriver eventDriver;
	public static Logger Log = Logger.getLogger(BaseTestSanitySuite.class.getName());

	public boolean isEnabled() {
		return true;
	}

	// @org.testng.annotations.Test
	// public void initTest() {
	// if (isEnabled()) {
	// initializeDrivers();
	//
	// executeTest();
	//
	// quitTest();
	// }
	//
	// }

	public static MobileElement findElementByClassName(String className) {
		return (MobileElement) driver.findElement(By.className(className));
	}

	public static MobileElement findElementById(String id) {
		return (MobileElement) driver.findElement(By.id(id));
	}

	public static MobileElement findElementByName(String name) {
		return (MobileElement) driver.findElement(By.name(name));
	}

	public static MobileElement findElementByXpath(String xpath) {
		return (MobileElement) driver.findElement(By.xpath(xpath));
	}

	public static void clickClassName(String className) {
		findElementByClassName(className).click();
	}

	public static void clickName(String name) {
		findElementByName(name).click();
	}

	public static void clickId(String id) {
		findElementById(id).click();
	}

	public static void clickXpath(String xpath) {
		findElementByXpath(xpath).click();
	}

	public void sendKeysForID(String id, String keyword) {
		findElementById(id).sendKeys(keyword);
	}

	public void sendKeysForName(String name, String keyword) {
		findElementByName(name).sendKeys(keyword);
	}

	public void sendKeysForXpath(String xpath, String keyword) {
		findElementByXpath(xpath).sendKeys(keyword);
	}

	public void scrollTo(String textname) {
		driver.scrollToExact(textname);
	}

	public void scrollToClick(String textname) {
		driver.scrollToExact(textname).click();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void backButton() {
		driver.findElement(
				By.className(App_Constants.ProductDetailsBackbutton_class))
				.click();
	}

	public void clearForId(String id) {
		findElementById(id).clear();
	}

	public void clickCart() {
		driver.findElement(By.id(App_Constants.Cart_id)).click();
	}

	public static void swipeWithAxis(int x, int y, int z, int a, int b) {
		driver.swipe(x, y, z, a, b);
	}
	
	public static void waitForElement() throws InterruptedException{
		Thread.sleep(3000);
	}
	
	public static void longwaitForElement() throws InterruptedException{
		Thread.sleep(8000);
	}
	
	public void waitforpresenceOfElement(String name){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
	}
	
	public void waitforpresenceofxpathElement(String xpath){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}

	public static boolean verifyObjectPresent(AndroidDriver driver) {

		try {

			driver.findElement(By.linkText("+ Report Categories"));

			return true;

		} catch (Exception e) {

			return false;

		}

	}
	
	public void invisibilityOfElementLocated(String id){
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
	}

	
	@Test
	public abstract void executeTestCase() throws Exception;

	@BeforeMethod
	public AndroidDriver initializeDrivers() throws Exception {
//		ExcelUtils.setExcelFile(AppConstants.Path_TestData
//				+ AppConstants.File_TestData, "Sheet1");
		System.out.println(" Initializing Drivers for Class :"
				+ this.getClass().getSimpleName());
		DOMConfigurator.configure("log4j.xml");
		File appdir = new File("C:\\sdk\\build-tools\\android-4.4W");
		File app = new File(appdir, "app-prod-release-12600.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		// cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("platformname", "Android");
		// cap.setCapability("deviceName", "XT1033");
		cap.setCapability("deviceName", "SM-N750");
		cap.setCapability("platformVersion", "4.4.2");
		cap.setCapability("app-package", "com.zopperapp.dev");
		cap.setCapability("app-activity",
				"com.zopper.aegon.ui.activity.OnBoardingActivity");
		cap.setCapability("app", app.getAbsolutePath());
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					cap);
			info("New driver instantiated");
			//EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
			 
			//EventHandler handler = new EventHandler();
			//eventDriver.register(handler);
			// driver.get("https://www.google.com/maps/@28.6251545,77.3788139,19z");
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,10);
		info("Implicit wait applied");
		return driver;
	}

	@AfterMethod
	protected void quitTest() {
		driver.quit();
	}

	public static void startTestCase(String sTestCaseName) {

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

		Log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName
				+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

	}

	// This is to print log for the ending of the test case

	public static void endTestCase(String sTestCaseName) {

		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-"
				+ "             XXXXXXXXXXXXXXXXXXXXXX");

		Log.info("X");

		Log.info("X");

		Log.info("X");

		Log.info("X");

	}

	// Need to create these methods, so that they can be called

	public static void info(String message) {

		Log.info(message);

	}

	public static void warn(String message) {

		Log.warn(message);

	}

	public static void error(String message) {

		Log.error(message);

	}

	public static void fatal(String message) {

		Log.fatal(message);

	}

	public static void debug(String message) {

		Log.debug(message);

	}

	// public void takeSnapShot(AndroidDriver webdriver,String fileWithPath,
	// String method) throws Exception{
	public  void takeSnapShot(String fileWithPath, String method) {
		// Convert web driver object to TakeScreenshot
		try {
			WebDriver augmentedDriver = new Augmenter().augment(driver);
			TakesScreenshot scrShot = ((TakesScreenshot) augmentedDriver);

			// Call getScreenshotAs method to create image file

			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			// Move image file to new destination

			//File DestFile = new File("E:\\Screenshots\\hello.jpg");
			File DestFile = new File(fileWithPath+"\\"+ method +".jpg");
			

			// Copy file at destination

			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static AndroidDriver getDriver() {
		AndroidDriver driver = null;
		// System.out.println(" Initializing Drivers for Class :"
		// + this.getClass().getSimpleName());
		DOMConfigurator.configure("log4j.xml");
		File appdir = new File("C:\\sdk\\build-tools\\android-4.4W");
		File app = new File(appdir, "app-zopper-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		// cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("platformname", "Android");
		cap.setCapability("deviceName", "XT1033");
		cap.setCapability("platformVersion", "4.4.4");
		cap.setCapability("app-package", "com.zopperapp");
		cap.setCapability("app-activity", "activities.SplashActivity");
		cap.setCapability("app", app.getAbsolutePath());
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					cap);
			Log.info("New driver instantiated");
			// driver.get("https://www.google.com/maps/@28.6251545,77.3788139,19z");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

}

