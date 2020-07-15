package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddToCartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetails;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class RegisterdUserCheckout extends TestBase{
	HomePage home;
	UserRegistrationPage registration;
	LoginPage login;
	SearchPage search;
	ProductDetailsPage productDetails;
	AddToCartPage addToCart;
	CheckoutPage checkout;
	String productName = "Flower Girl Bracelet";
	OrderDetails order;


	@Test(priority=1,alwaysRun=true)
	public void userRegisterSuccessfully() {
		home = new HomePage(driver);
		home.openRegistrationPage();
		registration = new UserRegistrationPage(driver);
		registration.registrationPage("Alaa", "Mhmd", "sfmm0@gai.com", "12345678");
		assertEquals("Your registration completed", registration.successfullMsg.getText());
	}


	//searching for a product using auto suggest list
	@Test(priority=2)
	public void userSearchForProduct() {
		search = new SearchPage(driver);
		search.searchUsingAutoCompleteList("flow");
		productDetails = new ProductDetailsPage(driver);
		assertTrue(productDetails.productNameInBreadCrumb.getText().equalsIgnoreCase(productName ));

	}

	@Test(priority = 3)
	public void userAddItemToCart ()  {

		addToCart = new AddToCartPage(driver);
		productDetails = new ProductDetailsPage(driver);
		productDetails.openAddToCartPage();
		home = new HomePage(driver);
		home.openShoppingCartPage();
		assertTrue(addToCart.pageHeader.isDisplayed());
		assertTrue(addToCart.productName.getText().contains(productName));
	}
	@Test(priority = 4)
	public void userCheckout()  {
		addToCart = new AddToCartPage(driver);
		addToCart.openCheckoutPage();
		checkout = new CheckoutPage(driver);
		checkout.registerdUserCheckout("Egypt", "aa", "123", "456", "cairo");
		checkout.openOrderDetailsPage();
		order = new  OrderDetails(driver);
		order.downloadPDFInvoice();

		order.printOrderDetails();

	}

}


