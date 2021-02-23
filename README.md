# MobileAutomationWIthPageFactory
This project demonstrates Mobile Automation for both Android and iOS along with Page Factory Design Pattern.

Pre-requisites and versions - [Node - v15.9.0] [NPM - 7.5.3] [Appium - 1.20.2] [Java - 9] 
[Android emulator used - pixel 2(9.0)] [iOS simulator used - iPhone 8(14.4)]

Please follow and make these changes in source files to seamless run of these tests.

1. Please make sure to install the app on emulator/simulator before running the tests

2. Start the Appium server at 127.0.0.1:4723

3. For IOS webdriver agent runner port manually set to 8100 also please set the capability for webDriverAgentUrl for IOS in DriverBase.java class

4. testng.xml has parameter set for Android currently. After above step, Please change to "IOS" for iOS tests on simulator. supported paramters - "ANDROID" and "IOS"
