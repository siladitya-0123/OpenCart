package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement lnkMyAccnt;
	@FindBy(xpath = "//a[text()='Register']")
	WebElement lnkRegister;
	@FindBy(xpath = "//a[text()='Login']")
	WebElement btnlogin;

	public void clickMyAccount() {
		lnkMyAccnt.click();
	}

	public void clickOnRegister() {

		lnkRegister.click();
	}
	
	public void clickOnLogin() {

		btnlogin.click();
	}


}
