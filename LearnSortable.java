package week4.day3;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class LearnSortable {
		
		public static void main(String[] args) {

			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();

			// Launch the URL
			driver.get("https://jqueryui.com/sortable/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			// Switch to frame
			driver.switchTo().frame(0);
			
			// Find the elements to swap
			WebElement item1 = driver.findElement(By.xpath("//ul[@id='sortable']//li[1]"));
			WebElement item2 = driver.findElement(By.xpath("//ul[@id='sortable']//li[2]"));

			// Create a Actions class to perform actions
			Actions builder = new Actions(driver);

			// move the items using clickAndHold method
			builder.clickAndHold(item2).moveToElement(item1).perform();

			WebElement item3 = driver.findElement(By.xpath("//ul[@id='sortable']//li[3]"));
			WebElement item4 = driver.findElement(By.xpath("//ul[@id='sortable']//li[4]"));
			builder.clickAndHold(item4).moveToElement(item3).perform();
			System.out.println("Targeted item sorted");
			driver.quit();
	}
	}