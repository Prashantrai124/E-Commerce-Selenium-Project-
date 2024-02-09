package NewPackage.pageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Newpackage.pageobject.CartPage;
import Newpackage.pageobject.CheckoutPage;
import Newpackage.pageobject.ConfirmationPage;
import Newpackage.pageobject.LandingPage;
import Newpackage.pageobject.ProductCatalog;
import testComponent.BaseTest;

public class ErrorValidation extends BaseTest {
	public static WebDriver driver;
	
	

	@Test
	public void submitOrder() throws IOException, InterruptedException {
		LandingPage landingpage = launchApplicaion();
		String productName = "ZARA COAT 3";
		String countyName = "India";
		landingpage.loginApplication("anshika@gmail.com", "Iamking@000");
		Assert.assertEquals("Incorrect email or password",landingpage.getErrorMessage());
	
	}

}
