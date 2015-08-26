package Functional_Scenarios;

import org.testng.annotations.Test;

public class NavigationDrawerScenarios extends BaseTestSanitySuite {
	//Test case info:In this test case we are  verifying navigation drawer functionality
	//In first test case we are verifying all rootcategories are clickable in NAVDrawer 
	//In second test case we are verifying mutiple cities

	@Override
	@Test
	public void executeTestCase() throws Exception {
		try{
			startTestCase("All rootcategories are clickable in NAVDrawer");
			
			endTestCase("All rootcategories are clickable in NAVDrawer");
			
		}catch(Exception e){
			e.getMessage();
			takeSnapShot("D:\\takeScreenshots", "Root Categories in Navigation drawer");
			throw (e);
		}
		
		
	}

}
