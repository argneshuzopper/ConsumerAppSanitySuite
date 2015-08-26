package Functional_Scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_Objects.App_Constants;
import Page_Objects.App_Data;

//Test case info:In this test case we are  verifying mutiple cases
//In first test case we are verifying correct location is selected and detect automatically is working
//In second test case we are verifying mutiple cities
//In third test case we are verifying that correct prompt is displayed on clicking link App displays a popup if user tap on Dont see your city in the list

public class LocationScenarios extends BaseTestSanitySuite {

	@Override
	@Test(enabled = false)
	public void executeTestCase() throws Exception {
		try {
			startTestCase(" Select location either automatically and by picking a city");
			waitforpresenceOfElement(App_Data.Skiptext);
			info("applying expilcit wait");
			clickName(App_Constants.skip_button_text);
			info("clicking on skip button");
			Assert.assertTrue(findElementByName(
					App_Constants.SelectLocation_text).getText().equals(
					App_Data.Locationtext));
			info("applying assertion");
			clickName(App_Constants.DetectAutomatically_name);
			info("clicking on Auto detect link");
			clickName(App_Constants.SkipButton_name);
			info("clicking on Skip button");
			clickClassName(App_Constants.Open_Navigation_Drawer);
			info("clicking on Nav drawer button");
			Assert.assertTrue(findElementByName(App_Constants.Hometext_name)
					.getText().equals(App_Data.Hometext));
			info("appying explicit wait");
			clickId(App_Constants.NavDrawerLocationTitle_id);
			info("clicking Navdrawer location title");
			clickName(App_Constants.BangaloreLocation_text);
			info("clicking on Banglaore location");
			Assert.assertTrue(findElementByName(App_Constants.BTMLocation_text)
					.getText().equals(App_Data.BTMtext));
			info("applying explicit wait");
			clickName(App_Constants.BTMLocation_text);
			info("clicking on BTM location");
			Assert.assertTrue(findElementById(
					App_Constants.NavDrawerLocationChild_id).getText().equals(
					App_Data.BTMtext));
			info("applying assertion for bangalore locality");
			endTestCase(" select location either automatically and by picking a city");

		} catch (Exception e) {
			e.getMessage();
			takeSnapShot("D:\\takeScreenshots", "LocationScenarios");
			throw (e);
		}

	}

	@Test(enabled = false)
	public void mutipleCities() {
		startTestCase(" Select location either automatically and by picking a city");
		waitforpresenceOfElement(App_Data.Skiptext);
		info("applying expilcit wait");
		clickName(App_Constants.skip_button_text);
		info("clicking on skip button");
		WebElement pe = driver.findElement(By
				.className("android.support.v7.widget.RecyclerView"));
		List<WebElement> ce = pe.findElements(By
				.className("android.widget.TextView"));
		WebElement ce1 = ce.get(4);
		System.out.println(ce1);

		// int i =me.size();
		// System.out.println(i);
		// for(MobileElement s: me)
		// {
		// System.out.println(s.getText());
		// }
		// Iterator<MobileElement> itr = me.iterator();
		// while(itr.hasNext()) {
		// System.out.println(itr.next());
		// }
	}

	@Test
	public void unavailableCitiesPopUpConfirmation() {
		try{
		startTestCase("App displays a popup if user tap on Dont see your city in the list");
		waitforpresenceOfElement(App_Data.Skiptext);
		info("applying expilcit wait");
		clickName(App_Constants.skip_button_text);
		info("clicking on skip button");

		for (int i = 0; i < 4; i++) {
			swipeWithAxis(0, 1000, 0, 250, 3000);
		}
		info("applying swipe function");
		clickId(App_Constants.AbsentCity_id);
		info("clicking on url ->App displays a popup if user tap on Dont see your city in the list");
		Assert.assertTrue(findElementById(App_Constants.OopsPrompt_id)
				.getText().equals(App_Data.Oopstext));
		info("appying assertion");
		endTestCase("App displays a popup if user tap on Dont see your city in the list");
		}
		catch(Exception e)
		{
			e.getMessage();
			takeSnapShot("D:\\takeScreenshots", "unavailableCitiesPopUpConfirmation");
			throw (e);
		}
			
		
	}

}
