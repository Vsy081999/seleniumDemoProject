package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static String getScreenshot(WebDriver driver, String scriptName) {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

//		File dest = new File("./Screenshots" + scriptName);

		File dest = new File("C:\\Users\\Vsy08\\eclipse-workspace\\seleniumDemoProject\\Screenshots\\" + scriptName
				+ getCurrentDatetime() + ".png");

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}

		return dest.getAbsolutePath();
	}

	public static String getCurrentDatetime() {

		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customformat.format(currentDate);

	}

}
