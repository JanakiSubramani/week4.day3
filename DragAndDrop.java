package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the URL
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Switch to frame
		driver.switchTo().frame(0);
		// Find the source element and store it to the WebElement
		WebElement drag = driver.findElement(By.id("draggable"));
		// Find the destination element and store it to the WebElement
		WebElement drop = driver.findElement(By.id("droppable"));
		// Create a Actions class
		Actions builder = new Actions(driver);
		// Perform the dragandDrop action using method
		builder.dragAndDrop(drag, drop).perform();
		System.out.println("Target is achieved");
		driver.quit();

	}

}