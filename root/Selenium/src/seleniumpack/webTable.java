package seleniumpack;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class webTable 
{ 
WebDriver d; 
@BeforeMethod
public void abc()
{
//System.setProperty("webdriver.chrome.driver", "F:\\root\\lib\\ chromedriver.exe");
//d = new ChromeDriver();
	System.setProperty("webdriver.gecko.driver", "F:\\root\\lib\\geckodriver.exe");
	d=new FirefoxDriver();
d.manage().window().maximize();
d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@Test
public void test()
{
d.get("http://demo.guru99.com/selenium/table/");
//To locate table.

WebElement mytable = d.findElement(By.xpath("/html/body/table/tbody"));
//To locate rows of table. 

List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
//To calculate no of rows In table.

int rows_count = rows_table.size();

//Loop will execute till the last row of table.

for (int row=0; row<rows_count; row++)
{ 
//To locate columns(cells) of that specific row.
	
List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

//To calculate no of columns (cells). In that specific row.

int columns_count = Columns_row.size();
System.out.println("Number of cells In Row "+row+" are "+columns_count);

//Loop will execute till the last cell of that specific row.

for (int column=0; column<columns_count; column++)
{ 
// To retrieve text from that specific cell.
	
String celtext = Columns_row.get(column).getText();
System.out.println("Cell Value of row number "+row+" and column number "+column+" Is "+celtext);
}
System.out.println("-------------------------------------------------- ");
}
}

@AfterMethod
public void xyz()
{
	d.close();

}
}