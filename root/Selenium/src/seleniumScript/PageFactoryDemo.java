package seleniumScript;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageFactoryDemo {
	
	WebDriver d;
	@Test
	public void testLogin() throws InterruptedException
	{
		// Load web page
		d.get("https://demo.cyclos.org/");
		// Verify page title
		assertTrue(d.getTitle().contains("Cyclos4 Communities"));
		
		OR page=new OR(d);
		page.fillLogin("demo", "1234");
		
		/*//Click on Sign in link
		page.lnkSignin.click();
		Thread.sleep(2000);
		// Enter user name
		page.txtUsername.sendKeys("demo");
		// Enter password
		page.txtPassword.sendKeys("1234");
		// Click on sign in button
		page.btnSignin.click();*/
		Thread.sleep(2000);
		page.lnkLogout.click();
		Thread.sleep(2000);
		
	}
	@BeforeMethod
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
	@AfterMethod
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}

}
