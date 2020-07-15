package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchTest extends TestBase {
	
	SearchPage search;
	ProductDetailsPage productDetails;
	String productName = "Flower Girl Bracelet";
	
	//searching for a product using product full name

	@Test
	public void userSearchForProduct() {
		search = new SearchPage(driver);
		search.searchForProduct(productName);
		productDetails = new ProductDetailsPage(driver);
		search.openProductLink();
		assertTrue(productDetails.productNameInBreadCrumb.getText().equalsIgnoreCase(productName ));
		
	}
	
	

}
