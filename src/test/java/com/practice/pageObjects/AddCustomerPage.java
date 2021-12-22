package com.practice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[contains(.,'New Customer')]")
	WebElement lnknewCustomer;

	@FindBy(name = "name")
	WebElement txtcustName;

	@FindBy(name = "rad1")
	WebElement rdGender;

	@FindBy(name = "dob")
	WebElement txtDOB;

	@FindBy(name = "addr")
	WebElement txtAddress;

	@FindBy(name = "city")
	WebElement txtCity;

	@FindBy(name = "state")
	WebElement txtState;

	@FindBy(name = "pinno")
	WebElement txtPin;

	@FindBy(name = "telephoneno")
	WebElement txtPhone;

	@FindBy(name = "emailid")
	WebElement txtEmail;

	@FindBy(name = "sub")
	WebElement btnSubmit;

	@FindBy(name = "res")
	WebElement btnReset;

	public void clickNewCust() {
		lnknewCustomer.click();
	}

	public void custName(String cname) {
		txtcustName.sendKeys(cname);
	}

	public void custGender(String gndr) {
		rdGender.click();
	}

	public void custDob(String mm, String dd, String yy) {
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yy);
	}

	public void custAddress(String address) {
		txtAddress.sendKeys(address);
	}

	public void custCity(String city) {
		txtCity.sendKeys(city);
	}

	public void custState(String state) {
		txtState.sendKeys(state);
	}

	public void custPin(String pin) {
		txtPin.sendKeys(String.valueOf(pin));
	}

	public void custTel(String phone) {
		txtPhone.sendKeys(phone);
	}

	public void custEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void submit() {
		btnSubmit.click();
	}

	public void reset() {
		btnReset.click();
	}
}
