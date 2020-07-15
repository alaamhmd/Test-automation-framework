package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddReviewPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddReviewTest extends TestBase {
	
	HomePage home;
	UserRegistrationPage registration;
	SearchPage search;
	ProductDetailsPage productDetails;
	AddReviewPage addReview;
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
	@Test (priority =3)
	
	public void userAddReview() {
		productDetails = new ProductDetailsPage(driver);
		productDetails.openAddReviewLink();
		addReview = new AddReviewPage(driver);
		addReview.addReview("good item", "i loved this soo much");
		assertTrue(addReview.successMsg.getText().contains("Product review is successfully added."));
		
		
	}
	

}
