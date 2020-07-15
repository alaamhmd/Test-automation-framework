package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase {
	HomePage home;
	UserRegistrationPage registration;
	LoginPage login;

	@DataProvider(name="testData")
	public static Object [][] userData() {
		
		return new Object[][] {
			{"alaa","mhmd","al3li1a@gmil.com","123456"},
			{"Alaa", "Mhmd", "All3laaa111@gmal.com", "12345678"}
		};
		
	}
	


	@Test(priority=1,alwaysRun=true,dataProvider ="testData")
	
	public void userRegisterSuccessfully(String fName,String lName,String mail,String password)  {
		
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



