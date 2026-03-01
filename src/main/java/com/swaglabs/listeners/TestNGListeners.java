package com.swaglabs.listeners;

import com.swaglabs.utils.AllureUtils;
import com.swaglabs.utils.FilesUtils;
import com.swaglabs.utils.LogsUtil;
import com.swaglabs.utils.ScreenshotsUtils;
import org.testng.*;
import java.io.File;
import static com.swaglabs.utils.PropertiesUtils.loadProperties;

public class TestNGListeners implements IExecutionListener, ITestListener, IInvokedMethodListener {

    //Variables
    //allure-result file location variable
    File allureResults = new File("test-output/allure-results");
    //logs file location variable
    File logs = new File("test-output/logs");
    //screenshots file location variable
    File screenshots = new File("test-output/screenshots");

    @Override
    public void onExecutionStart() {
        LogsUtil.info("Test suite execution started.");
        loadProperties();
        FilesUtils.deleteFiles(allureResults);
        FilesUtils.cleanDirectory(logs);
        FilesUtils.cleanDirectory(screenshots);
        FilesUtils.createDirectory(allureResults);
        FilesUtils.createDirectory(logs);
        FilesUtils.createDirectory(screenshots);

    }

    @Override
    public void onExecutionFinish() {
        LogsUtil.info("Test suite execution finished.");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // Attach logs to Allure report after each test method if it is a test method
        if (method.isTestMethod()) {
            switch (testResult.getStatus()) {
                case ITestResult.SUCCESS -> ScreenshotsUtils.takeScreenshot("Passed- " + testResult.getName());
                case ITestResult.FAILURE -> ScreenshotsUtils.takeScreenshot("Failed- " + testResult.getName());
                case ITestResult.SKIP -> ScreenshotsUtils.takeScreenshot("Skipped- " + testResult.getName());

            }
            AllureUtils.attachLogsToAllureReport();
        }
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        LogsUtil.info("Test Case:", result.getName(), " - PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogsUtil.info("Test Case:", result.getName(), " - FAILED");
    }

     @Override
    public void onTestSkipped(ITestResult result) {

        LogsUtil.info("Test Case:", result.getName(), " - SKIPPED");
     }

}
