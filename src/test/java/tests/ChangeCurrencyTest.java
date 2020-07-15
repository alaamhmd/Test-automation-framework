 package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
	HomePage home;
	SearchPage search;
	ProductDetailsPage productDetails;
	String productName = "Flower Girl Bracelet";

	@Test(priority=1)
	public void userChangeCurrency() {
		home = new HomePage(driver);
		home.selectCurrency();
	}
	
	@Test(priority = 2)
	public void userSearchForProduct() {
		search = new SearchPage(driver);
		search.searchUsingAutoCompleteList("flow");
		productDetails = new ProductDetailsPage(driver);
		assertTrue(productDetails.productNameInBreadCrumb.getText().equalsIgnoreCase(productName ));
		assertTrue(productDetails.priceCurrencySymbol.getText().contains("Ђ"));
		System.out.println("your currency is : "+ productDetails.priceCurrencySymbol.getText());

	}


}
