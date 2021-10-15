package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Amazon:
		// 1.Load the uRL https://www.amazon.in/
		// 2.search as oneplus 9 pro
		// 3.Get the price of the first product
		// 4. Print the number of customer ratings for the first displayed product
		// 5. Mouse Hover on the stars
		// 6. Get the percentage of ratings for the 5 star.
		// 7. Click the first text link of the first image
		// 8. Take a screen shot of the product displayed
		// 9. Click 'Add to Cart' button
		// 10. Get the cart subtotal and verify if it is correct.
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();

		// String price = driver.findElement(By.xpath
		// ("(//a[@class='a-size-base a-link-normal
		// a-text-normal'])[1]/span[1]/span[@class='a-offscreen']")).getText();
		// System.out.println("The Price of First product is "+price+".");

		/*
		 * WebElement priceElement
		 * =driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]")); String
		 * price = priceElement.getText(); System.out.println(price);
		 */

		String productPrice = driver.findElement(By.className("a-price-whole")).getText();
		System.out.println("price of the first product is: " + productPrice);
		String rating = driver.findElement(By.xpath("//div[contains(@class,'a-size-small')]/span[2]")).getText();
		System.out.println("The rating value are:" + rating + ".");
		/*
		 * String percentage =
		 * driver.findElement(By.xpath("//td[@class='a-text-right a-nowrap']//span[2]/a"
		 * )).getText();
		 * 
		 * System.out.println(percentage);
		 */
		/*
		 * WebElement star = driver.findElement(By.
		 * className("a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom"));
		 * star.click();
		 */
		// Actions builder=new Actions(driver);
		// builder.moveToElement(star).perform();

		Actions builder = new Actions(driver);
		WebElement star = driver.findElement(By.xpath("//div[contains(@class,'a-size-small')]//span"));
		// builder.moveToElement(star).perform();
		star.click();
		Thread.sleep(3000);
		String fiveStarPrcnt = driver
				.findElement(By.xpath("//tr[@aria-label='65% of reviews have 5 stars']/td[3]/span[2]/a")).getText();
		// String
		// fiveStarPrcnt=driver.findElement(By.xpath("(//a[contains(@title,'reviews have
		// 5 stars')])[3]")).getText();
		System.out.println("Five start percentage is: " + fiveStarPrcnt);

		// get teh star

		// String
		// fiveStarPrcnt=driver.findElement(By.xpath("(//a[contains(@title,'reviews have
		// 5 stars')])[3]")).getText();
		/*
		 * String attribute =
		 * driver.findElement(By.xpath("(//div[@class='a-meter'])[1]")).getAttribute(
		 * "aria-valuenow"); System.out.println("Five start percentage is: "+attribute);
		 */
		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-popover'])[1]")).click();
		driver.findElement(By.xpath("(//a[@class='a-link-normal a-text-normal'])[1]")).click();
		Thread.sleep(3000);
		/*
		 * WebElement ratingElement =
		 * driver.findElement(By.id("acrCustomerReviewText")); String noOfRating =
		 * ratingElement.getText();
		 */
		// String noOfRating =
		// driver.findElement(By.className("a-size-base")).getText();
		/*
		 * String noOfRating =
		 * driver.findElement(By.xpath("(//a[@id='acrCustomerReviewLink'])[1]/span")).
		 * getText(); System.out.println(noOfRating);
		 */
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		for (String h : windowHandles) {
			if (!h.equals(mainWindow)) {
				driver.switchTo().window(h);
				System.out.println("New Window Title is" + driver.getTitle());
				System.out.println("New Window URL is" + driver.getCurrentUrl());
			}
		}
		// Screenshot

		File src = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./amazon/phone.png");
		FileUtils.copyFile(src, dst);
		// Add to cart

		driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']")).click();
		Thread.sleep(3000);
		String cartSubTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("The CartSubTotal Price is :"+cartSubTotal);
		//driver.close();
	}

}
