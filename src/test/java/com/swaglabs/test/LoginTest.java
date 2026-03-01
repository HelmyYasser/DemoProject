package com.swaglabs.test;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.listeners.TestNGListeners;
import com.swaglabs.pages.LoginPage;

import com.swaglabs.utils.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


@Listeners(TestNGListeners.class)
public class LoginTest {
    //Variables
    WebDriver driver;
    JsonUtils testData;

    //Tests
    @Test()
public void testSuccessfulLogin( ) {
        new LoginPage(driver)
                .enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLoginButton()
                .isLoginSuccessfulSoft();

    }

    @BeforeClass
    public void beforeClass(){
        testData = new JsonUtils("test-data");
    }

    //Configuration
    @BeforeMethod
    public void setUp() {
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        driver = DriverManager.createDriverInstance(browserName);
        new LoginPage(driver).navigateToLoginPage();

    }
    @AfterMethod
    public void tearDown() {
        BrowserActions.closeBrowser(driver);

    }

}
