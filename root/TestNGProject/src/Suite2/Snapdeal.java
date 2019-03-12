package Suite2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Snapdeal {

	WebDriver d = new FirefoxDriver();
	String username = ""; // Change to your username and passwrod
	String password = "";
	String pinCode = "";

	// This method is to navigate flipkart URL
	@BeforeClass
	public void init() {
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		d.navigate().to("https://www.snapdeal.com");
	}

	// To log in flipkart
	@Test
	public void login() {
		d.findElement(By.xpath("//button[text()='Login']")).click();
		d.switchTo().frame("loginIframe");
		d.findElement(By.cssSelector("div[onClick='getLoginForm()']")).click();
		d.findElement(By.id("j_username")).sendKeys(username);
		d.findElement(By.id("j_password_login")).sendKeys(password);
		d.findElement(By.id("signin_submit")).click();
		d.switchTo().defaultContent();
	}

	// Search For product
	@Test
	public void searchAndSelectProduct() {
		d.findElement(By.cssSelector(".col-xs-20.searchformInput.keyword")).sendKeys("iphone 6s");
		d.findElement(By.cssSelector(".sd-icon.sd-icon-search")).click();

		// select the first item in the search results
		String css = ".product_grid_row:nth-of-type(1)>div:nth-child(1)";
		d.findElement(By.cssSelector(css)).click();
	}

	@Test
	public void buyAndRemoveFromCart() {

		d.findElement(By.xpath("//li[contains(text(),'Silver')]")).click();
		d.findElement(By.id("pincode-check")).sendKeys(pinCode);
		d.findElement(By.id("buy-button-id")).click();
		
		d.findElement(By.cssSelector("i[title='Delete Item']")).click();
		Alert a = d.switchTo().alert();	
		a.accept();
	}

	@Test
	public void logout() {
		
		d.findElement(By.linkText("START SHOPPING NOW")).click();
		Actions s = new Actions(d);
		WebElement user = d.findElement(By.cssSelector(".sd-icon.sd-icon-user"));
		s.moveToElement(user).build().perform();
		d.findElement(By.linkText("Logout")).click();
	}

	@AfterClass
	public void quit() {
		d.close();
	}
}