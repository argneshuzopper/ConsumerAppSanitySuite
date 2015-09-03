package Functional_Scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import App_Functions.OpenHomePage;
import Page_Objects.App_Constants;
import Page_Objects.App_Data;
import Page_Objects.App_Verification_Checks;

public class ProductDetailsScenarios extends BaseTestSanitySuite {

	@Override
	@Test(enabled = false)
	public void executeTestCase() throws Exception {
		try {
			String[] products = { App_Data.Producttext, App_Data.Producttext1,
					App_Data.Producttext2, App_Data.Producttext3,
					App_Data.Producttext4, App_Data.Producttext5,
					App_Data.Producttext6, App_Data.Producttext7 };
			startTestCase("Product image,name,button should get displayed");
			info("Call the function of home page function");
			OpenHomePage.openHomePage();
			for (String product : products) {
				clickId(App_Constants.Home_search_button_id);
				info("Click on Search icon id");

				sendKeysForName(App_Constants.Search_Bar_textbar_text, product);
				info("sending keys on  search bar");
				clickXpath(App_Constants.SearchSuggestedFirstProduct_xpath);
				info("clicking suggested product");
				Assert.assertTrue(findElementById(
						App_Constants.ProductionProductTitle_id).isDisplayed());
				Assert.assertTrue(findElementById(App_Constants.ProductImage_id)
						.isDisplayed());
				try {
					if (findElementByName(App_Constants.BuyNow_button_text)
							.isDisplayed()) {
						Assert.assertTrue(findElementByName(
								App_Constants.BuyNow_button_text).isDisplayed());
					}

				} catch (Exception e) {
					Assert.assertTrue(findElementById(
							App_Constants.GetPricesButton_id).isDisplayed());
				}
			}
			endTestCase("Product image,name,button should get displayed");

		} catch (Exception e) {
			e.getMessage();
			takeSnapShot("D:\\takeScreenshots",
					"Product image,name,button should get displayed");
			throw (e);

		}

	}

	@Test(enabled = false)
	public void productEnlargedImage() {
		try {
			startTestCase("productEnlargedImage");
			info("Call the function of home page function");
			OpenHomePage.openHomePage();
			// for(String product : products){
			clickId(App_Constants.Home_search_button_id);
			info("Click on Search icon id");

			sendKeysForName(App_Constants.Search_Bar_textbar_text,
					App_Data.Producttext);
			info("sending keys on  search bar");
			clickXpath(App_Constants.SearchSuggestedFirstProduct_xpath);
			info("clicking suggested product");
			clickId(App_Constants.ProductImage_id);
			info("clicking image");
			String expectedresults = findElementById(
					App_Constants.ProductImage_id).getTagName();
			Assert.assertEquals(App_Data.ImageClassName, expectedresults);
			info("verifying assertion");
		} catch (Exception e) {
			e.getMessage();
			takeSnapShot("D:\\takeScreenshots", "productEnlargedImage");
			throw (e);
		}
	}

	@Test(enabled = false)
	public void productFeaturesDetails() {
		try {
			String[] products = { App_Data.Producttext, App_Data.Producttext2 };
			startTestCase("Product features details");
			info("Call the function of home page function");
			OpenHomePage.openHomePage();
			for (String product : products) {
				clickId(App_Constants.Home_search_button_id);
				info("Click on Search icon id");

				sendKeysForName(App_Constants.Search_Bar_textbar_text, product);
				info("sending keys on  search bar");
				clickXpath(App_Constants.SearchSuggestedFirstProduct_xpath);
				info("clicking suggested product");
				for (int i = 0; i < 2; i++) {
					swipeWithAxis(0, 1000, 0, 250, 3000);
				}
				info("swipping the window");
				clickId(App_Constants.ProductDetailsPageFirstViewAll_id);
				info("clicking on View all link");
				Assert.assertTrue(findElementByName(
						App_Constants.GeneralFeatureSet_text).getText().equals(
						App_Verification_Checks.GeneralFeatureText));
				clickClassName(App_Constants.BackButton_class);
				info("verifying assertion");

			}
			endTestCase("Product feature details");

		} catch (Exception e) {
			e.getMessage();
			takeSnapShot("D:\\takeScreenshots", "productFeaturesDetails");
			throw (e);

		}
	}

	@Test
	public void loginCheckForSubmitReview() {
		try {
			startTestCase("loginCheckForSubmitReview");
			info("opening home page of function");
			OpenHomePage.openHomePage();
			clickXpath(App_Constants.MyAccountSearchIcon_xpath);
			info("Clicking on Search icon");
			sendKeysForName(App_Constants.Search_Bar_textbar_text,
					App_Data.Producttext);
			info("entering product info");
			clickXpath(App_Constants.SuggestedProductForSubmitReviewScenario);
			info("clicking on suggested product");
			// scrollTo(AppData.ReviewString);
			for (int i = 0; i < 3; i++) {
				swipeWithAxis(0, 750, 0, 250, 3000);
			}
			info("swipping");
			clickXpath(App_Constants.SecondViewDetailsLink_xpath);
			info("click on second view link");
			clickId(App_Constants.ProductReviewsPencilIcon_id);
			info("clicking on pencil button");
			clickName(App_Constants.ReviewProductFiveStarRating_text);
			if (findElementById(App_Constants.ReviewProductTitle_ID)
					.isDisplayed())
				;
			{
				clearForId(App_Constants.ReviewProductTitle_ID);
			}

			sendKeysForID(App_Constants.ReviewProductTitle_ID, App_Data.title);

			navigateBack();
			if (findElementById(App_Constants.ReviewProductDescription_ID)
					.isDisplayed())
				;
			{
				clearForId(App_Constants.ReviewProductDescription_ID);
			}

			sendKeysForID(App_Constants.ReviewProductDescription_ID,
					App_Data.description);

			navigateBack();

			clickName(App_Constants.ReviewProductSubmitButton);
			Assert.assertTrue(findElementByName(
					App_Constants.GeneralFeatureSet_text).getText().equals(
					App_Verification_Checks.GeneralFeatureText));

		} catch (Exception e) {
			e.getMessage();
			takeSnapShot("D:\\takeScreenshots", "loginCheckForSubmitReview");
			throw (e);
		}
	}
}