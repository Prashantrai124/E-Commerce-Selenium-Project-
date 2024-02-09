package NewPackage.pageObject;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Newpackage.pageobject.CartPage;
import Newpackage.pageobject.CheckoutPage;
import Newpackage.pageobject.ConfirmationPage;
import Newpackage.pageobject.LandingPage;
import Newpackage.pageobject.ProductCatalog;
import reusableComponent.AbstractComponent;
import reusableComponent.iTestListenerClass;


public class SubmitOrderTest {
	public static WebDriver driver = new ChromeDriver();
	String productName = "ZARA COAT 3";
	String countyName ="India";

	LandingPage landingPage = new LandingPage(driver);
	ProductCatalog productCatalog = new ProductCatalog(driver);
	CartPage cartpage = new CartPage(driver);

	CheckoutPage checkout = new CheckoutPage(driver);

	ConfirmationPage confirm = new ConfirmationPage(driver);

    @BeforeTest
	public void openBrowser() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//driver.get("https://rahulshettyacademy.com/client");
	}

	@Test(priority = 1, testName="LandingPage")
	public void Landingpage() {
		landingPage.goTo();
	}

	@Test(priority = 2,testName="Login Page")
	public void LoginIntoWebsite() {
		landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
	}

	@Test(priority = 3, dependsOnMethods="LoginIntoWebsite" ,testName="Getting all the Productss")
	public void GettingProduct() {
		List<WebElement> productsss = productCatalog.getProducts();
		productCatalog.addProductToCart(productName);
	}

	// System.out.println(productsss);
	@Test(priority = 3, dependsOnMethods="GettingProduct" ,testName="Click on Cart Button")
	public void ClickOnCart() throws InterruptedException {
		productCatalog.goToCartPage();
	}

	@Test(priority = 4,dependsOnMethods="ClickOnCart",testName="Veryfying the Produt")
	public void VeryfyingProduct() {
	
		Boolean match = cartpage.VerifyProductDisplay(productName);
		Assert.assertFalse(match);
	}

	@Test(priority = 5,dependsOnMethods="VeryfyingProduct" ,testName="Check Out Page")
	public void CheckoutPage() {
		cartpage.goToCheckout();

		checkout.selectCountry("india");
	}

	@Test(priority = 6,dependsOnMethods="CheckoutPage")
	public void SubmitOrder() throws InterruptedException {
		checkout.submitOrder();
	}

	@Test(priority = 7)
	public void OrderCompleted() {
		String confirmMessage = confirm.getConfirmationMessage();// .getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	@AfterTest
	public void CloseBrowser()
	{
		//driver.quit();
	}

}
