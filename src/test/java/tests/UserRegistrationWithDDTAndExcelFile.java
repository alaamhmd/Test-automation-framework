package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndExcelFile extends TestBase {
	HomePage home;
	UserRegistrationPage registration;
	LoginPage login;


	@DataProvider(name="testData")
	public static Object [][] userData() throws IOException {
		ExcelReader reader = new ExcelReader();
		return reader.getExcelData();

	}


	@Test(dataProvider ="testData")
	
	public void userRegisterSuccessfully(String fName,String lName,String mail,String password)   {
		
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
		registration.userLogout();

		
		
	}

}



