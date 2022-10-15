package week4.day3;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class LearnFrameAssign {
		
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();

			// Launch the URL
			driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			// Switch to frame
			driver.switchTo().frame("frame1");
			// Find the element by using XPath and send the text in input box
			driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys("Janaki");

			// Switch to frame
			driver.switchTo().frame("frame3");
			// click the check box
			driver.findElement(By.xpath("//input[@id='a']")).click();

			driver.switchTo().defaultContent();
			// Find the element using XPath
			WebElement frame = driver.findElement(By.xpath("//iframe[@id='frame2']"));
			driver.switchTo().frame(frame);
			// Find the element using XPath
			WebElement animals = driver.findElement(By.id("animals"));
			// Using select class and select the option in the drop down
			Select obj = new Select(animals);
			obj.selectByValue("babycat");

		}

	}