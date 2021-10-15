package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {
	/*
	 * 1. Launch https://www.snapdeal.com/ 2. Go to Mens Fashion 3. Go to Sports
	 * Shoes 4. Get the count of the sports shoes 5. Click Training shoes 6. Sort by
	 * Low to High 7. Check if the items displayed are sorted correctly 8.Select the
	 * price range (900-1200) 9.Filter with color Navy 10 verify the all applied
	 * filters 11. Mouse Hover on first resulting Training shoes 12. click QuickView
	 * button 13. Print the cost and the discount percentage 14. Take the snapshot
	 * of the shoes. 15. Close the current window 16. Close the main window
	 */

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//li[@navindex='6']")).click();
		driver.findElement(By.xpath("(//div[@id='category6Data'])//p[2]//span[text()='Sports Shoes']")).click();
		// WebElement noOfShoes =
		// driver.findElement(By.xpath("//h1[@class='category-name']/span"));
		// String count = noOfShoes.getText();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("(//li[@data-index=1])[2]")).click();
		// System.out.println(count);

		// driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
		Thread.sleep(1000);
		String count = driver.findElement(By.xpath("//a[@class='child-cat-node dp-widget-link hashAdded']/div[2]")).getText();
		System.out.println(count);
		
		  List<WebElement> shoes1 =
		  driver.findElements(By.xpath("//div[@class='lfloat marR10']/span[2]"));
		  List<Integer> orgshoeRate = new ArrayList<Integer>();
		  System.out.println(shoes1.size());
		 
		Thread.sleep(2000);
		
		  for (int i = 0; i < shoes1.size(); i++) {
		  orgshoeRate.add(Integer.parseInt(shoes1.get(i).getAttribute("data-price")));
		  // Syst  m.out.println(shoeRate1); } System.out.println("finish");
		 

		ArrayList<Integer> sortedShoerate = new ArrayList<Integer>(orgshoeRate);
		Collections.sort(sortedShoerate);

		if (orgshoeRate.equals(sortedShoerate)) {
			System.out.println("sorted");
		} else {
			System.out.println("Not Sorted");
		}
		Actions builder = new Actions(driver);
		WebElement leftSlider = driver.findElement(By.xpath(
				"//a[@class='price-slider-scroll left-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']"));

		builder.clickAndHold(leftSlider).moveByOffset(75, 0).release(leftSlider).perform();
		Thread.sleep(2000);
		WebElement rightSlider = driver.findElement(By.xpath(
				"//div[@class='filter-price-slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']/a[2]"));
//WebElement rightSlider = driver.findElement(By.xpath("//a[@class='price-slider-scroll right-handle ui-slider-handle ui-state-default ui-corner-all hashAdded ui-state-hover']"));
		builder.clickAndHold(rightSlider).moveByOffset(-100, 0).release(rightSlider).perform();
		// builder.dragAndDropBy(sliderCircle1, 60, 0).perform();
		// driver.close();builder.clickAndHold(leftSlider).moveByOffset(75,
		// 0).release(leftSlider).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='View More '])[2]")).click();
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		Thread.sleep(2000);
		System.out.println("***Filtered elements are****");
		List<WebElement> filters = driver.findElements(By.xpath("//div[@class='filters-top-selected']/div//a"));
		for (WebElement webElement : filters) {
			System.out.println(webElement.getText());
		}

		WebElement firstelement = driver.findElement(By.xpath("//picture[@class='picture-elem']"));
		builder.moveToElement(firstelement).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[ @class='clearfix row-disc'])[1]/div")).click();
		Thread.sleep(2000);
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		Thread.sleep(2000);
		String percentage = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("The price is:" + price + "and the percentage is:" + percentage + ".");

		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snapdeal/snapdeal.png");
		FileUtils.copyFile(screenshotAs, dst);
		driver.findElement(By.xpath("//div[contains(@class,'marR10')]/i")).click();

		/*
		 * Set<String> windowHandles = driver.getWindowHandles();
		 * 
		 * List<String> winList=new ArrayList<String>(windowHandles);
		 * 
		 * driver.switchTo().window(winList.get(0));
		 */
		driver.close();

	}

	}}
