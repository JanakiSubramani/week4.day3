package week4.day3;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafFrame {
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// find the element of iframe by using XPath
		WebElement iframe = driver.findElement(By.xpath("//div[@class='card']//iframe[1]"));
		
		// switch to frame
		driver.switchTo().frame(iframe);
		
		// click the button of frame
		WebElement button = driver.findElement(By.xpath("//button[text()='Click Me']"));
		button.click();
		String text = button.getText();
		System.out.println(text);

		// verify the text
		if (text.contains("Hurray! You Clicked Me.")) {
			System.out.println("The text is verified successfully");
		} else {
			System.out.println("The text is  not verified ");

		}

		// count the number of iframes in the DOM
		driver.switchTo().defaultContent();
		
		// create a List for storing the number of iframes
		List<WebElement> numberOfFrames = driver.findElements(By.tagName("iframe"));
		
		// declare a variable and get a size
		int size = numberOfFrames.size();
		
		// print the size
		System.out.println("The size of the Iframe is :" + size);

		// switch to second frame
		driver.switchTo().frame(2);
		
		// switch to particular frame using id
		driver.switchTo().frame("frame2");
		
		// find the element using XPath and store it to the web element
		WebElement secondFrame = driver.findElement(By.xpath("//button[text()='Click Me']"));
		
		// click the button
		secondFrame.click();
		
		// Get the text
		System.out.println(secondFrame.getText());
		
		// come out from frame to DOm element
		driver.switchTo().defaultContent();

	}

}