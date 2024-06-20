package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver Idriver;

	@FindBy(xpath = "//*[contains(text(),'Products1')]")
	private WebElement Homepage;
	
	@FindBy(xpath = "//*[contains(text(),'Sauce Labs Bike Light')]")
	private WebElement ProductName;
	

	public HomePage(WebDriver driver) {
		this.Idriver = driver;
		PageFactory.initElements(driver, this);
	}

	public String homepagetext() {
		return Homepage.getText();
	}

	public WebElement ProductName() {
		return ProductName;
	}

		
	
}
