package com.swaglabs.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOIndexedException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesUtils {

    //private constructor to prevent instantiation
    private FilesUtils() {
        super();
    }

    //Method to get latest log file
    public static File getLatestFile(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            LogsUtil.warn("No files found in the directory: " + folderPath);
            return null;
        }
        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }
        return latestFile;
    }

    //Method to delete file
    public static void deleteFiles(File dirPath) {
        if (dirPath == null || !dirPath.exists()) {
            LogsUtil.warn("Directory does not exist: " + dirPath);
            return;
        }
        File[] fileList = dirPath.listFiles();
        if (fileList == null) {
            LogsUtil.warn("Failed to list files in directory: " + dirPath);
            return;
        }
        for (File file : fileList) {
            if (file.isDirectory()) {
                deleteFiles(file); // Recursive call for subdirectories
            } else {
                try {
                    Files.delete(file.toPath());
                } catch (IOException e) {
                    LogsUtil.error("Failed to delete file: " + file);
                }
            }
        }

    }

    public static void cleanDirectory(File file){
        try {
            FileUtils.cleanDirectory(file);
        } catch (IOException exception) {
            LogsUtil.error(exception.getMessage(), "Failed to clean directory: " + file);
        }
    }

    public static void createDirectory(File path) {
        if (!path.exists()) {
            try {
                Files.createDirectories(path.toPath());
                LogsUtil.info("Directory created: " + path);
            } catch (IOException e) {
                LogsUtil.error("Failed to create directory: " + path, e.getMessage());
            }
        }
            else LogsUtil.info("Directory already exists: " + path);
    }
}