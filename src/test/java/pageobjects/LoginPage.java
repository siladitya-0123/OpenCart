package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement btnLogin;

	public void enterEmail(String Email) {
		txtEmail.sendKeys(Email);

	}

	public void enterPassword(String pwd) {
		txtPassword.sendKeys(pwd);

	}

	public void logIn() {
		btnLogin.click();
		

	}
}
