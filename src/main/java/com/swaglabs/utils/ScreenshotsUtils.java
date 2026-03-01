package com.swaglabs.utils;

import com.swaglabs.drivers.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenshotsUtils {

    public static final String SCREENSHOTS_PATH = "test-output/screenshots/";

    private ScreenshotsUtils() {
        super();
        // Private constructor to prevent instantiation
    }

    public static void takeScreenshot(String screenshotName) {
        // Implementation for taking screenshot
        try {
            File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File screenshotFile = new File(SCREENSHOTS_PATH + screenshotName + ".png");
            FileUtils.copyFile(screenshot, screenshotFile);
            AllureUtils.attachScreenshotToAllureReport( screenshotName, screenshotFile.getPath());
        }
        catch (Exception e) {
            LogsUtil.error("Failed to take screenshot: " + e.getMessage());
        }
    }
}
