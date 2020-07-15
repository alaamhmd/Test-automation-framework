package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndCSVFile extends TestBase {
	HomePage home;
	UserRegistrationPage registration;
	LoginPage login;
	CSVReader reader;

	@Test

	public void userRegisterSuccessfully() throws CsvValidationException, IOException  {

		String csvFile = System.getProperty("user.dir")+"/src/test/java/data/user data.csv";
		reader = new CSVReader(new FileReader(csvFile));
		String[] csvCell;
		while ((csvCell=reader.readNext()) !=null) {

			String fName = csvCell[0];
			String lName = csvCell[1];
			String mail = csvCell[2];
			String password = csvCell[3];

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

}



