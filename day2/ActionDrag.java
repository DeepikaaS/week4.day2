package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionDrag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		//Since only one frame is there so we have used 0 (index)
		driver.switchTo().frame(0);
		WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(dragElement, 100,100).perform();
		System.out.println("The element is dragged");
		driver.close();
	}

}
