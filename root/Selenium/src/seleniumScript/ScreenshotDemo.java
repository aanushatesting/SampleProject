package seleniumScript;



import static org.testng.Assert.assertEquals;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenshotDemo {
	WebDriver d;
	@Test
	public void testScreenshot() throws Exception
	{
		//Load web page
		d.get("https://www.google.co.in");
		assertEquals("Google",d.getTitle());
		d.findElement(By.linkText("Gmail")).click();
		Thread.sleep(2000);
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date();
		
		File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("C:\\Users\\welcome\\Desktop\\screenShot\\"+df.format(dt)+".png"));
		//FileUtils.copyFile(screenshotFile, new File("E:\\Selenium_Scripts_Sep18\\Results\\Page1.png"));
		Thread.sleep(3000);
	}
	@BeforeMethod
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\root\\lib\\chromedriver.exe");
		d=new ChromeDriver();
		System.setProperty("webdriver.gecko.driver","F:root\\lib\\geckodriver.exe");
		//d=new FirefoxDriver();
		//Maximize
		//d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		//d.manage().timeouts().pageLoadTimeout(2,TimeUnit.MINUTES);
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
