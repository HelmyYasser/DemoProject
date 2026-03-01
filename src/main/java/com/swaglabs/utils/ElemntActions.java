package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElemntActions {
    private ElemntActions() {
        // Private constructor to prevent instantiation
    }

    //sendKeys
    @Step ("Filling input field located by: {locator} with text: {text}")
    public static void fillInputField(WebDriver driver, By locator, String text) {
        Waits.waitForElementToBeVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver,locator).clear();
        findElement(driver,locator).sendKeys(text);
        LogsUtil.info("Filled input field with text: " + text + " for locator: " + locator);
    }

    //click
    @Step ("Clicking on element located by: {locator}")
    public static void clickElement(WebDriver driver, By locator) {
        Waits.waitForElementToBeClickable(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver,locator).click();
        LogsUtil.info("Clicked on element with locator: " + locator);
    }

    //getText
    @Step ("Getting text from element located by: {locator}")
    public static String getElementText(WebDriver driver, By locator) {
        Waits.waitForElementToBeVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        LogsUtil.info("Getting text from element with locator: " + locator);
        return findElement(driver,locator).getText();
    }

    //findElement
    public static WebElement findElement(WebDriver driver, By locator) {
        LogsUtil.info("Finding element with locator: " + locator);
        return driver.findElement(locator);
    }
}
