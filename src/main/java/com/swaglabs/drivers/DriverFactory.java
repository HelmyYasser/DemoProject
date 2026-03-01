package com.swaglabs.drivers;

import com.swaglabs.utils.PropertiesUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public class DriverFactory {
    public static WebDriver getDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeOptions options = getChromeOptions();

                return new ChromeDriver(options);
            case "firefox":
                FirefoxOptions firefoxOptions = getFirefoxOptions();

                return new FirefoxDriver(firefoxOptions);

            default:
                EdgeOptions edgeOptions = getEdgeOptions();

                return new EdgeDriver(edgeOptions);

        }
    }


    private static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--disable-notifications");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--disable-extensions");
        firefoxOptions .addArguments("--remote-allow-origins=*");
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (!PropertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            firefoxOptions.addArguments("--headless");
        }
        firefoxOptions.setAcceptInsecureCerts(true);
        return firefoxOptions;
    }

    private static EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--disable-infobars");
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions .addArguments("--remote-allow-origins=*");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--disable-popup-blocking");
        if (!PropertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            edgeOptions.addArguments("--headless");
        }
        Map <String, Object> edgePrefs = Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "autoFill.profile_enabled", false);
        edgeOptions.setExperimentalOption("prefs", edgePrefs);
        return edgeOptions;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options .addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--disable-popup-blocking");
        if (!PropertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            options.addArguments("--headless");
        }
        Map <String, Object> prefs = Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "autoFill.profile_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }
}
