package week4.day3;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlertAssign {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//clicking simple Alert box
		driver.findElement(By.xpath("//span[text()='Show']")).click();
		//switch to alert
		Alert alert = driver.switchTo().alert();
		//accepting the alert
		alert.accept();
		//verifying the result after accepting the alert
		System.out.println(driver.findElement(By.xpath("//span[@id='simple_result']")).getText());
		
		//confirm alert
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']/span[text()='Show']")).click();
		//switch to confirm alert
		Alert alert1 = driver.switchTo().alert();
		alert1.dismiss();
		System.out.println(driver.findElement(By.xpath("//span[@id='result']")).getText());
		
		//Sweet Alert
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt95']/span[2]")).click();
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt98']/span[2]")).click();
		
    	//sweet modal dialog
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']//span[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Modal Dialog (Sweet Alert)']/following::span")).click();
		
		//Prompt Dialog Alert
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt104']")).click();
		Alert alert2 = driver.switchTo().alert();
		alert2.sendKeys("TestLeaf");
		alert2.accept();
		System.out.println(driver.findElement(By.xpath("//span[@id='confirm_result']")).getText());

		//Sweet Alert Confirmation
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		
		//Minimize & Maximize dialog
		driver.findElement(By.xpath("(//span[text()='Show'])[6]")).click();
		driver.findElement(
				By.xpath("//a[contains(@class,'ui-dialog-titlebar-icon ui-dialog-titlebar-minimize')]//span")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.quit();
	}

}