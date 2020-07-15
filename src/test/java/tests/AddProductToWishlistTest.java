package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase {
	
	SearchPage search;
	ProductDetailsPage productDetails;
	WishlistPage wishlist;
	HomePage home;
	String productName = "Flower Girl Bracelet";
	

//searching for a product using auto suggest list
	@Test(priority =1)
	public void userSearchForProduct() {
		search = new SearchPage(driver);
		search.searchUsingAutoCompleteList("flow");
		productDetails = new ProductDetailsPage(driver);
		assertTrue(productDetails.productNameInBreadCrumb.getText().equalsIgnoreCase(productName ));
		

	}
	
	@Test(priority=2)
	public void userAddProductToWishlist()  {
		
		productDetails = new ProductDetailsPage(driver);
		productDetails.addProductToWishlist();
		home = new HomePage(driver);
		home.openWishlistPage();
		assertTrue(driver.getCurrentUrl().contains("wishlist"));
		wishlist = new WishlistPage(driver);
		assertTrue(wishlist.productNamee.getText().contains(productName));
		
	}
	
	@Test(priority=3)
	public void userRemoveProductToWishlist(){
		
		wishlist = new WishlistPage(driver);
		wishlist.removeProductFromWishlist();
		assertTrue(wishlist.successMsg.getText().contains("The wishlist is empty!"));
		
		
		
	
	}
}
