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

	@Test
	public void TC_01() throws IOException {
		LoginPage lg = new LoginPage(driver);
		lg.getUsername().sendKeys("standard_user");
		lg.getPassword().sendKeys("secret_sauce");
		lg.getLoginbuton().click();
	}

	@Test
	public void TC_02() throws IOException {
		HomePage hm = new HomePage(driver);
		System.out.println(hm.homepagetext());

	}

}
