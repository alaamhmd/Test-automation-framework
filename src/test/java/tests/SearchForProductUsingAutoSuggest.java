package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchForProductUsingAutoSuggest extends TestBase {
	SearchPage search;
	ProductDetailsPage productDetails;
	String productName = "Flower Girl Bracelet";

//searching for a product using auto suggest list
	@Test
	public void userSearchForProduct() {
		search = new SearchPage(driver);
		search.searchUsingAutoCompleteList("flow");
		productDetails = new ProductDetailsPage(driver);
		assertTrue(productDetails.productNameInBreadCrumb.getText().equalsIgnoreCase(productName ));

	}


}
