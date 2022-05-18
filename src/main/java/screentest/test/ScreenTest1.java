package screentest.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenTest1 {
@Test
   public static void SetUp_method() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitthal\\Desktop\\workspace\\test\\WebDriver chrome\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.myntra.com");	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement men =driver.findElement(By.xpath("//a[@data-group='men']"));
	WebElement phone =  driver.findElement(By.xpath("//a[text()='Phone Cases']"));
	Actions as =new Actions(driver);
	as.moveToElement(men).build().perform();
	as.click(phone).build().perform();
	driver.findElement(By.xpath("//img[@alt='IMMRI Women Lime Green Mobile Accessories']")).click();
	Set<String> wh = driver.getWindowHandles();
	System.out.println(wh);
	Iterator <String>it = wh.iterator();
	String Window1 = it.next();
	String window2 = it.next();
	driver.switchTo().window(window2);
	System.out.println("price of selected item is dispayed true or false;-"+ driver.findElement(By.xpath("//span[@class='pdp-price']")).isDisplayed());
	String price = driver.findElement(By.xpath("//span[@class='pdp-price']")).getText();
	
	System.out.println("price of selected item is ;-"+" "+price);
	
	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'pdp-add-to-bag pdp-button pdp-flex pdp-center')]")).isDisplayed(), "Add to bag is displayed");
	
	driver.quit();
}

}
