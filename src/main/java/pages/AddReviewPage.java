package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends PageBase {

	public AddReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "AddProductReview_Title")
	WebElement productReviewTitleTxt;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement productReviewTxt;
	
	@FindBy(css = "input.button-1.write-product-review-button")
	WebElement submitBtn;
	
	@FindBy(id = "addproductrating_3")
	WebElement productRating;
	
	@FindBy(css = "div.result")
	public WebElement successMsg;
	
	public void addReview(String reviewTitle , String review) {
		setTextToWebElement(productReviewTitleTxt, reviewTitle);
		setTextToWebElement(productReviewTxt, review);
		clickBtn(productRating);
		clickBtn(submitBtn);
		
	}
	

}
