package Functional_Scenarios;

import junit.framework.Assert;

import org.testng.annotations.Test;

import App_Functions.OpenHomePage;
import Page_Objects.App_Constants;

@SuppressWarnings("deprecation")
public class SearchScenarios extends BaseTestSanitySuite {

	@Override
	@Test
	public void executeTestCase() throws Exception {
		try {
			startTestCase("Product search by product categories");
			info("Call the function of home page function");
			OpenHomePage.openHomePage();
			clickId(App_Constants.Home_search_button_id);
			info("Click on Search icon id");
			String[] categories = { "Android Phones", "Refrigerator",
					"Air Conditioner" };
			for (String category : categories) {
				System.out.println(category);
				sendKeysForName(App_Constants.Search_Bar_textbar_text, category);
				info("sending text to search bar");
				clickXpath(App_Constants.SearchSuggestedFirstProduct_xpath);
				info("clicking suggested product");

				Assert.assertTrue(findElementByXpath(
						App_Constants.first_android_phone_xpath).isEnabled());
				Assert.assertTrue(findElementByXpath(
						App_Constants.second_android_phone_xpath).isEnabled());
				clickId(App_Constants.Home_search_button_id);
				info("Click on Search icon id");
			}
			endTestCase("Product search by product categories");
		} catch (Exception e) {
			e.getMessage();
			takeSnapShot("D:\\takeScreenshots",
					"Product search by product categories");
			throw (e);
		}

	}

}