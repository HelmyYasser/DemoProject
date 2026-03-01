package com.swaglabs.drivers;

import com.swaglabs.utils.LogsUtil;
import com.swaglabs.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
        super();
        // Private constructor to prevent instantiation
    }

    //create instance of driver
    @Step("Creating driver instance for browser: {browserName}")
    public static WebDriver createDriverInstance(String browserName) {
        WebDriver driver = DriverFactory.getDriver(browserName);
        setDriver(driver);
        LogsUtil.info("Driver instance created for browser: " + browserName);
        return getDriver();
    }

    // Add driver getter and setter methods
    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            fail("WebDriver is null.");
        }
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

}
