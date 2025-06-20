package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class, groups="Datadriven") // getting dataProvider from different
																				// class

	public void verify_loginDDT(String email, String password, String expectedResult) {
		logger.info("Starting Test_003_LoginDDT");
		logger.info("Testing with email: " + email + ", password: " + password);
		try {
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickOnLogin();

		// login
		LoginPage lp = new LoginPage(driver);

		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.logIn();

		// MyAccount
		MyAccountPage map = new MyAccountPage(driver);
		Boolean targetpage = map.isMyAccountPageExist();
		if (expectedResult.equalsIgnoreCase("Valid")) {
			if (targetpage == true) {
				Assert.assertTrue(true);
				map.clickLogout();

			} else {

				Assert.assertTrue(false);

			}

		}
		if (expectedResult.equalsIgnoreCase("Invalid")) {
			if (targetpage == false) {
				Assert.assertTrue(true);

			} else {

				Assert.assertTrue(false);
				map.clickLogout();
			}

		}
		}
		catch (Exception e){
			Assert.fail("Failed Due To: ", e);
		}
		logger.info("finishing Test_003_LoginDDT");
		
	}
}