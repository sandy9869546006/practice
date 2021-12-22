package com.practice.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.practice.pageObjects.LoginPage;
import com.practice.utilities.XLUtils;

public class TC_002_DD extends BaseCase {

	@Test(dataProvider = "loginDD")
	public void loginDD(String user, String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(2000);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickLogin();
		Thread.sleep(2000);
		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("Login Failed, invalid username or password");
		} else {
			Assert.assertTrue(true);
			logger.info("Login successful");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DataProvider(name = "loginDD")
	String[][] getData() throws IOException {
		String path = "./src/test/java/com/practice/testData/LoginData.xlsx";
		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String loginData[][] = new String[rowcount][colcount];
		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}
