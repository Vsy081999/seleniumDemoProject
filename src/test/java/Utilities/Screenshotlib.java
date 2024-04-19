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

public class Screenshotlib {

//	public static void captureScreenshot(WebDriver driver, String ScriptName) throws IOException {
//		TakesScreenshot screenshot = ((TakesScreenshot) driver);
//
//		// step2: call getScreenshotAs method to create image file
//
//		File src = screenshot.getScreenshotAs(OutputType.FILE);
//
//		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + ScriptName + ".png");
//		// step3: copy image file to destination
//		FileUtils.copyFile(src, dest);
//	}

	public static String captureScreenshot(WebDriver driver, String ScriptName) throws IOException {
	
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		String screenshotpath = System.getProperty("user.dir") + "\\Screenshots\\" + ScriptName+"_"+ getCurrentDatetime()+".png";


	
//	   File	dest = new File(
//				System.getProperty("user.dir") + "\\Screenshots\\" + ScriptName + ""+getCurrentDatetime() + ".png");

	   File	dest = new File(screenshotpath);
				

	   
	   FileUtils.copyFile(src, dest);
	

		System.out.println("screenshotpath   :"+screenshotpath);
		
		return screenshotpath;

	}


	
	public static String getCurrentDatetime() {

		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customformat.format(currentDate);

	}

}
