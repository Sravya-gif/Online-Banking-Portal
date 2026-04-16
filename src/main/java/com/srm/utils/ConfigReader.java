package com.srm.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    static {
        try {
            InputStream is = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            prop = new Properties();
            prop.load(is);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}