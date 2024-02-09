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

public class StandAloneTest extends BaseTest {
	public static WebDriver driver;
	
	

	@Test
	public void submitOrder() throws IOException, InterruptedException {
		LandingPage landingpage = launchApplicaion();
		String productName = "ZARA COAT 3";
		String countyName = "India";
		ProductCatalog productCatalog = landingpage.loginApplication("anshika@gmail.com", "Iamking@000");
		List<WebElement> productsss = productCatalog.getProducts();
		productCatalog.addProductToCart(productName);
		
		CartPage cartPage = productCatalog.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
	
	
	
	   CheckoutPage checkoutPage = cartPage.goToCheckout();
		  
		checkoutPage.selectCountry(countyName);
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage().toString();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	

//				driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
//				driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
//				driver.findElement(By.id("login")).click();
//				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//				Thread.sleep(3000);
//				
//				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//					List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//				
//			WebElement prod =	products.stream().filter(product->
//				product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
//				prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//				
//				
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//				//ng-animating
//				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//				driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//				
//				List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
//			Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
//			Assert.assertTrue(match);
//			driver.findElement(By.cssSelector(".totalRow button")).click();
//			
//			Actions a = new Actions(driver);
//			a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//			
//			driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//			Thread.sleep(3000);
//			driver.findElement(By.cssSelector(".action__submit")).click();
//			
//			String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//			
//			Thread.sleep(3000);
//			driver.close();

	}

}
