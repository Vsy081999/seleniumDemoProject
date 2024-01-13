package TestProject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Test;

import Utilities.Screenshotlib;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	@BeforeClass
	@Parameters({ "Browser", "Url" })
	public void LauchBrowser(String Browser, String Url) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(Url);

	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	@AfterMethod
	public void captureScreenShot(ITestResult Result) throws IOException {
		String Scriptname = Result.getMethod().getMethodName();
		if (Result.isSuccess()) {
			Reporter.log(Scriptname + "   Scriptname is pass");
		} else {
			Reporter.log(Scriptname + "   Scriptname is Failed");
			Screenshotlib slib = new Screenshotlib();
			slib.captureScreenshot(driver, Scriptname);
			Reporter.log("Screenshot has been taken");
		}
	}
}
