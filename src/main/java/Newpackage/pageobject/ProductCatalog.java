package Newpackage.pageobject;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import NewPackage.AbstractComponent;

public class ProductCatalog extends AbstractComponent {

     WebDriver driver;
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	  By addToCart = By.cssSelector(".card-body button:last-of-type");
	  By waitby = By.cssSelector(".mb-3");  
	  By tostMessage = By.cssSelector("#toast-container");
	  By buttonclick = By.cssSelector("[routerlink*='cart']");
	  
	  By cartproduct = By.cssSelector(".cartSection h3");
	  
	 @FindBy(css =".mb-3")
	public List<WebElement> products;
	 
	 @FindBy(css=".ng-animating")
	 WebElement spinner;
	 
	 public List<WebElement> getProducts()
	 {
		 waitForElementToAppear(waitby);
		 return products;
	 }
	 
    public WebElement getProductByName(String Productname)
    {
    	
 	     WebElement prod =	getProducts().stream().filter(product->
 		product.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst().orElse(null);
 		
 		return prod;
    }
    
    public void addProductToCart(String Productname)
    {
    	 WebElement prod = getProductByName(Productname);
    	 prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
    	//driver.findElement(By.cssSelector(".totalRow button")).click();
    	 waitForElementToAppear(tostMessage);
    	 
    	 waitForElementToDisappear(spinner);
    	//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
    }
    public void clickOnButton()
    {
      waitForElementToAppear(buttonclick);
      driver.findElement(buttonclick).click();
    }
  
    
	
	//List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
//Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
//Assert.assertTrue(match);
//driver.findElement(By.cssSelector(".totalRow button")).click();

}
