package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetails extends PageBase {

	public OrderDetails(WebDriver driver) {
		super(driver);
	}
	@FindBy (css ="a.button-2.print-order-button")
	WebElement printBtn;
	
	@FindBy (css ="a.button-2.pdf-invoice-button")
	WebElement pdfInvoiceBtn;
	
	public void printOrderDetails() {
		clickBtn(printBtn);	
	}
	
	public void downloadPDFInvoice() {
		clickBtn(pdfInvoiceBtn);
	}
}
