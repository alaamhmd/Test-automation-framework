package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import data.JSONDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndJSONFile extends TestBase {
	HomePage home;
	UserRegistrationPage registration;
	LoginPage login;
	JSONDataReader jsonReader;


	@Test

	public void userRegisterSuccessfully() throws FileNotFoundException, IOException, ParseException   {

		jsonReader = new JSONDataReader();
		jsonReader.jsonReader();
		home = new HomePage(driver);
		home.openRegistrationPage();
		registration = new UserRegistrationPage(driver);
		registration.registrationPage(jsonReader.fName,jsonReader.lName,jsonReader.mail,jsonReader.password);
		assertEquals("Your registration completed", registration.successfullMsg.getText());
		registration.userLogout();
		home.openLoginPage();
		login = new LoginPage(driver);
		login.userLogin(jsonReader.mail,jsonReader.password);
		assertTrue(registration.logoutBtn.getText().contains("Log out"));
		registration.userLogout();


	}

}





