package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import utilities.Mobile_Utilities;

public class ListDemoPage extends Mobile_Utilities{

	@FindBy(id = "android:id/alertTitle")
	private MobileElement alertTitleAndroid;

	@FindBy(id = "android:id/message")
	private MobileElement alertMessageAndroid;

	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	private MobileElement alertAcceptAndroid;

	@FindBy(xpath = "//android.widget.Button[@text='CANCEL']")
	private MobileElement alertDismissAndroid;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Stratocumulus']")
	private MobileElement Stratocumulus_IOS;

	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='UIAlert']")
	private MobileElement Alert_IOS;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	private MobileElement alertAccept_IOS;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement alertDismissIOS;

	public ListDemoPage(AppiumDriver<MobileElement> android) {
		super(android);
	}

	public ListDemoPage(IOSDriver<MobileElement> iosDriver) {
		super(iosDriver);
	}

	/** 
	 * Method - selects Stratocumulus Option for Android
	 **/
	public ListDemoPage selectoptionAndroid() throws InterruptedException {
		scrollToElementAndClick("Stratocumulus");
		return new ListDemoPage(android);
	}
	
	/** 
	 * Method - selects Stratocumulus Option for IOS
	 **/
	public ListDemoPage selectoptioniOS() {
		mobileswipeiOS(iosdriver);
		clickOnButton(Stratocumulus_IOS);
		return new ListDemoPage(iosdriver);
	}

	/** 
	 * Method - check the alert and validates for Android
	 **/
	public boolean popupdisplayedAndroid() throws InterruptedException {
		System.out.println("Checking Alert for Android");
		boolean alertPresent =  alertPresentInAndroid(alertTitleAndroid);
		clickOnButton(alertAcceptAndroid);
		android.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS); 
		return alertPresent;
	}

	/** 
	 * Method - check the alert and validates for IOS
	 **/
	public boolean popupdisplayedIOS() {
		System.out.println("Checking Alert for IOSs");
		boolean alertPresent = Alert_IOS.isEnabled();
		clickOnButton(alertAccept_IOS);
		return alertPresent;
	}

}
