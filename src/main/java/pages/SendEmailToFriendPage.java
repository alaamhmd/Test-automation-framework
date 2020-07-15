package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendEmailToFriendPage extends PageBase {

	public SendEmailToFriendPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FriendEmail")
	WebElement friendEmailTxt;
	
	@FindBy(id = "PersonalMessage")
	WebElement personalMessageTxt;
	
	@FindBy(css = "input.button-1.send-email-a-friend-button")
	WebElement sendBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMsg;
	
	public void sendMail(String friendMail,String msg) {
		setTextToWebElement(friendEmailTxt, friendMail);
		setTextToWebElement(personalMessageTxt, msg);
		clickBtn(sendBtn);
		
	}

}
