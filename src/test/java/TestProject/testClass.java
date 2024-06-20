package TestProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import POM.HomePage;
import POM.LoginPage;
import POM.ProductPage;
import Utilities.RetryAnalyser;

public class testClass extends BaseClass {
	
	@Test(priority=1)
//	@Test(retryAnalyzer=RetryAnalyser.class)
	public void login() throws IOException, InterruptedException {
		LoginPage lg = new LoginPage(driver);
		
		lg.getUsername().clear();
		Thread.sleep(2000);
		lg.getUsername().sendKeys("standard_user");
		Thread.sleep(2000);

		lg.getPassword().clear();
		Thread.sleep(2000);
		lg.getPassword().sendKeys("secret_sauc");
		Thread.sleep(2000);
		
		lg.getLoginbuton().click();
		Thread.sleep(2000);
		
		if(lg.getError().isDisplayed()) {
			lg.getErrorMsgcloseBtton().click();
//			Thread.sleep(2000);
//			lg.getUsername().clear();
//			Thread.sleep(2000);
//			lg.getPassword().clear();
		}
		
		Assert.assertEquals("abcd", driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText());
		
	}
/*
	@Test(priority=2)
	public void HomePage_1() throws IOException {
		HomePage hm = new HomePage(driver);
		System.out.println(hm.homepagetext());
	}
	
	@Test(priority=3)
	public void HomePage_2() throws IOException {
		HomePage hm = new HomePage(driver);
		hm.ProductName().click();
		ProductPage pp = new ProductPage(driver);
		System.out.println(pp.getProductname());
	}
	
	*/
}
