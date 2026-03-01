package com.swaglabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    private Waits() {
        // Private constructor to prevent instantiation
    }

    //present - visible - clickable

    //wait for element to be present
    public static WebElement waitForElementToBePresent(WebDriver driver, By locator) {
        LogsUtil.info("Waiting for element to be present with locator: " + locator);
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver1.findElement(locator));
    }

    //wait for element to be visible
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        LogsUtil.info("Waiting for element to be visible with locator: " + locator);
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> {
                    WebElement element = waitForElementToBePresent(driver, locator);
                    return element.isDisplayed() ? element : null;
                });
    }

    //wait for element to be clickable
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        LogsUtil.info("Waiting for element to be clickable with locator: " + locator);
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> {
                    WebElement element = waitForElementToBeVisible(driver, locator);
                    return element.isEnabled() ? element : null;
                });
    }


}
