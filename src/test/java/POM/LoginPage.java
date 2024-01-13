package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	@FindBy(id = "user-name")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login-button")
	private WebElement loginbuton;

	@FindBy(xpath = "//*[contains(text(),'Epic sadface')]")
	private WebElement errorMsg;

//	@FindBy(xpath = "(//*[local-name()='svg' ]/*[local-name()='path'])[3]")
//	private WebElement errorMsgcloseBtton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbuton() {
		return loginbuton;
	}

//	public WebElement getError() {
//		return errorMsg;
//	}
//
//	public WebElement getErrorMsgcloseBtton() {
//		return errorMsgcloseBtton;
//	}

}
