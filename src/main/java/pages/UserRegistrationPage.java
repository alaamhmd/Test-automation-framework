package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(id ="gender")
	WebElement genderRadioBtn;

	@FindBy(id ="FirstName")
	WebElement firstNameTxt;

	@FindBy(id ="LastName")
	WebElement lastNameTxt;

	@FindBy(id ="Email")
	WebElement emailTxt;

	@FindBy(id ="Password")
	WebElement passwordTxt;

	@FindBy(id ="ConfirmPassword")
	WebElement confirmPasswordTxt;

	@FindBy(id ="register-button")
	WebElement registerBtn;

	@FindBy(css ="div.result")
	public WebElement successfullMsg;
	
	@FindBy(linkText="Log out")
	public WebElement logoutBtn;
	
	@FindBy(linkText="My account")
	 WebElement myAccountBtn;
	
	public void registrationPage(String firstName,String lastName,String email ,String password) {
		clickBtn(genderRadioBtn);
		setTextToWebElement(firstNameTxt, firstName);
		setTextToWebElement(lastNameTxt, lastName);
		setTextToWebElement(emailTxt, email);
		setTextToWebElement(passwordTxt, password);
		setTextToWebElement(confirmPasswordTxt, password);
		clickBtn(registerBtn);
	}
	
	public void userLogout() {
		clickBtn(logoutBtn);
	}
	public void openMyAccountPage() {
		clickBtn(myAccountBtn);
	}
	


}
