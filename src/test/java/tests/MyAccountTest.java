package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {

	HomePage home;
	UserRegistrationPage registration;
	MyAccountPage myAccount;
	LoginPage login;
	String oldPassword = "12345678";
	String newPassword ="123456";
	String mail = "axya12@gmail.com";

	// create new user
	@Test(priority=1)
	public void userRegisterSuccessfully() {
		home = new HomePage(driver);
		home.openRegistrationPage();
		registration = new UserRegistrationPage(driver);
		registration.registrationPage("Alaa", "Mhmd",mail , oldPassword);
		assertEquals("Your registration completed", registration.successfullMsg.getText());
	}
	
	// change current password
	@Test(priority=2)
	public void userChangePassword() {
		registration.openMyAccountPage();
		myAccount = new MyAccountPage(driver);
		myAccount.openChangePasswordPage();
		myAccount.userChangePassword(oldPassword, newPassword);
		assertTrue(myAccount.changePasswordMsg.getText().contains("Password was changed"));

	}

	// logout
	@Test(priority=3)
	public void userLogoutSuccessfully() {
		registration.userLogout();
	}

	// login again with the new password
	@Test(dependsOnMethods = {"userLogoutSuccessfully"})
	public void userloginSuccessfully() {
		home.openLoginPage();
		login = new LoginPage(driver);
		login.userLogin(mail, newPassword);
		assertTrue(registration.logoutBtn.getText().contains("Log out"));

	}



}

