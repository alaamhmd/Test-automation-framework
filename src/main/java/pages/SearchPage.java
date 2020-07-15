package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "small-searchterms")
	WebElement searchTxtBox;
	
	@FindBy (css = "input.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy (id = "ui-id-1")
	List <WebElement> autoSuggestList;
	
	@FindBy (linkText = "Flower Girl Bracelet")
	WebElement productLink;
	

	public void searchForProduct(String text) {
		
		setTextToWebElement(searchTxtBox, text);
		clickBtn(searchBtn);
	}
	
	public void openProductLink() {
		clickBtn(productLink);
	}
	
	public void searchUsingAutoCompleteList(String productName) {
		setTextToWebElement(searchTxtBox, productName);
		autoSuggestList.get(0).click();
		
	}
}
