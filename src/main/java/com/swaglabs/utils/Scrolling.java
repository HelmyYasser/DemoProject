package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class Scrolling {

    private Scrolling () {
        // Private constructor to prevent instantiation
    }
    // Scroll down by a specific element
    @Step("Scrolling to element located by: {locator}")
    public static void scrollToElement(WebDriver driver, By locator) {
        LogsUtil.info("Scrolling to element with locator: " + locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", ElemntActions.findElement(driver,locator));
    }
}
