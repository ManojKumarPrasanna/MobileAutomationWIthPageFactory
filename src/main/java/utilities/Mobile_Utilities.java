package utilities;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class Mobile_Utilities {

	protected AppiumDriver<MobileElement> android;
	protected  IOSDriver<MobileElement> iosdriver ;

	/** 
	 * Constructor for android 
	 **/
	protected Mobile_Utilities(AppiumDriver<MobileElement> android){
		this.android = android;
		PageFactory.initElements(new AppiumFieldDecorator(android), this);
	}

	/** 
	 * Constructor for IOS 
	 **/
	protected Mobile_Utilities(IOSDriver<MobileElement> iosdriver){
		this.iosdriver = iosdriver;
		PageFactory.initElements(new AppiumFieldDecorator(iosdriver), this);
	}

	/** 
	 * Method - Click on the element(Both Android and IOS)
	 * Parameter - MobileElement
	 **/
	protected void clickOnButton(MobileElement element) 
	{
		System.out.println("Clicking on Element");
		element.click();
	}

	/** 
	 * Method - Scroll to Android Element by name and Click 
	 * Parameter - ElementName
	 **/
	public void scrollToElementAndClick(String elementName){  	
		System.out.println("Scroll Element By Name In Android");
		android.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0))."
						+ "scrollIntoView(new UiSelector().textContains(\""+elementName+"\").instance(0))")).click();
		android.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS); 
	}

	/** 
	 * Method - check whether the alert is present
	 * Parameter - MobileElement
	 **/
	public boolean alertPresentInAndroid(MobileElement element) {
		return	element.isDisplayed();
	}

	/** 
	 * Method - Scroll in the IOS APP
	 * Parameter - IOSDriver
	 **/
	public void mobileswipeiOS(IOSDriver<MobileElement> iosdriver) {
		final HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "up");
		try {
			iosdriver.executeScript("mobile:swipe", scrollObject);
			iosdriver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS); 
		} catch (Exception e) {
			System.err.println("mobileSwipeScreenIOS(): FAILED\n" + e.getMessage());
			return;
		}
	}
}
