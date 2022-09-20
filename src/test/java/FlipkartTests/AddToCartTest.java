package FlipkartTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCartTest {
	public static void main(String[] args) {	

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");

		driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
		driver.findElement(By.xpath("//input[contains(@title,'Search for products, brands and more')]")).sendKeys("winter heater");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement firstProdTitleLink = driver.findElement(By.xpath("//div[@class='_4ddWXP']/a[2]"));
		
		String firstProdTitle = firstProdTitleLink.getAttribute("title");
		
		firstProdTitleLink.click();
		
		 Set<String> tabs = driver.getWindowHandles();
		 
		 for( String tab : tabs ) {
			 System.out.println(tab);
			 driver.switchTo().window(tab);
			 System.out.println(driver.getTitle());
			 if(driver.getTitle().contains(firstProdTitle))
			 {
				 System.out.println("yes");
				 driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();				 
				 break;
			 }
		 }
		 
		 String cartProdTitle = driver.findElement(By.xpath("//a[@class='_2Kn22P gBNbID']")).getText();
		 System.out.println(cartProdTitle);
		 SoftAssert softAssert = new SoftAssert();
		 softAssert.assertEquals(firstProdTitle, cartProdTitle);
		 softAssert.assertAll();
		driver.quit();
		
	}

}
