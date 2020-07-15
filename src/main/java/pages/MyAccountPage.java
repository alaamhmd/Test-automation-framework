package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id ="OldPassword")
	WebElement oldPasswordTxt;
	
	@FindBy(id ="NewPassword")
	WebElement newPasswordTxt;
	
	@FindBy(id ="ConfirmNewPassword")
	WebElement confirmPasswordTxt;
	
	@FindBy(css ="input.button-1.change-password-button")
	WebElement changePasswordBtn;
	
	@FindBy(css ="div.result")
	public WebElement changePasswordMsg;
	
	@FindBy(linkText="Change password")
	 WebElement changePasswordLink;
	
	public void openChangePasswordPage() {
		clickBtn(changePasswordLink);
	}
	
	public void userChangePassword(String oldPassword,String newPassword) {
		setTextToWebElement(oldPasswordTxt, oldPassword);
		setTextToWebElement(newPasswordTxt,newPassword );
		setTextToWebElement(confirmPasswordTxt,newPassword );
		clickBtn(changePasswordBtn); 
	}
	
	
	

}
