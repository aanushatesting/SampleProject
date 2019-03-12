package Suite1;

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

public class Flipkart{

	WebDriver d = new FirefoxDriver();
	String username = ""; // Change to your username and passwrod
	String password = "";

	// This method is to navigate flipkart URL
	@BeforeClass
	public void init() {
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		d.navigate().to("https://www.flipkart.com");
	}

	// To login flipkart
	@Test
	public void login() {
		d.findElement(By.partialLinkText("Login")).click();
d.findElement(By.cssSelector(".fk-input.login-form-input.user-email")).sendKeys(username);
d.findElement(By.cssSelector(".fk-input.login-form-input.user-pwd")).sendKeys(password);
d.findElement(By.cssSelector(".submit-btn.login-btn.btn")).click();
	}
	// Search For product
	@Test
	public void searchAndSelectProduct() {
		d.findElement(By.id("fk-top-search-box")).sendKeys("moto g3");
		d.findElement(By.cssSelector("search-bar-submit.fk-font-13.fk-font-bold")).click();

		// select the first item in the search results
		String css = ".gd-row.browse-grid-row:nth-of-type(1) > div:nth-child(1)>div>div:nth-child(2)>div>a";
		d.findElement(By.cssSelector(css)).click();
	}

	@Test
	public void buyAndRemoveFromCart() {
		d.findElement(By.cssSelector(".btn-express-checkout.btn-big.current")).click();
		d.findElement(By.cssSelector(".remove.fk-inline-block")).click();
		Alert a = d.switchTo().alert();
		a.accept();
	}

	@Test
	public void logout() {
		Actions s = new Actions(d);
		WebElement user = d.findElement(By.partialLinkText(username));
		s.moveToElement(user).build().perform();
		d.findElement(By.linkText("Logout")).click();
	}

	@AfterClass
	public void quit() {
		d.close();
	}
}