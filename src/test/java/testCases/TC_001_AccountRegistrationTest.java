package testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.AccountRegistration;
import pageobjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	@Parameters({ "os", "browser" })
	public void verify_account_registry() {

		logger.info("************Starting test case************");
		try {
			HomePage hp = new HomePage(driver);
			logger.info("Click on Account");

			hp.clickMyAccount();
			logger.info("Click on Registration");

			hp.clickOnRegister();

			AccountRegistration regpage = new AccountRegistration(driver);
			logger.info("Providing customer details");

			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastname(randomString().toUpperCase());
			regpage.setEmail(randomString() + "@gmail.com");
			regpage.setTelno(randomNumber());

			String Password = randomAlphanumeric();

			regpage.setpassword(Password);
			regpage.confirmpassword(Password);
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			logger.info("Validating expected message..");

			String confirmMsg = regpage.getConfirmationMsg();

			Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");

		} catch (Exception e) {
			logger.error("Test failed..");
			logger.debug("Debug logs...");
			Assert.fail(e.getMessage());
		}
	logger.info("*****TC finished*****");	}

}
