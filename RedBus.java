package datePicker;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.redbus.in");
		
		driver.findElement(By.id("src")).sendKeys("Chennai");
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']//li")).click();
		driver.findElement(By.id("dest")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']//li")).click();
		
		String monthYear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
		System.out.println(monthYear);	//Jan 2023
		
	//	String[] split = monthYear.split(" ");
		String month = monthYear.split(" ")[0].trim();
		System.out.println(month);
		String year = monthYear.split(" ")[1].trim();
		System.out.println(year);
		
		while(!(month.equals("Jun") && year.equals("2023"))) {
			
			driver.findElement(By.xpath("//td[@class='next']")).click();
			monthYear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			System.out.println(monthYear);	
			month = monthYear.split(" ")[0].trim();
			year = monthYear.split(" ")[1].trim();
			
		}
		
		driver.findElement(By.xpath("//td[text()='21']")).click();

	}

}
