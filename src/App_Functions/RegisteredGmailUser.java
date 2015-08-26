package App_Functions;

import org.testng.annotations.Test;

import Functional_Scenarios.BaseTestSanitySuite;
import Page_Objects.App_Constants;

public class RegisteredGmailUser extends BaseTestSanitySuite {

	public static void gmailUserLogin() {
		try {
			clickClassName(App_Constants.Skip_button);
			clickName(App_Constants.DetectAutomatically_name);
			clickXpath(App_Constants.Google_button_xpath);
			clickXpath(App_Constants.Gmail_account_id_option1_xpath);
			clickId(App_Constants.Gmail_account_ok_button);
			clickClassName(App_Constants.Open_Navigation_Drawer);
			clickId(App_Constants.NavDrawer_Login_button_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	@Test
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}

}
