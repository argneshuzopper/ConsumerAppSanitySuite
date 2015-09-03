package App_Functions;

import org.testng.annotations.Test;

import Functional_Scenarios.BaseTestSanitySuite;
import Page_Objects.App_Constants;
import Utility.UserDefined;

//This function is created to handle the Gmail login from Login page
public class GmailLogin extends BaseTestSanitySuite {

	public static void gmailLogin() {
		try {
			clickXpath(App_Constants.Google_button_xpath);
			clickXpath(App_Constants.Gmail_account_id_option1_xpath);
			clickId(App_Constants.Gmail_account_ok_button);
		} catch (Exception e) {
			e.printStackTrace();
			UserDefined.takeSnapShot("D:\\takeScreenshots", "gmailLogin function");
			throw(e);
		}
	}


	@Override
	@Test
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub
		
	}

}

