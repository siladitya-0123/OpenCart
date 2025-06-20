package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage {

	public AccountRegistration(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div/input[@id='input-firstname']")
	WebElement txtFirstname;
	@FindBy(xpath = "//div/input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//div/input[@id='input-email']")
	WebElement txtEmailid;
	@FindBy(xpath = "//div/input[@id='input-telephone']")
	WebElement txtTelephone;
	@FindBy(xpath = "//div/input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath = "//div/input[@id='input-confirm']")
	WebElement txtCnfrmPassword;

	@FindBy(xpath = "//div/input[@type='checkbox']")
	WebElement chckprivacy;
	@FindBy(xpath = "//div/input[@type='submit']")
	WebElement btnContinue;
	@FindBy(xpath = "//div/h1[text()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}

	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmailid.sendKeys(email);
	}

	public void setTelno(String Telno) {
		txtTelephone.sendKeys(Telno);
	}

	public void setpassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void confirmpassword(String password) {
		txtCnfrmPassword.sendKeys(password);
	}

	public void setPrivacyPolicy() {
		chckprivacy.click();
	}

	public void clickContinue() {
		btnContinue.click();
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
