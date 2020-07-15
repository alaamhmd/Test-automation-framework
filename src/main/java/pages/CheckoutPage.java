package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;

	}
	@FindBy(css ="input.button-1.new-address-next-step-button")
	WebElement continueBtn1;
	
	
	@FindBy(css ="input.button-1.shipping-method-next-step-button")
	WebElement continueBtn2;
	
	
	@FindBy(css ="input.button-1.payment-method-next-step-button")
	WebElement continueBtn3;
	
	
	@FindBy(css ="input.button-1.payment-info-next-step-button")
	WebElement continueBtn4;
	
	
	@FindBy(css ="input.button-1.confirm-order-next-step-button")
	WebElement continueBtn5;
	
	
	@FindBy(css = "div.title")
	public WebElement successMsg;
	
	
	@FindBy(css ="input.button-1.order-completed-continue-button")
	WebElement continueBtn6;
	
	@FindBy(css ="input.button-1.checkout-as-guest-button")
	WebElement checkoutAsGuestBtn;
	
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement firstNameTxt;
	
	@FindBy(id ="BillingNewAddress_LastName")
	WebElement lastNameTxt;
	
	@FindBy(id ="BillingNewAddress_Email")
	WebElement emailTxt;
	
	@FindBy(id ="BillingNewAddress_CountryId")
	WebElement countrySelect;
	
	@FindBy(id="BillingNewAddress_StateProvinceId")
	WebElement stateSelect;
	
	@FindBy(id ="BillingNewAddress_City")
	WebElement cityTxt;
	
	@FindBy(id ="BillingNewAddress_Address1")
	WebElement addressTxt;
	
	@FindBy(id ="BillingNewAddress_ZipPostalCode")
	WebElement postalCodeTxt;
	
	@FindBy(id ="BillingNewAddress_PhoneNumber")
	WebElement phoneNumTxt;
	
	@FindBy(css="input.button-1.new-address-next-step-button")
	WebElement continueBtn7;
	
	@FindBy(linkText = "Click here for order details.")
	WebElement orderDetailsLink;
	
	public void registerdUserCheckout(String countryName,String address,String postcode,String phone,String city)   {
		select = new Select(countrySelect);
		select.selectByVisibleText(countryName);
		setTextToWebElement(addressTxt, address);
		setTextToWebElement(cityTxt, city);
		setTextToWebElement(postalCodeTxt, postcode);
		setTextToWebElement(phoneNumTxt, phone);		
		clickBtn(continueBtn1);
		clickBtn(continueBtn2);
		clickBtn(continueBtn3);
		clickBtn(continueBtn4);
		clickBtn(continueBtn5);
	}
	
	public void openOrderDetailsPage() {
		clickBtn(orderDetailsLink);
		
	}
	
	public void openCheckoutAsGuestPage() {
		scrollToTheMiddle();
		
		clickBtn(checkoutAsGuestBtn);
		
	}
	public void userCheckoutAsGuest(String firstName,String lastName, String mail,
			String countryName,String address,String postcode,String phone,String city)   {
		setTextToWebElement(firstNameTxt, firstName);
		setTextToWebElement(lastNameTxt, lastName);
		setTextToWebElement(emailTxt, mail);
		select = new Select(countrySelect);
		select.selectByVisibleText(countryName);
		setTextToWebElement(addressTxt, address);
		setTextToWebElement(cityTxt, city);
		setTextToWebElement(postalCodeTxt, postcode);
		setTextToWebElement(phoneNumTxt, phone);		
		clickBtn(continueBtn1);
		clickBtn(continueBtn2);
		clickBtn(continueBtn3);
		clickBtn(continueBtn4);
		clickBtn(continueBtn5);
	}

}
