package App_Functions;

import org.testng.annotations.Test;
import Functional_Scenarios.BaseTestSanitySuite;
import Page_Objects.App_Constants;
import Utility.UserDefined;

//This function is used to open Homepage of application

public class OpenHomePage extends BaseTestSanitySuite {
	public static void openHomePage() {
		try {
			clickClassName(App_Constants.Skip_button);
			clickName(App_Constants.DetectAutomatically_name);
			clickName(App_Constants.SkipButton_name);
		} catch (Exception e) {
			e.printStackTrace();
			UserDefined.takeSnapShot("D:\\takeScreenshots", "Open home page function");
			throw (e);
		}
	}

	@Override
	@Test
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}

}
