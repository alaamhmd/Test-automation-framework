package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;


	}

	@FindBy(css ="strong.current-item")
	public WebElement productNameInBreadCrumb;

	@FindBy(css ="input.button-2.email-a-friend-button")
	public WebElement emailFriendBtn;

	@FindBy(id ="price-value-41")
	public WebElement priceCurrencySymbol;

	@FindBy(linkText = "Add your review")
	WebElement addReviewLink;

	@FindBy(id ="add-to-cart-button-41")
	WebElement addToCartBtn;

	@FindBy(css="input.button-2.add-to-compare-list-button")
	WebElement addToCompareListBtn;


	@FindBy(linkText = "product comparison")
	WebElement productComparisonLink;
	
	@FindBy(id ="add-to-wishlist-button-41")
	WebElement addToWishlistBtn;


	public void openEmailFriend() {
		clickBtn(emailFriendBtn);

	}

	public void openAddReviewLink() {
		clickBtn(addReviewLink);

	}

	public void addProductToWishlist() {
		clickBtn(addToWishlistBtn);

	}
	public void addToCompareList() {
		scrollToTheMiddle();
		clickBtn(addToCompareListBtn);
	}

	public void openProductComparisonPage() {
		clickBtn(productComparisonLink);

	}
	
	public void openAddToCartPage() {
		scrollToTheMiddle();
		clickBtn(addToCartBtn);

	}
}
