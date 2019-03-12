package seleniumScript;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CC {
	WebDriver d;
	@org.testng.annotations.Test
	public void testAjax() throws InterruptedException
	{
		// Load web page
		d.get("file:///C:/Users/Q%20T/Desktop/XPath.html");
		d.findElement(By.cssSelector("#b:first")).sendKeys("selenium");
		Thread.sleep(2000);
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
