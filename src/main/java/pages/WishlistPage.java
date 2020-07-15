package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage  extends PageBase{

	public WishlistPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css ="a.product-name")
	public WebElement productNamee;
	
	@FindBy(name ="removefromcart")
    WebElement removeFromCartChkBox;
	
	@FindBy(css ="input.button-2.update-wishlist-button")
    WebElement updateWishlistButton;
	
	@FindBy(css ="div.no-data")
	public WebElement successMsg;
	
	public void removeProductFromWishlist() {
		
		clickBtn(removeFromCartChkBox);
		clickBtn(updateWishlistButton);
	}
	
	
	

}
