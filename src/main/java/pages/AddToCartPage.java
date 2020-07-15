package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends PageBase {

	public AddToCartPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;

		
	}
	@FindBy(name = "removefromcart")
	WebElement removeBtn;
	
	@FindBy(css = "input.button-2.update-cart-button" )
	WebElement updateCartBtn;
	
	@FindBy(css = "h1" )
	public WebElement pageHeader;
	
	@FindBy(css = "a.product-name" )
	public WebElement productName;
	
	@FindBy(css ="div.no-data" )
	public WebElement successMsg;
	
	@FindBy( id ="itemquantity11235")
	WebElement itemQuantity;
	
	@FindBy( css ="span.product-subtotal")
	public WebElement subTotal;

	@FindBy(id ="checkout")
	WebElement checkoutBtn;
	
	@FindBy(id = "termsofservice")
	WebElement termsOfServiceChkBox;
	
	
	public void updateProductQuantity(String numOfItem) {
		clearWebElement(itemQuantity);
		setTextToWebElement(itemQuantity, numOfItem);
		clickBtn(updateCartBtn);
		
	}
	
	public void removeProductFromCart() {
		clickBtn(removeBtn);
		clickBtn(updateCartBtn);
		
	}
	
	public void openCheckoutPage() {
		scrollToTheMiddle();
		clickBtn(termsOfServiceChkBox);
		clickBtn(checkoutBtn);
		
	}
	

}
