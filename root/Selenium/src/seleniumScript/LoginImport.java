package seleniumScript;

import static org.testng.Assert.*;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginImport {
	
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		// Load web page
		d.get("https://demo.cyclos.org/");
		// Verify page title
		assertTrue(d.getTitle().contains("Cyclos4 Communities"));
		// Read data from excel
		FileInputStream fis=new FileInputStream("E:\\Selenium_Scripts_Sep18\\Test Data\\Login.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet s=wb.getSheetAt(0);
		for(int i=1;i<s.getLastRowNum()+1;i++)
		{
			// Click on Sign in
			d.findElement(By.linkText("Sign in")).click();
			Thread.sleep(2000);
			// Enter user name
			d.findElement(By.name("principal")).clear();
			d.findElement(By.name("principal")).sendKeys(s.getRow(i).getCell(0).getStringCellValue());
			String uname=d.findElement(By.name("principal")).getAttribute("value");
			// Enter password
			d.findElement(By.name("password")).clear();
			d.findElement(By.name("password")).sendKeys(s.getRow(i).getCell(1).getStringCellValue());
			String password=d.findElement(By.name("password")).getAttribute("value");
			// Click on Sign In button
			d.findElement(By.cssSelector("button.actionButton")).click();
			Thread.sleep(2000);
			
			// Blank user name & Blank password
			if(uname.equals("") && password.equals(""))
			{
				assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine > ul")).getText().contains("Login name is required\nPassword is required"));
			}
			// Blank user name & Valid/Invalid password
			else if(uname.equals("") && !(password.equals("")))
			{
				//assertEquals("inputField medium inputField-invalid",d.findElement(By.name("principal")).getAttribute("class"));
				assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine > ul")).getText().contains("Login name is required"));
			}
			// Blank password & Valid/Invalid user name
			else if(!(uname.equals("")) && password.equals(""))
			{
				assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine > ul")).getText().contains("Password is required"));
			}
			// Valid user name & Valid password
			else if(isElementPresent(d,By.linkText("Logout")))
			{
				// Click on Logout
				d.findElement(By.linkText("Logout")).click();
			}
			// Invalid username & Invalid password
			else
			{
				assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText().contains("The given name / password are incorrect"));
			}
			Thread.sleep(1000);
		}
		
		Thread.sleep(2000);
	}
	private boolean isElementPresent(WebDriver driver,By by) 
	{
	    driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
		try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
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
