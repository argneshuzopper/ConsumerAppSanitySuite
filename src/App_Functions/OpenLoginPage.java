package App_Functions;

import org.testng.annotations.Test;

import Functional_Scenarios.BaseTestSanitySuite;
import Page_Objects.App_Constants;

public class OpenLoginPage extends BaseTestSanitySuite {

	public static void openLoginPage() {
		clickClassName(App_Constants.Skip_button);
		clickName(App_Constants.DetectAutomatically_name);

	}

	@Override
	@Test
	public void executeTestCase() throws Exception {

	}
}
