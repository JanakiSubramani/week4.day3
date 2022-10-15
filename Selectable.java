package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the URL
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Switch to frame
		driver.switchTo().frame(0);
		// Find the element
		WebElement item4 = driver.findElement(By.xpath("//ol[@id='selectable']//li[5]"));
		// select the item
		item4.click();
		// Verify if the element is selected or not
		boolean selected = item4.isEnabled();
		if (selected) {
			System.out.println("item5 is selected");
		} else {
			System.out.println("item5 is unselected");
		}
		driver.quit();
	}

}
