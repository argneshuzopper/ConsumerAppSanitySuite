package Functional_Scenarios;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DownloadFromPlayStore {
	public AndroidDriver driver;
	
	@Test
	public void downloadFromPlayStore(){
		//File appdir = new File("C:\\sdk\\build-tools\\android-4.4W");
		//File app = new File(appdir, "GooglePlayStore_5.8.8.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability("platformname", "Android");
		// cap.setCapability("deviceName", "XT1033");
		cap.setCapability("deviceName", "SM-N750");
		cap.setCapability("platformVersion", "4.4.2");
		//cap.setCapability("app-package", "com.android.vending");
		//cap.setCapability("app-activity","com.android.vending.AssetBrowserActivity");
	//	cap.setCapability("app", app.getAbsolutePath());
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					cap);
			driver.get("https://play.google.com/store/apps/details?id=com.zopperapp");
			///info("New driver instantiated");
			//EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
			 
			//EventHandler handler = new EventHandler();
			//eventDriver.register(handler);
			// driver.get("https://www.google.com/maps/@28.6251545,77.3788139,19z");
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.name("Install")).click();
		driver.quit();
		//wait = new WebDriverWait(driver,10);
		//info("Implicit wait applied");
	}

}
