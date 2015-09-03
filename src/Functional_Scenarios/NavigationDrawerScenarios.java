package Functional_Scenarios;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import App_Functions.GmailLogin;
import App_Functions.OpenHomePage;
import Page_Objects.App_Constants;
import Page_Objects.App_Data;
import Utility.EmailValidator;
import Utility.UsernameValidator;

public class NavigationDrawerScenarios extends BaseTestSanitySuite {
	// Test case info:In this test case we are verifying navigation drawer
	// functionality
	// In first test case we are verifying all root categories are clickable in
	// NAVDrawer
	// In second test case we are verifying multiple cities

	@Override
	@Test(enabled = false)
	public void executeTestCase() throws Exception {
		try {
			startTestCase("All rootcategories are clickable in NAVDrawer");
			info("executing Home page functions");
			OpenHomePage.openHomePage();
			clickClassName(App_Constants.Open_Navigation_Drawer);
			info("open navigation drawer");
			clickName(App_Constants.NavDrawer_Mobile_tablets_link);
			info("click on Mobile and tablets link");
			Assert.assertTrue(findElementByName(
					App_Constants.NavDrawer_Mobile_tablets_link).getText()
					.equals(App_Data.MTtext));
			info("verifying assertion");
			clickClassName(App_Constants.Open_Navigation_Drawer);
			info("open navigation drawer");
			clickName(App_Constants.NavDrawer_Kitchen_Appliances_link);
			info("click on Kitchen appliances link");
			Assert.assertTrue(findElementByName(
					App_Constants.NavDrawer_Kitchen_Appliances_link).getText()
					.equals(App_Data.KAtext));
			info("verifying assertion");
			clickClassName(App_Constants.Open_Navigation_Drawer);
			info("open navigation drawer");
			clickName(App_Constants.NavDrawer_Home_Appliances_link);
			info("click on Home appliances link");
			Assert.assertTrue(findElementByName(
					App_Constants.NavDrawer_Home_Appliances_link).getText()
					.equals(App_Data.HAtext));
			info("verifying assertion");
			clickClassName(App_Constants.Open_Navigation_Drawer);
			info("open navigation drawer");
			clickName(App_Constants.NavDrawer_TV_VideoPlayer_link);
			info("click on Tv and video appliances link");
			Assert.assertTrue(findElementByName(
					App_Constants.NavDrawer_TV_VideoPlayer_link).getText()
					.equals(App_Data.TVVtext));
			info("verifying assertion");
			clickClassName(App_Constants.Open_Navigation_Drawer);
			info("open navigation drawer");
			clickName(App_Constants.NavDrawerComputerAccessorieslink_name);
			info("click on Computer Acessories link");
			Assert.assertTrue(findElementByName(
					App_Constants.NavDrawerComputerAccessorieslink_name)
					.getText().equals(App_Data.CAtext));
			info("verifying assertion");
			clickClassName(App_Constants.Open_Navigation_Drawer);
			info("open navigation drawer");
			clickName(App_Constants.NavDrawerPersonalCare_name);
			info("click on Personal care link");
			Assert.assertTrue(findElementByName(
					App_Constants.NavDrawerPersonalCare_name).getText().equals(
					App_Data.PCtext));
			info("verifying assertion");
			endTestCase("All rootcategories are clickable in NAVDrawer");

		} catch (Exception e) {
			e.getMessage();
			takeSnapShot("D:\\takeScreenshots",
					"Root Categories in Navigation drawer");
			throw (e);
		}

	}

	@Test(enabled = false)
	public void gmailLoginFromNavDrawer() {
		try {
			startTestCase("gmailLoginFromNavDrawer");
			info("executing home functions");
			OpenHomePage.openHomePage();
			clickClassName(App_Constants.Open_Navigation_Drawer);
			info("open navigation drawer");
			clickId(App_Constants.NavDrawer_Login_button_id);
			info("clicking on Login text on nav drawer");
			GmailLogin.gmailLogin();
			info("appying gmail functions");
			String text = findElementById(App_Constants.UserEmailtext_id)
					.getText();
			EmailValidator em = new EmailValidator();
			boolean valid = em.validate(text);
			info("validating email id");
			Assert.assertEquals(valid, true);
			info("verifying assertion");
			clickClassName(App_Constants.BackButton_class);
			info("clicking back button");
			clickClassName(App_Constants.Open_Navigation_Drawer);
			info("open navigation drawer");
			String text1 = findElementById(
					App_Constants.NavDrawer_Login_button_id).getText();
			System.out.println(text1);
			UsernameValidator uv = new UsernameValidator();
			boolean valid1 = uv.validate(text1);
			info("applying validator");
			Assert.assertEquals(valid1, true);
			info("applying assertions");

			endTestCase("gmailLoginFromnavDrawer");

		} catch (Exception e) {
			e.getMessage();
			takeSnapShot("D:\\takeScreenshots", "GmailLoginFromNavDrawer");
			throw (e);
		}

	}

