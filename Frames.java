package week4.day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		Enter URL To Open Web Application
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Switch To 1st Frame to Enter the Topic
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Selenium");

//		Switch To 3rd Frame to Click on Check Box
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();

//		Switch back to Home Page
		driver.switchTo().defaultContent();

//		Switch To 2nd Frame to Select the Animals in Drop Down
		driver.switchTo().frame("frame2");
		WebElement eleDropDown = driver.findElement(By.id("animals"));
		Select selectAnimal = new Select(eleDropDown);
		selectAnimal.selectByVisibleText("Baby Cat");

//		Switch back to Home Page
		driver.switchTo().defaultContent();

//		Closing the Web Application
		driver.close();

	}

}
