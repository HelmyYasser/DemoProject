package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {
    private Validations() {
        // Private constructor to prevent instantiation
    }

    //Validate true.
    @Step ("Validating condition is true: {message}")
    public static void validateTrue(boolean condition, String message) {
            Assert.assertTrue(condition, message);
    }

    //Validate false.
    @Step ("Validating condition is false: {message}")
    public static void validateFalse(boolean condition, String message) {
            Assert.assertFalse(condition, message);
    }
    // Validate  equals.
    @Step ("Validating actual: {actual} equals expected: {expected}. {message}")
    public static void validateEquals(String actual, String expected, String message) {
            Assert.assertEquals(actual, expected, message);

    }
    //Validate not equals.
    @Step ("Validating actual: {actual} not equals expected: {expected}. {message}")
    public static void validateNotEquals(String actual, String expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }
    //Validate Page url.
    @Step ("Validating page URL equals expected URL: {expectedUrl}")
    public static void validatePageUrl(WebDriver driver, String expectedUrl) {
        Assert.assertEquals(BrowserActions.getCurrentUrl(driver), expectedUrl, "Page URL does not match the expected URL.");
    }
    //Validate Page title.
    @Step ("Validating page title equals expected title: {expectedTitle}")
    public static void validatePageTitle(WebDriver driver, String expectedTitle) {
        Assert.assertEquals(BrowserActions.getPageTitle(driver), expectedTitle, "Page title does not match the expected title.");
    }

}