package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionSortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.get("https://jqueryui.com/sortable/");
driver.manage().window().maximize();
Actions sort=new Actions(driver);
driver.switchTo().frame(0);
WebElement item1 = driver.findElement(By.xpath("//ul[@id='sortable']/li[1]"));
WebElement item3 = driver.findElement(By.xpath("//ul[@id='sortable']/li[3]"));
//sort.dragAndDrop(item1, item3).perform();
sort.dragAndDropBy(item1, 0, 100).perform();
System.out.println("Sorted");
//

	}

}
