package App_Functions;

import org.testng.annotations.Test;

import Functional_Scenarios.BaseTestSanitySuite;
import Page_Objects.App_Constants;

public class OpenAndroidPage extends BaseTestSanitySuite {

	public static void openAndroidPage() {
		try {
			OpenHomePage.openHomePage();
			clickClassName(App_Constants.Open_Navigation_Drawer);
			clickName(App_Constants.NavDrawer_Mobile_tablets_link);
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
