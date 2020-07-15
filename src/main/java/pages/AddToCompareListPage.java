package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCompareListPage extends PageBase{

	public AddToCompareListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy( css = "a.clear-list")
	WebElement clearBtn;
	
	@FindBy(css = "table.compare-products-table")
	WebElement compareTable;
	
	@FindBy(tagName = "tr")
	List<WebElement> tableRows;
	
	@FindBy(tagName = "td")
	List<WebElement> tableCols;
	
	@FindBy(css = "div.no-data")
	WebElement noDataLabel;
	
	public void clearCompareList() {
		clickBtn(clearBtn);	
	}
	
	public void compareProducts() {
		for(WebElement rows : tableRows)
		{
			System.out.println(rows.getText() + "\t");
			for(WebElement cols : tableCols) {
				System.out.println(cols.getText() + "\t");
			}
		}
	}
	
}




