package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	@FindBy(linkText ="Register")
	WebElement registerLink;
	
	@FindBy(linkText ="Log in")
	public WebElement loginLink;
	
	@FindBy(linkText ="Contact us")
	public WebElement contactUsLink;
	
	@FindBy(id ="customerCurrency")
	public WebElement chooseCurrencyDropList;
	
	@FindBy(linkText ="Apparel")
	WebElement apparelMenu;
	
	@FindBy(linkText ="Accessories")
	WebElement accessoriesMenu;
	
	@FindBy(linkText ="Wishlist")
	public WebElement wishlistLink;
	
	@FindBy(linkText ="Shopping cart")
	WebElement shoppingCartLink;
	
	public void openRegistrationPage () {
		clickBtn(registerLink);	
	}
	public void openLoginPage() {
		clickBtn(loginLink);
		
	}
	
	public void openContactUsPage() {
		scrollDown();
		clickBtn(contactUsLink);
	}
	
	public void selectCurrency() {
		select = new Select(chooseCurrencyDropList);
		select.selectByVisibleText("Euro");
		
	}
	
	public void selectAccessoriesMenu() {
		
		action.moveToElement(apparelMenu).perform();
		action.moveToElement(accessoriesMenu).click().build().perform();
			
	}
	
	public void openWishlistPage() {
		clickBtn(wishlistLink);
	}
	
	public void openShoppingCartPage() {
		clickBtn(shoppingCartLink);
	}
	
	
	

}
