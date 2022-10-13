package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlertAssign { 

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notification");
		ChromeDriver driver= new ChromeDriver();
		//1)Login to  https://chercher.tech/practice/frames-example-selenium-webdriver
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Switching to frame1
		driver.switchTo().frame("frame1");
		//entering the text in the textbox
		driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys("TestLeaf");
		//Switching to frame3
		driver.switchTo().frame("frame3");
		//clicking on the checkbox
		driver.findElement(By.xpath("//input[@id=\"a\"]")).click();
		//Coming out of the frames
		driver.switchTo().defaultContent();
		//Switching to frame2
		driver.switchTo().frame("frame2");
		//selecting the option from dropdown
		// Using select class and select the option in the drop down
		// Find the element using XPath
		WebElement animals = driver.findElement(By.id("animals"));
		// Using select class and select the option in the drop down
		Select obj = new Select(animals);
		obj.selectByValue("babycat");
		WebElement firstSelectedOption = obj.getFirstSelectedOption();
		//confirming the selected option
		String text = firstSelectedOption.getText();
		System.out.println(text+" is selected");
	}

}