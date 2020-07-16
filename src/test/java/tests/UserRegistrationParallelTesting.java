package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationParallelTesting extends TestBase2{
	HomePage home;
	UserRegistrationPage registration;
	LoginPage login;
	Faker fakeData;

	@Test

	public void userRegisterSuccessfully()    {

		fakeData = new Faker();
		String fName =fakeData.name().firstName();
		String lName = fakeData.name().lastName();
		String mail =fakeData.internet().emailAddress();
		String password = fakeData.number().digits(6).toString();
		System.out.println(fName+"  "+lName +" " + mail +"  "+password);
		home = new HomePage(getDriver());
		home.openRegistrationPage();
		registration = new UserRegistrationPage(getDriver());
		registration.registrationPage(fName,lName,mail,password);
		assertEquals("Your registration completed", registration.successfullMsg.getText());
		registration.userLogout();
		home.openLoginPage();
		login = new LoginPage(getDriver());
		login.userLogin(mail,password);
		assertTrue(registration.logoutBtn.getText().contains("Log out"));
		registration.userLogout();


	}
}
