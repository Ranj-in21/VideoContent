package datePicker;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {

		public static ChromeDriver driver;
		
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.redbus.in");
		
		driver.findElement(By.id("src")).sendKeys("Chennai");
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']//li")).click();
		driver.findElement(By.id("dest")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']//li")).click();
		
		selectDate("21", "Apr", "2023");
		driver.findElement(By.id("search_btn")).click();
		
	}
	public static String[] getMonthYear(String monthYear) {
		
		return monthYear.split(" ");
	}
	
	public static void selectDate(String expectedDate, String expectedMonth, String expectedYear) {
		
		String monthYear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
		
		while(!(getMonthYear(monthYear)[0].equals(expectedMonth) && 
				getMonthYear(monthYear)[1].equals(expectedYear))) {
			
			driver.findElement(By.xpath("//td[@class='next']")).click();
			monthYear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			System.out.println(monthYear);	
			
		}
		
		driver.findElement(By.xpath("//td[text()='"+expectedDate+"']")).click();

		
		
		

	}
}
