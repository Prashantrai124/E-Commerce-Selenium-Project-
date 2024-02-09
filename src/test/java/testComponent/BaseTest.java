package testComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Newpackage.pageobject.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public WebDriver initilzeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//GlobalProperties//GlobalData.properties");
		prop.load(fis);
		String browserName =prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("edge"))
		{
			//Edge Browser;
			
		}else {
			
			//Other Bowser
			
		}
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	@BeforeMethod
	public LandingPage launchApplicaion() throws IOException
	{
		driver =initilzeDriver();
		LandingPage landingpage = new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
