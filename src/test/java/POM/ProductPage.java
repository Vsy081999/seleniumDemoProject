package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	public WebDriver Idriver;
	
	@FindBy(xpath = "//*[contais(text(),'Sauce Labs Bike Light')]")
	private WebElement Productname;
	
	public ProductPage(WebDriver driver) {
		this.Idriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProductname() {
		return Productname.getText();
	}

	
	
}
