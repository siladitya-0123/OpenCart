package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verify_login() throws IOException {
		logger.info("*****Starting TC_002*****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickOnLogin();

			LoginPage lp = new LoginPage(driver);

			lp.enterEmail(p.getProperty("email"));
			lp.enterPassword(p.getProperty("password"));
			lp.logIn();

			MyAccountPage map = new MyAccountPage(driver);
			Boolean targetpage = map.isMyAccountPageExist();
			Assert.assertEquals(targetpage, true, "Login failed");
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC finsihed");

	}
}
