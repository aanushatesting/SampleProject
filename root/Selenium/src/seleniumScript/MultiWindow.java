package seleniumScript;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MultiWindow {
	WebDriver d;
	@org.testng.annotations.Test
	public void testMultiwindow() throws InterruptedException
	{
		// Load web page
		d.get("https://www.online.citibank.co.in/");
		// Verify page title
		assertEquals("Citi India - Credit Card | Loan | Investment | Insurance | Banking",d.getTitle());
		// Click on Login
		d.findElement(By.linkText("Login")).click();
		Thread.sleep(4000);
		/*Set<String> h=d.getWindowHandles();
		for(String s:h)
		{
			System.out.println(s);
		}*/
		ArrayList<String> al=new ArrayList<String>(d.getWindowHandles());
		// Switch driver home page to login page
		d.switchTo().window(al.get(1));
		assertTrue(d.findElement(By.id("User_Id")).isDisplayed());
		// Switch driver focus Login to home page
		d.switchTo().window(al.get(0));
		assertTrue(d.findElement(By.linkText("Login")).isDisplayed());
		Thread.sleep(3000);
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
