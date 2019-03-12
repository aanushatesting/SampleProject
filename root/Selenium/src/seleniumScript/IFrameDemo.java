package seleniumScript;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IFrameDemo {
	
	WebDriver d;
	@org.junit.Test
	public void testIframe() throws InterruptedException
	{
		// Load web page
		d.get("https://paytm.com/");
		// Verify page title
		//assertEquals("Citi India - Credit Card | Loan | Investment | Insurance | Banking",d.getTitle());
		// click on Login link
		d.findElement(By.xpath("//div[text()='Log In/Sign Up']")).click();
		Thread.sleep(2000);
		// Switch driver focus to iframe
		d.switchTo().frame(0);
		// Enter user name
		d.findElement(By.name("username")).sendKeys("Selenium");
		Thread.sleep(4000);
	}
	@Before
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		//WebDriver d=new ChromeDriver();
		System.setProperty("webdriver.ie.driver", "E:\\Driver Server\\IEDriverServer.exe");
		//WebDriver d=new InternetExplorerDriver();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
	}
	@After
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}

}
