package core;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/** 
 * Created by Manoj on 22.02.2021.
 * DriverBase for Android and IOS drivers 
 **/

public abstract class DriverBase {

	//Android Driver
	protected static AndroidDriver<MobileElement> android ;
	//IOS Driver
	protected  static IOSDriver<MobileElement> iosdriver ;
	//PlatformName either ANDROID or IOS
	public static String PlatformName;
	//Capabilities to be set for Android and iOS
	static DesiredCapabilities capabilities = new DesiredCapabilities();

	/** 
	 * Method - initiate android and ios drivers
	 * Parameters - PlatformName from testng.xml file 
	 **/
	@Parameters({"PlatformName"})
	@BeforeMethod()
	protected static void setUp(String PlatformName) throws MalformedURLException {
		URL remoteAddress = new URL("http://127.0.0.1:4723/wd/hub");

		DriverBase.PlatformName = PlatformName;

		if(PlatformName.equals("ANDROID"))
		{
			android = new AndroidDriver<MobileElement>(remoteAddress, Androidcapabilities());
		}
		if(PlatformName.equals("IOS"))
		{
			iosdriver  = new IOSDriver<MobileElement>(remoteAddress, iOScapabilities());
		}
	}

	/** 
	 * Method - Capabilities required to initiate Android driver
	 **/
	public static DesiredCapabilities Androidcapabilities() {
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName","emulator-5554");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","9.0");
		capabilities.setCapability("appPackage","io.cloudgrey.the_app");
		capabilities.setCapability("appActivity","io.cloudgrey.the_app.MainActivity");
		return capabilities;
	}

	/** 
	 * Method - Capabilities required to initiate IOS driver
	 **/
	public static DesiredCapabilities iOScapabilities() {
		capabilities.setCapability("app", "");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "14.4");
		capabilities.setCapability("deviceName", "iPhone 8"); 
		capabilities.setCapability("bundleId", "io.cloudgrey.the-app");
		capabilities.setCapability("automationName", "XCUITest"); 
		capabilities.setCapability("wdaLocalPort", 8100);
		capabilities.setCapability("usePrebuiltWDA", true);
		capabilities.setCapability("webDriverAgentUrl", "http://localhost:8100"); 
		capabilities.setCapability("startIWDP", false);
		capabilities.setCapability("newCommandTimeout",3000);
		capabilities.setCapability("launchTimeout", 3000);
		capabilities.setCapability("udid","auto");
		capabilities.setCapability("absoluteWebLocations", true);
		capabilities.setCapability("showXcodeLog", true);
		return capabilities;
	}

	@AfterMethod
	protected void tearDown(){
		if(android != null)
			android.quit();
		if(iosdriver != null)
			iosdriver.quit();
	}
}
