package TestProject;

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
	
	
//		driver.findElement(By.id("user-name")).sendKeys("standard_user");
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		driver.findElement(By.id("login-button")).click();

	}

	@Test(groups = { "sanity" })
	public void Step2() {
		System.out.println("Step2   : sanity");
		HomePage hm= new HomePage(driver);
		
//		String text=hm.homepagetext();
//		System.out.println("text  :"+text);
		
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
