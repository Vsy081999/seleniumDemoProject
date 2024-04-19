package TestProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import POM.HomePage;
import POM.LoginPage;

public class testClass extends BaseClass {

	@Test(priority=1)
	public void login() throws IOException, InterruptedException {
		LoginPage lg = new LoginPage(driver);

		lg.getUsername().sendKeys("standard_user");
//		lg.enterUsername("standard_user");
		Thread.sleep(2000);
		lg.getPassword().sendKeys("secret_sauce");
		lg.getLoginbuton().click();
	}

	@Test(priority=2)
	public void HomePage() throws IOException {
		HomePage hm = new HomePage(driver);
		System.out.println(hm.homepagetext());
	}
}
