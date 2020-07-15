package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
	HomePage home;
	ContactUsPage contactUs;
	String fullName = "Alaa";
	String mail = "test@test.com";
	String comment = "Hi, it's a test :D"; 
	
	@Test
	public void userUseContactUs() {
		home = new HomePage(driver);
		home.openContactUsPage();
		contactUs = new ContactUsPage(driver);
		contactUs.contactUs(fullName, mail, comment);
		assertTrue(contactUs.successMsg.getText().contains("Your enquiry has been successfully sent."));
		
	}

	
}
