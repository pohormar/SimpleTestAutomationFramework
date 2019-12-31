package com.testautomation.core.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final String CONFIG_FILE = "env.properties";
    private static Properties configuration;

    static {
        configuration = readPropertiesFile(CONFIG_FILE);
    }

    public static Properties readPropertiesFile(String fileName) {
        FileInputStream fis = null;
        Properties properties = null;

        try {
            fis = new FileInputStream(fileName);
            properties = new Properties();
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    public static String getPropertyAsString(String propertyName) {
        return configuration.getProperty(propertyName);
    }

    public static int getPropertyAsInt(String propertyName) {
        return Integer.parseInt(configuration.getProperty(propertyName));
    }
}
