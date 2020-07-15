package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	HomePage home;
	UserRegistrationPage registration;
	LoginPage login;
	

	@Test(priority=1,alwaysRun=true)
	public void userRegisterSuccessfully() {
		home = new HomePage(driver);
		home.openRegistrationPage();
		registration = new UserRegistrationPage(driver);
		registration.registrationPage("Alaa", "Mhmd", "Alllaaa111@gmail.com", "12345678");
		assertEquals("Your registration completed", registration.successfullMsg.getText());
	}
	
	@Test(dependsOnMethods = {"userRegisterSuccessfully"})
	public void userLogoutSuccessfully() {
		registration.userLogout();
	}
	
	@Test(dependsOnMethods = {"userLogoutSuccessfully"})
	public void userloginSuccessfully() {
		home.openLoginPage();
		login = new LoginPage(driver);
		login.userLogin("Alllaaa111@gmail.com", "12345678");
		assertTrue(registration.logoutBtn.getText().contains("Log out"));
		
	}


}
