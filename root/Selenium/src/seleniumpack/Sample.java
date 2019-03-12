package seleniumpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Sample {
	WebDriver driver;
@BeforeMethod
public void setup()
{
	System.setProperty("webdriver.gecko.driver", "F:\\root\\lib\\geckodriver.exe");
	//driver=new FirefoxDriver();
	System.setProperty("webdriver.chrome.driver", "F:\\root\\lib\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
@Test
public void test1()
{
	driver.get("https://www.google.com/");
	Assert.assertEquals("Google",driver.getTitle());
  driver.findElement(By.id("//*[@id='identifierId']")).sendKeys("anushabodanapati@gmail.com");
  driver.findElement(By.id("//*[@id='identifierNext']/content")).click();
  driver.findElement(By.id("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("7382656654");
  driver.findElement(By.id("//*[@id='identifierNext']/content")).click(); 
}
@AfterMethod
public void setDown()
{
	driver.close();
}
}
