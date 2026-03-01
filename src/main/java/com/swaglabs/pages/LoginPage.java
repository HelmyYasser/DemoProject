package com.swaglabs.pages;

import com.swaglabs.utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

import static com.swaglabs.utils.PropertiesUtils.getPropertyValue;

public class LoginPage {

    //Variables
    private final WebDriver driver;
    // Locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");


    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Navigate to Login Page
    @Step ("Navigating to Login Page")
    public LoginPage navigateToLoginPage() {
        BrowserActions.navigateToUrl(driver, getPropertyValue("baseURL"));
        return this;
    }

    //Actions > wait - scroll - find - sendKeys
    @Step ("Entering username: {username}")
    public LoginPage enterUsername(String username) {
        ElemntActions.fillInputField(driver, usernameField, username);
        return this;
    }
    @Step ("Entering password: {password}")
    public LoginPage enterPassword(String password) {
        ElemntActions.fillInputField(driver, passwordField, password);
        return this;
    }
    @Step ("Clicking Login button")
    public LoginPage clickLoginButton() {
        ElemntActions.clickElement(driver, loginButton);
        return this;
    }

    @Step ("Getting error message text")
    public String getErrorMessage() {
        return ElemntActions.getElementText(driver, errorMessage);
    }


    //Validations
    //Check Successful Login
    @Step ("Asserting current URL ")
    public LoginPage assertCurrentUrl() {
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentUrl(driver), getPropertyValue("homeURL"), "Current URL does not match expected.");
        return this;
    }
    @Step ("Asserting Login Page title")
    public LoginPage assertLoginPageTitle() {
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getPageTitle(driver), getPropertyValue("appTitle"), "Login page title does not match expected.");
        return this;
    }
    @Step ("Verifying login is successful with soft assertions")
    public LoginPage isLoginSuccessfulSoft() {
        assertCurrentUrl().assertLoginPageTitle();
        return this;
    }

    public LoginPage isLoginSuccessful() {
        Validations.validatePageUrl(driver, getPropertyValue("homeURL"));
        return this;
    }

    //Check Unsuccessful Login
    @Step ("Verifying login is unsuccessful with hard assertion")
    public LoginPage isLoginUnsuccessful() {
        Validations.validateEquals(getErrorMessage(), getPropertyValue("errorMSG"), "Error message does not match expected.");
        return this;
    }
}
