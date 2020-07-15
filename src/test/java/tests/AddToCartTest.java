package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddToCartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddToCartTest extends TestBase {

	SearchPage search;
	ProductDetailsPage productDetails;
	AddToCartPage addToCart;
	HomePage home;
	String productName = "Flower Girl Bracelet";

	//searching for a product using auto suggest list
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
		//addToCart.updateProductQuantity("5");
		//assertTrue(addToCart.subTotal.getText().contains("1,800.00"));

	}
	
	@Test(priority = 3)
	public void userClearCart ()  {
		addToCart = new AddToCartPage(driver);
		addToCart.removeProductFromCart();
		assertTrue(addToCart.successMsg.getText().contains("Your Shopping Cart is empty!"));

	}
	
	

}
