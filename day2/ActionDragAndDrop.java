package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionDragAndDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.get("https://jqueryui.com/droppable/");
driver.manage().window().maximize();
driver.switchTo().frame(0);
WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));
String textBefDrop = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
System.out.println(textBefDrop);
WebElement dropElement = driver.findElement(By.xpath("//div[@id='droppable']"));
Actions builder=new Actions(driver);
builder.dragAndDrop(dragElement, dropElement).perform();
String textAftDrop = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
System.out.println(textAftDrop);
System.out.println("drag and drop is Successfully  done ");
	}

}
