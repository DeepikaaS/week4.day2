package week4.day2;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Assignment 2: ============= 1) Go to https://www.nykaa.com/ 2) Mouseover on
		 * Brands and Search L'Oreal Paris 3) Click L'Oreal Paris 4) Check the title
		 * contains L'Oreal Paris(Hint-GetTitle) 5) Click sort By and select customer
		 * top rated 6) Click Category and click Hair->Click haircare->Shampoo 7)
		 * Click->Concern->Color Protection 8)check whether the Filter is applied with
		 * Shampoo 9) Click on L'Oreal Paris Colour Protect Shampoo 10) GO to the new
		 * window and select size as 175ml 11) Print the MRP of the product 12) Click on
		 * ADD to BAG 13) Go to Shopping Bag 14) Print the Grand Total amount 15) Click
		 * Proceed 16) Click on Continue as Guest 17) Check if this grand total is the
		 * same in step 14 18) Close all windows
		 */

		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		WebElement brandTab = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brandTab).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		// driver.switchTo().frame(0); Thread.sleep(2000);
		// driver.findElement(By.xpath(
		// "(//div[@class='nav-brands-lists__single-item']/a[1]/b)[1]")).click();
		driver.findElement(By.xpath("//div[@id='list_L']/following-sibling::div/a[1]")).click();
		String title = driver.getTitle();
		System.out.println(title);

		// driver.getTitle().contains("Title of Page"));

		if (title.contains("Buy L'Oreal Paris ")) {
			System.out.println("Matching");

		} else {
			System.out.println("Not Matching");
		}
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"sortComponent\"]/div[2]/div/div[1]/span[1]/span[2]")).click();
		driver.findElement(By.xpath("//span[@title='POPULARITY']")).click();
		// driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();
		driver.findElement(By.xpath("//div[@id='sortComponent']//div[4]")).click();
		Thread.sleep(2000);
		WebElement category = driver.findElement(By.xpath("//div[text()='Category']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", category);
		// executor.executeScript("arguments[0].scr
		WebElement hairDrop = driver.findElement(By.xpath("//span[text()='Hair']"));
		hairDrop.click();
		WebElement hairCare = driver.findElement(By.xpath("(//div[@class='category-filter-name'])[2]"));
		// (//div[@class='category-filter-name'])[2]
		hairCare.click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();

		driver.findElement(By.xpath("//div[@class='brd-sep'][6]")).click();
		driver.findElement(By.xpath("//span[text()=10]")).click();
		//driver.findElement(By.xpath("//span[text()='Color Protection']/following::div[1]")).click();
//driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		String text = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']/li[1]")).getText();
		System.out.println(text);

	}
}
