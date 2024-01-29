package NewPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul/li[4]/button")
	WebElement addCartButton;

	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
   public void waitForElementToDisappear(WebElement findBy)
   {
	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	   wait.until(ExpectedConditions.invisibilityOf(findBy));
   }
   
   public void goToCartButton() throws InterruptedException
   {
	 Thread.sleep(2000);
	  addCartButton.click();
   }
	
}
