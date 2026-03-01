package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions() {
        // Private constructor to prevent instantiation
    }

    // Navigate to a specific URL
    @Step ("Navigating to URL: {url}")
    public static void navigateToUrl(WebDriver driver, String url) {
        driver.get(url);
        LogsUtil.info("Navigated to URL: " + url);
    }

    //Get current URL
    @Step ("Getting current URL")
    public static String getCurrentUrl(WebDriver driver) {
        LogsUtil.info("Current URL: ", driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    //Get page title
    @Step ("Getting page title")
    public static String getPageTitle(WebDriver driver) {
        LogsUtil.info("Page Title: ", driver.getTitle());
        return driver.getTitle();
    }

    //Refresh the current page
    @Step ("Refreshing the page")
    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
        LogsUtil.info("Page refreshed");
    }

    //Close the browser
    @Step ("Closing the browser")
    public static void closeBrowser(WebDriver driver) {
        driver.quit();
        LogsUtil.info("Browser closed");

    }
}
