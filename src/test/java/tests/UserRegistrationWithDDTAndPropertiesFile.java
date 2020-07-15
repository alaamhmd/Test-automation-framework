package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndPropertiesFile extends TestBase {
	HomePage home;
	UserRegistrationPage registration;
	LoginPage login;
	String fName=LoadProperties.userData.getProperty("firstName");
	String lName=LoadProperties.userData.getProperty("lastName");
	String mail=LoadProperties.userData.getProperty("mail");
	String password=LoadProperties.userData.getProperty("password");



	@Test(priority=1,alwaysRun=true)
	
	public void userRegisterSuccessfully()  {
		
		home = new HomePage(driver);
		home.openRegistrationPage();
		registration = new UserRegistrationPage(driver);
		registration.registrationPage(fName,lName,mail,password);
		assertEquals("Your registration completed", registration.successfullMsg.getText());
		registration.userLogout();
		home.openLoginPage();
		login = new LoginPage(driver);
		login.userLogin(mail, password);
		assertTrue(registration.logoutBtn.getText().contains("Log out"));
		//registration.userLogout();
		
	}

}



