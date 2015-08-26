package App_Functions;

import org.testng.annotations.Test;
import Functional_Scenarios.BaseTestSanitySuite;
import Page_Objects.App_Constants;

public class OpenOverflowMenu extends BaseTestSanitySuite{
	
	public static void openOverflowMenu(){
		OpenHomePage.openHomePage();
		clickName(App_Constants.HomeOverflow_name);
	}

	@Override
	@Test
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
