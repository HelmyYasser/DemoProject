package com.swaglabs.utils;

import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtils {

    public static final String ALLURE_RESULTS_PATH = "test-output/allure-results";

    private AllureUtils() {
        super();
        // Private constructor to prevent instantiation
    }

    public static void attachLogsToAllureReport(){
        try {
            File logFile = FilesUtils.getLatestFile(LogsUtil.LOGS_PATH);
            if (!logFile.exists()) {
                LogsUtil.warn("Log file not exists to attach to Allure report." + LogsUtil.LOGS_PATH);
                return;
            }
            Allure.addAttachment("logs.log", Files.readString(Path.of(logFile.getPath())));
            LogsUtil.info("Logs attached to Allure report from: " + logFile.getPath());

        } catch (Exception e) {
            LogsUtil.error("Failed to attach logs to Allure report: " + e.getMessage());
        }
    }
    // Method to attach screenshot to Allure report
    public static void attachScreenshotToAllureReport(String screenshotName , String screenshotPath){
        try {
            Allure.addAttachment(screenshotName , Files.newInputStream(Path.of(screenshotPath)));
        } catch (Exception e) {
            LogsUtil.error("Failed to attach screenshot to Allure report: " + e.getMessage());
        }
    }


}
