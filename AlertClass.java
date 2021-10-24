package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertClass {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Alert.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		alert.accept();
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		System.out.println(alert.getText());
		alert.dismiss();
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		System.out.println(alert.getText());
		alert.sendKeys("Green");
		alert.accept();
		
		
	}

}
