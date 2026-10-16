package utils_Files;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String screenshotName) {

        String path = "";

        try {

            // Create Screenshots folder if it doesn't exist
            File folder = new File(System.getProperty("user.dir") + "/Screenshots");

            if (!folder.exists()) {
                folder.mkdirs();
            }

            TakesScreenshot ts = (TakesScreenshot) driver;

            File src = ts.getScreenshotAs(OutputType.FILE);

            path = System.getProperty("user.dir")
                    + "/Screenshots/" + screenshotName + ".png";

            FileUtils.copyFile(src, new File(path));

        } catch (Exception e) {

            e.printStackTrace();
        }

        return path;
    }
}