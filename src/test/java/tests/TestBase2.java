package tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import helper.Helpers;

public class TestBase2 {
	public static String url = "https://demo.nopcommerce.com/";

	protected ThreadLocal<RemoteWebDriver> driver = null;

	@BeforeTest
	@Parameters(value = {"browser"})
	public void setup( @Optional ("firefox") String browser) throws MalformedURLException {
		driver = new ThreadLocal<>();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("browserName", browser);
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap));
		getDriver().navigate().to(url);

	}

	public WebDriver getDriver() {

		return driver.get();
	}

	@AfterTest 
	public void stopDriver() {
		getDriver().quit();
		driver.remove();

	}


	@AfterMethod
	public void screenshotOnFailure(ITestResult result) throws IOException {

		if (result.getStatus() ==ITestResult.FAILURE) {
			System.out.println("TC " + result.getName() + " Failed !");
			System.out.println("Taking screenshot.....");
			Helpers.captureScreenshot(getDriver(), result.getName());


		}


	}


}