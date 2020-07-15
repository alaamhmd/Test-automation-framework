package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SendEmailToFriendPage;
import pages.UserRegistrationPage;

public class SendEmailToFriendTest extends TestBase {

	HomePage home;
	UserRegistrationPage registration;
	LoginPage login;
	SearchPage search;
	ProductDetailsPage productDetails;
	SendEmailToFriendPage sendEmail;
	String productName = "Flower Girl Bracelet";
	

	@Test(priority=1,alwaysRun=true)
	public void userRegisterSuccessfully() {
		home = new HomePage(driver);
		home.openRegistrationPage();
		registration = new UserRegistrationPage(driver);
		registration.registrationPage("Alaa", "Mhmd", "Alllaaa111@gmail.com", "12345678");
		assertEquals("Your registration completed", registration.successfullMsg.getText());
	}


	@Test(priority = 2)
	public void userSearchForProduct() {
		search = new SearchPage(driver);
		search.searchUsingAutoCompleteList("flow");
		productDetails = new ProductDetailsPage(driver);
		assertTrue(productDetails.productNameInBreadCrumb.getText().equalsIgnoreCase(productName ));

	}
	@Test (priority= 3)
	public void userEmailProductToFriend() {
		productDetails.openEmailFriend();
		sendEmail = new SendEmailToFriendPage(driver);
		sendEmail.sendMail("s@x.com", "Hello...");
		assertTrue(sendEmail.successMsg.getText().contains("Your message has been sent"));
		
	}
}
