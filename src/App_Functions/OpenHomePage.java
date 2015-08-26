package App_Functions;

import org.testng.annotations.Test;
import Functional_Scenarios.BaseTestSanitySuite;
import Page_Objects.App_Constants;

//This function is used to open Homepage of application

public class OpenHomePage extends BaseTestSanitySuite {
	public static void openHomePage() {
		try {
			clickClassName(App_Constants.Skip_button);
			clickName(App_Constants.DetectAutomatically_name);
			clickId(App_Constants.SkipButton_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	@Override
	@Test
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}

}