	@Test(enabled = false)
	public void normalUserLogin() {
		try {
			startTestCase("normalUserLogin");
			info("Opening home page of app");
			OpenHomePage.openHomePage();
			clickClassName(App_Constants.Open_Navigation_Drawer);
			info("open navigation drawer");
			clickId(App_Constants.NavDrawer_Login_button_id);
			info("clicking on Login text on nav drawer");
			sendKeysForName(App_Constants.Email_name, App_Data.username);
			info("entering username");
			sendKeysForXpath(App_Constants.Password_xpath, App_Data.password);
			info("entering password");
			clickName(App_Constants.LoginButton_name);
			info("clicking on login button");
			String text = findElementById(App_Constants.UserEmailtext_id)
					.getText();
			EmailValidator em = new EmailValidator();
			boolean valid = em.validate(text);
			System.out.println(valid);
			info("validating email id");
			Assert.assertEquals(valid, true);
			info("verifying assertion");
			clickClassName(App_Constants.BackButton_class);
			info("clicking back button");
			clickClassName(App_Constants.Open_Navigation_Drawer);
			info("open navigation drawer");
			String text1 = findElementById(
					App_Constants.NavDrawer_Login_button_id).getText();
			System.out.println(text1);
			UsernameValidator uv = new UsernameValidator();
			boolean valid1 = uv.validate(text1);
			info("applying validator");
			Assert.assertEquals(valid1, true);
			info("applying assertions");
			endTestCase("normalUserLogin");

		} catch (Exception e) {
			e.getMessage();
			takeSnapShot("D:\\takeScreenshots", "normalUserLogin");
			throw (e);
		}
	}

	@Test(enabled = false)
	public void facebook() {
		// startTestCase("gmailLoginFromNavDrawer");
		// info("executing home functions");
		OpenHomePage.openHomePage();
		clickClassName(App_Constants.Open_Navigation_Drawer);
		info("open navigation drawer");
		clickId(App_Constants.NavDrawer_Login_button_id);
		info("clicking on Login text on nav drawer");
		driver.findElement(By.xpath(App_Constants.Facebook_button_xpath))
				.click();
		Set<String> handles = driver.getContextHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (handle.contains("WEBVIEW")) {

				// driver.context((String) handles.toArray()[1]);
				driver.switchTo().window(handle);
				System.out.println("mobile web view");
			}
		}

	}

	@Test(enabled = false)
	public void trendingProductsScreen() {
		try {
			startTestCase("trendingProductScreen");
			info("Opening home page of app");
			OpenHomePage.openHomePage();
			clickClassName(App_Constants.Open_Navigation_Drawer);
			info("open navigation drawer");
			clickId(App_Constants.NavDrawerHomeIcon_id);
			info("click on Home button");
			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.id(App_Constants.TrendingProducts_ID)));

			Assert.assertEquals(
					findElementById(App_Constants.TrendingProducts_ID)
							.getText(), App_Data.TrendingProductstext);
			endTestCase("trendingProductsScreen");

		} catch (Exception e) {
			e.getMessage();
			takeSnapShot("D:\\takeScreenshots", "normalUserLogin");
			throw (e);

		}
	}
	
	@Test
	public void viewPopularAndMoreCategory(){
		try{
			startTestCase("viewPopularAndMoreCategory");
			info("calling home page function");
			OpenHomePage.openHomePage();
			String [] categories = {App_Constants.NavDrawer_Mobile_tablets_link,App_Constants.NavDrawer_Kitchen_Appliances_link,App_Constants.NavDrawer_Home_Appliances_link,App_Constants.NavDrawer_TV_VideoPlayer_link,App_Constants.NavDrawerComputerAccessorieslink_name,App_Constants.NavDrawerPersonalCare_name};
			for(String category: categories){
			clickClassName(App_Constants.Open_Navigation_Drawer);
			info("open navigation drawer");
			clickName(category);
			Assert.assertEquals(findElementById(App_Constants.PopularCategories_id).getText(), App_Data.PopularCategoriestext);
			Assert.assertEquals(findElementById(App_Constants.MoreCategories_id).getText(), App_Data.MoreCategoriestext);
			Assert.assertTrue(findElementById(App_Constants.ProductionAndroid_phones_id).isEnabled());
			Assert.assertTrue(findElementById(App_Constants.Productioniphone_id).isEnabled());
			info("Verifying assertion");
			}
			endTestCase("viewPopularAndMoreCategory");
			
		}catch(Exception e){
			e.getMessage();
			takeSnapShot("D:\\takeScreenshots", "viewPopularAndMoreCategory");
			throw (e);

			
		}
		
	}

}
