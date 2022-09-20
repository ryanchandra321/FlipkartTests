package FlipkartTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class print4GBRamRedmiPhones {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");

		driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
		driver.findElement(By.xpath("//input[contains(@title,'Search for products, brands and more')]")).sendKeys("redmi");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		List<WebElement> phonesTitle = driver.findElements(By.xpath("//li[contains(text(),'4 GB RAM')]/../../../div[1]"));
		
		for (WebElement phoneTitle : phonesTitle) {
			System.out.println(phoneTitle.getText());
			System.out.println("==========================================================");
		}
		driver.quit();
	}

}
