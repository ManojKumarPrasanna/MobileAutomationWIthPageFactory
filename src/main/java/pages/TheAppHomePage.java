package pages;

import org.openqa.selenium.support.FindBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import utilities.Mobile_Utilities;


public class TheAppHomePage extends Mobile_Utilities {

	@FindBy(xpath = "//android.widget.TextView[@text='List Demo']")
	private MobileElement listdemoAndroid;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='List Demo']")
	private MobileElement listdemoiOS;

	public TheAppHomePage(AndroidDriver<MobileElement> android) {
		super(android);
	}

	public TheAppHomePage(IOSDriver<MobileElement> iosDriver) {
		super(iosDriver);
	}

	/** 
	 * Method - selects List Demo Option for Android
	 **/
	public ListDemoPage tapListDemoButtonAndroid() {      
		clickOnButton(listdemoAndroid);
		return new ListDemoPage(android);
	}

	/** 
	 * Method - selects List Demo Option for IOS
	 **/
	public ListDemoPage tapListDemoButtonios() {      
		clickOnButton(listdemoiOS);
		return new ListDemoPage(iosdriver);
	}


}
