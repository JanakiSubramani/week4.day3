package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the URL
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Find the frame using XPath
		WebElement iframe = driver.findElement(By.xpath("//div[@id='content']//iframe"));
		// Switch to frame using web element
		driver.switchTo().frame(iframe);
		// Find the element by using resize
		WebElement resize = driver.findElement(By.xpath("//div[@id='resizable']//div[3]"));
		// create a Action class
		Actions builder = new Actions(driver);
		// resize the element using dragAndDropBy method
		builder.moveToElement(resize).dragAndDropBy(resize, 40, 50).perform();
		driver.close();

	}

}