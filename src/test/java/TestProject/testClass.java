package TestProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.LoginPage;

public class testClass extends BaseClass {

	@Test(groups = { "sanity" })
	public void Step1() {
		System.out.println("Step1   : sanity");

		LoginPage lg = new LoginPage(driver);

		lg.getUsername().sendKeys("standard_user");
		lg.getPassword().sendKeys("secret_sauce");
		lg.getLoginbuton().click();

	}

	@Test(groups = { "sanity" })
	public void Step2() {
		System.out.println("Step2   : sanity");
		HomePage hm = new HomePage(driver);

		System.out.println(hm.homepagetext());

	}

	@Test(groups = { "sanity" })
	public void Step3() {
		System.out.println("Step3   : sanity");

	}

	@Test(groups = { "regression" })
	public void Step4() {
		System.out.println("Step4   : regression");
	}

	@Test(groups = { "regression" })
	public void Step5() {
		System.out.println("Step5   : regression");
	}

}
