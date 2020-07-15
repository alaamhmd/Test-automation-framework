package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddToCompareListPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToComparelistTest extends TestBase {
	
	SearchPage search;
	ProductDetailsPage productDetails;
	String firstProductName = "Nikon D5500 DSLR";
	String secondProductName = "Leica T Mirrorless Digital Camera";
	AddToCompareListPage compare;

//searching for a product using auto suggest list
	@Test(priority =1)
	public void userAddProductsToCompareList()  {
		search = new SearchPage(driver);
		productDetails = new ProductDetailsPage(driver);
		compare = new AddToCompareListPage(driver);

		search.searchUsingAutoCompleteList("niko");
		assertTrue(productDetails.productNameInBreadCrumb.getText().equalsIgnoreCase(firstProductName));
		productDetails.addToCompareList();
		
		search.searchUsingAutoCompleteList("leic");
		productDetails = new ProductDetailsPage(driver);
		assertTrue(productDetails.productNameInBreadCrumb.getText().equalsIgnoreCase(secondProductName));
		productDetails.addToCompareList();
		productDetails.openProductComparisonPage();
		compare.compareProducts();

	}
	
	@Test(priority =2)
	public void usercClearCompareList(){
		
		compare = new AddToCompareListPage(driver);

		compare.clearCompareList();
	}
	
	
	

}
