package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	protected WebDriver drvier;
	public JavascriptExecutor js;
	public Select select;
	public Actions action;

	
	public  PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	protected static void clickBtn(WebElement button) {
		button.click();
		
	}
	protected static void setTextToWebElement(WebElement textbox ,String value) {
		textbox.sendKeys(value);
		
	}
	
	protected static void clearWebElement(WebElement textbox) {
		textbox.clear();
		
	}
	
	public void scrollDown() {
		
		js.executeScript("scrollBy(0,2500)");
	}
	public void scrollToTheMiddle() {
		
		js.executeScript("scrollBy(0,150)");
	}
	

}
