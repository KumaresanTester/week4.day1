package week4.day1;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		App Login By Giving UserName and Password
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

//		Clicked Widget of From Contact and To Contact by using Window Handles
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Window Handles Code for From Contact New Window
		Set<String> setWindowHandles = driver.getWindowHandles();
		List<String> listWindowHandles = new ArrayList<String>(setWindowHandles);
		driver.switchTo().window(listWindowHandles.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a")).click();
		driver.switchTo().window(listWindowHandles.get(0));
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Window Handles Code for To Contact New Window
		Set<String> setWindowHandles2 = driver.getWindowHandles();
		List<String> listWindowHandles2 = new ArrayList<String>(setWindowHandles2);
		driver.switchTo().window(listWindowHandles2.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		driver.switchTo().window(listWindowHandles2.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

//		Accept Alert and Get Text in Alert Dailog Box
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Msg is " + alert.getText());
		alert.accept();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println("Title of the Page is " + driver.getTitle());

//		Closing the Web Application
		driver.close();

	}

}
