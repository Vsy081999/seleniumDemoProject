package TestProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utilities.Screenshotlib;
import Utilities.Utility;

public class BaseClass  {

	public WebDriver driver;
	public ExtentReports extentreport;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {

		extentreport = new ExtentReports();
		File file = new File("C:\\Users\\Vsy08\\eclipse-workspace\\seleniumDemoProject\\Reports\\report"
				+ Utility.getCurrentDatetime() + ".html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentreport.attachReporter(sparkReporter);

		extentreport.setSystemInfo("Machine:", "testpc1");
		extentreport.setSystemInfo("OS", "windows 11");
		extentreport.setSystemInfo("browser:", "chrome");
		extentreport.setSystemInfo("user name:", "Vishwanath");
		// configuration to change look and feel of report
		sparkReporter.config().setDocumentTitle("Extent Listener Report Demo");
		sparkReporter.config().setReportName("This is my First Report");
		sparkReporter.config().setTheme(Theme.DARK);
	}

	@BeforeClass
	@Parameters({ "Browser", "Url" })
	public void LauchBrowser(String Browser, String Url) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);
	}
                    
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		String scriptName = result.getMethod().getMethodName();
		if (result.getStatus() == ITestResult.FAILURE) {
			extentreport.createTest(scriptName +" This is for attaching screenshots").fail(scriptName)
			.addScreenCaptureFromPath(Utility.getScreenshot(driver, scriptName));

		} 
		else if (result.getStatus() == ITestResult.SUCCESS) {
			extentreport.createTest(scriptName + "Test Passed").pass(scriptName);
		}
		extentreport.flush();
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
