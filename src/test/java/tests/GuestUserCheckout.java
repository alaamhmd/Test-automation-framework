package tests;

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

public class GuestUserCheckout  extends TestBase{
	HomePage home;
	UserRegistrationPage registration;
	LoginPage login;
	SearchPage search;
	ProductDetailsPage productDetails;
	AddToCartPage addToCart;
	CheckoutPage checkout;
	String productName = "Flower Girl Bracelet";
	OrderDetails order;
	

	
	@Test(priority=1)
	public void userSearchForProduct() {
		search = new SearchPage(driver);
		search.searchUsingAutoCompleteList("flow");
		productDetails = new ProductDetailsPage(driver);
		assertTrue(productDetails.productNameInBreadCrumb.getText().equalsIgnoreCase(productName ));

	}
	
	@Test(priority = 2)
	public void userAddItemToCart ()  {

		addToCart = new AddToCartPage(driver);
		productDetails = new ProductDetailsPage(driver);
		productDetails.openAddToCartPage();
		home = new HomePage(driver);
		home.openShoppingCartPage();
		assertTrue(addToCart.pageHeader.isDisplayed());
		assertTrue(addToCart.productName.getText().contains(productName));
	}
	
	@Test(priority = 3)
	public void userCheckout()   {
		addToCart = new AddToCartPage(driver);
		addToCart.openCheckoutPage();
		checkout = new CheckoutPage(driver);
		checkout.openCheckoutAsGuestPage();
		checkout.userCheckoutAsGuest("alaa", "mhmd", "tes344t@t.com", "Egypt", "xxx", "123", "1234", "CAIRO");
		order = new  OrderDetails(driver);
		checkout.openOrderDetailsPage();
		order.downloadPDFInvoice();
		order.printOrderDetails();

	}

}
