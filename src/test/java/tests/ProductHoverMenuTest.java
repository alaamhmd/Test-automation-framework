package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase {
	HomePage home;
	
	@Test
	public void userUseApparelMenuSubMenu(){
		home = new HomePage(driver);
		home.selectAccessoriesMenu();
		assertTrue(driver.getCurrentUrl().contains("accessories"));
	}

}
