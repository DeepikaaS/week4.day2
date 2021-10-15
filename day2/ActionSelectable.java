package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionSelectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		Actions builder=new Actions(driver);
		WebElement item1 = driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"));
		WebElement item7 = driver.findElement(By.xpath("//ol[@id='selectable']/li[7]"));
		//builder.dragAndDrop(item1, item3).perform();
		
		/*
		 * builder.keyDown(Keys.CONTROL.ARROW_DOWN); builder.release(item7);
		 */
	}

}
