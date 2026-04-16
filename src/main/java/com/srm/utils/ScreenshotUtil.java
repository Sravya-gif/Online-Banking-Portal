package com.srm.utils;

import org.openqa.selenium.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String name) {

        String path = "";

        try {
            if (driver == null) {
           
                return "";
            }

            
            try {
                Alert alert = driver.switchTo().alert();
                alert.accept(); 
            } catch (Exception e) {
               
            }

            File dir = new File("screenshots");
            if (!dir.exists()) dir.mkdirs();

            String time = new SimpleDateFormat("yyyyMMddHHmmss")
                    .format(new Date());

            path = System.getProperty("user.dir") +
                    "/screenshots/" + name + "_" + time + ".png";

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File dest = new File(path);

            FileHandler.copy(src, dest);

        } catch (Exception e) {
           
        }

        return path;
    }
}