package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotClass {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		Enter URL To Open Web Application
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Switch To 1st Frame to Get ScreenShot of Click Me		
		driver.switchTo().frame(0);
		WebElement eleClikMe = driver.findElement(By.id("Click"));
		File eleScreenshot = eleClikMe.getScreenshotAs(OutputType.FILE);
		File screenshotFile = new File("./screenshot/elescreenshot.png");
		FileUtils.copyFile(eleScreenshot, screenshotFile);

//		Switch back to Home Page
		driver.switchTo().defaultContent();

//		Switch To Nested Frame to Get ScreenShot
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		WebElement eleNestedFrame = driver.findElement(By.xpath("//button[@id='Click1']/parent::body"));
		File screenshotForNestedFrame = eleNestedFrame.getScreenshotAs(OutputType.FILE);
		File saveScreenShot = new File("./screenshot/screenshot2.png");
		FileUtils.copyFile(screenshotForNestedFrame, saveScreenShot);

//		Switch back to Home Page
		driver.switchTo().defaultContent();

//		Get Number of Counts of Frame Tag
		int countOfFrameTag = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of Frame Tags available is " + countOfFrameTag);

//		Closing the Web Application
		driver.close();
	}
}
