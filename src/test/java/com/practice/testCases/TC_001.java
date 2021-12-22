package com.practice.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.pageObjects.LoginPage;

public class TC_001 extends BaseCase {

	@Test
	public void login() throws IOException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(pwd);
		lp.clickLogin();
		logger.info("Username, password entered and clicked on Login button");

		if (driver.getTitle().contains("HomePage")) {
			Assert.assertTrue(true);
			logger.info("Test case successful, user logged in fine");
		} else {
			captureScreen(driver, "login");
			Assert.assertTrue(false);
			logger.warn("Test case failed, user could not login");
		}
	}
}