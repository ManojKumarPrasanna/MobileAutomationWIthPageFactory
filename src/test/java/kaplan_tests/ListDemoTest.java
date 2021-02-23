package kaplan_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import core.DriverBase;
import pages.TheAppHomePage;

/** 
 * Created by Manoj on 23.02.2021.
 * Test Demo
 **/

public class ListDemoTest extends DriverBase{

	/** 
	 * Method - contains tests and validations for theapp
	 **/
	@Test()
	public void LIST_DEMO_TEST() throws InterruptedException{
		//The result variable indicates outcome of the test
		boolean result = false;
		System.out.println("Running tests on " + DriverBase.PlatformName);
		//Below code is run only for Android 
		if(DriverBase.PlatformName.contains("ANDROID"))
		{
			//Outcome of test on Android
			result = new TheAppHomePage(android).tapListDemoButtonAndroid().selectoptionAndroid().popupdisplayedAndroid();
			//Validating the test result
			Assert.assertEquals(result, true);
		}
		//Below code is run only for IOS
		if(DriverBase.PlatformName.contains("IOS"))
		{
			//Outcome of test on IOS
			result = new TheAppHomePage(iosdriver).tapListDemoButtonios().selectoptioniOS().popupdisplayedIOS();
			//Validating the test result
			Assert.assertEquals(result, true);
		}
	}

}