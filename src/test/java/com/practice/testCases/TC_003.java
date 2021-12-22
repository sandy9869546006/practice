package com.practice.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.practice.pageObjects.AddCustomerPage;
import com.practice.pageObjects.LoginPage;

public class TC_003 extends BaseCase {

	@Test
	public void AddNewCustomer() throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(pwd);
		lp.clickLogin();
		Thread.sleep(3000);

		AddCustomerPage cp = new AddCustomerPage(driver);
		cp.clickNewCust();
		Thread.sleep(1000);
		cp.custName("Rahul");
		cp.custGender("male");
		cp.custDob("10", "11", "1988");
		cp.custAddress("Mumbai, Borivali");
		cp.custState("Maharashtra");
		cp.custPin("123456");
		cp.custTel("9797979797");
		String email = RandomString() + "gmail.com";
		cp.custEmail(email);
		cp.submit();
		Thread.sleep(3000);

		boolean result = driver.getPageSource().contains("Access denied for user");
		if (result == true) {
			Assert.assertTrue(true);
		} else {
			captureScreen(driver, "AddNewCustomer");
			Assert.assertTrue(false);
		}
	}
}
