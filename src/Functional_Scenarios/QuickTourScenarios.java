package Functional_Scenarios;

import org.testng.Assert;

import org.testng.annotations.Test;

import Page_Objects.App_Constants;
import Page_Objects.App_Data;

//Test case info: In this test case we are verifying two scenarios
//1.Quick tour page should be completely scrollable
//2.User should be able to skip Quick tour page

public class QuickTourScenarios extends BaseTestSanitySuite {

	@Override
	@Test(enabled = true)
	public void executeTestCase() throws Exception {
		try {
			startTestCase("QuickTourSwipe");
			waitforpresenceOfElement(App_Data.Skiptext);
			info("applying expilicit wait");
			for (int i = 0; i < 9; i++) {
				swipeWithAxis(500, 500, 50, 500, 3000);
			}
			waitforpresenceOfElement(App_Data.LetGoShoppingtext);
			info("applying explicit wait");
			clickName(App_Constants.LetsGoShopping_text);
			info("click on lets go shopping text");
			findElementByName(App_Constants.SelectLocation_text).getText();
			Assert.assertTrue(findElementByName(App_Constants.SelectLocation_text).equals(App_Data.Locationtext));
			endTestCase("QuickTourSwipe");
		} catch (Exception e) {
			e.getMessage();
			takeSnapShot("D:\\takeScreenshots", "Quick Tour Swipe");
			throw (e);
		}

	}

	@Test(enabled =true)
	public void skipQuickTour() {
		try {
			startTestCase("Skip Quick Tour");
			waitforpresenceOfElement(App_Data.Skiptext);
			info("applying explicit wait");
			clickName(App_Constants.skip_button_text);
			info("click on skip button");
			Assert.assertTrue(findElementByName(App_Constants.SelectLocation_text).getText().equals(App_Data.Locationtext));
			info("Applying assertion");
			endTestCase("Skip Quick Tour");

		} catch (Exception e) {
			e.getMessage();
			takeSnapShot("D:\\takeScreenshots", "Skip Quick Tour");
			throw (e);
		}
	}

}
