package leafGround;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TextBox {

	public static void main(String[] args) throws InterruptedException {
		
		/*Launch the browser*/
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		/*Load the URL*/
		driver.get("https://leafground.com/input.xhtml");
		
		/*Get the attribute value from the textbox*/
		
		String attribute = driver.findElement(By.name("j_idt88:name")).getAttribute("placeholder");
		System.out.println("The attribute value in the text box is " +attribute);
		
		/*Type your name*/
		driver.findElement(By.name("j_idt88:name")).sendKeys("Testleaf");	
		
	//	System.out.println(driver.findElement(By.name("j_idt88:name")).getAttribute("placeholder"));
		
		/*Append Country to this City*/
		driver.findElement(By.name("j_idt88:j_idt91")).sendKeys(" India");
		
		/*Verify if text box is disabled*/
		boolean enabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
		System.out.println("Is the keyboard enabled? " +enabled);
		
		if(enabled==false) {
			
			System.out.println("The text box is disabled");
		
		}else {
			
			System.out.println("The text box is not disabled");
		}	
	
		/*Clear the typed text*/
		driver.findElement(By.name("j_idt88:j_idt95")).clear();
		
		/*Retrieve the typed text*/
		String retrievedtext = driver.findElement(By.xpath("//input[@name='j_idt88:j_idt97']")).getAttribute("value");
		
		System.out.println("Retrieved text: " +retrievedtext);
		
		//Type email and Tab. 
		
		driver.findElement(By.name("j_idt88:j_idt99")).sendKeys("ranjini@testleaf.com", Keys.TAB);
		
		//Confirm control moved to next element.
		WebElement aboutYourself = driver.findElement(By.xpath("//textarea[contains(@class,'ui-inputfield ui-inputtextarea')]"));
		
		boolean textBox = aboutYourself.isEnabled();
		if(textBox==true) {
			
			System.out.println("Yes, the control is moved to next element");
		//Type about yourself
			aboutYourself.sendKeys("Type About Yourself: Hi, I am a junior software in test");
			
		}else {
			
			System.out.println("Control not moved");
		}
		
		//Text Editor
		driver.findElement(By.className("ql-bold")).click();
		driver.findElement(By.className("ql-italic")).click();
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("This is a test page");
		
		//Just Press Enter and confirm error message*
		driver.findElement(By.xpath("//input[@name='j_idt106:thisform:age']")).sendKeys(Keys.ENTER);
		String errorMsg1 = driver.findElement(By.className("ui-message-error-detail")).getText();
		String errorMsg2 = driver.findElement(By.xpath("//span[text()='Age is mandatory']")).getText();
		if(errorMsg1.equalsIgnoreCase(errorMsg2)) {
			
			System.out.println("Error message is dispayed");
		}else {
			
			System.out.println("Error message is not displayed");
		}
		
		//Click and Confirm Label Position Changes
		Point location1 = driver.findElement(By.xpath("//label[@class='ui-outputlabel ui-widget']")).getLocation();
		System.out.println("Location of the label before change X: " +location1.x);
		System.out.println("Location of the label before change Y: " +location1.y);
		
		driver.findElement(By.xpath("//span[@class='ui-float-label']/input")).click();
		
		Point location2 = driver.findElement(By.xpath("//label[@class='ui-outputlabel ui-widget']")).getLocation();
		System.out.println("Location of the label after change X: "+location2.x);
		System.out.println("Location of the label after change Y: "+location2.y);
		
		if(location1 != location2) {
			System.out.println("Position of the label is changed");
		} else {
			
			System.out.println("Position of the label is not changed");
		}
		
		//Type your name and choose the third option
		driver.findElement(By.xpath("//li[@class='ui-autocomplete-input-token']/input")).sendKeys("Ranjini");
		
		List<WebElement> list = driver.findElements(By.xpath("//li[contains(@class,'ui-autocomplete-item')]"));
		System.out.println("No.of options in the list: " +list.size());
		list.get(3).click();
		
		//Type your DOB (mm/dd/yyyy) and confirm date chosen
		WebElement date1 = driver.findElement(By.name("j_idt106:j_idt116_input"));
		date1.sendKeys("1/11/2000",Keys.ENTER);
	//	driver.findElement(By.xpath("(//span[@class='ui-button-text'])[2]")).click();
	//	WebElement date2 = driver.findElement(By.xpath("((//table[@class='ui-datepicker-calendar']//tr)[4]//td)[3]"));
	//	date2.click();
		
		String monthYearVal = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		System.out.println("Month & Year: " +monthYearVal);
		String date = driver.findElement(By.xpath("//td/a[@class=' ui-state-default ui-state-active']")).getText();
		System.out.println("Date: " +date);
		//Type number and spin to confirm value changed
		WebElement value1 = driver.findElement(By.xpath("//span[contains(@class,'ui-spinner')]/input"));
		value1.sendKeys("4");
		driver.findElement(By.xpath("//span[@class='ui-icon ui-c ui-icon-triangle-1-n']")).click();
		String value2 = driver.findElement(By.xpath("//span[contains(@class,'ui-spinner')]/input")).getAttribute("aria-valuenow");
		System.out.println("The value after spin: " +value2);
		if(value2=="4") {
			
			System.out.println("Value is not changed after spin");
		}else {
			
			System.out.println("Value is changed after spin");
		}
		
		//Type random number (1-100) and confirm slider moves correctly
		Point slider1 = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')]")).getLocation();
		System.out.println("Position of slider before move X :" +slider1.x);
		System.out.println("Position of slider before move Y :" +slider1.y);
		driver.findElement(By.name("j_idt106:slider")).sendKeys("50");
		Point slider2 = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')]")).getLocation();
		System.out.println("Position of slider after move X :" +slider2.x);
		System.out.println("Position of slider after move Y :" +slider2.y);
		
		if(slider1==slider2) {
			System.out.println("Slider is moved");
		}else {
			System.out.println("Slider is not moved");
		}
		
		//Click and Confirm Keyboard appears
		driver.findElement(By.name("j_idt106:j_idt122")).click();
		System.out.println("Is the keyboard displayed? " +driver.findElement(By.xpath("//div[contains(@class,'keypad-popup ui-input-overlay')]")).isDisplayed());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'keypad-special keypad-close')]")).click();
		
		//Custom Toolbar
		//Select Serif
		driver.findElement(By.xpath("(//span[@class='ql-font ql-picker'])[2]")).click();
		driver.findElement(By.xpath("((//div[@class='ui-texteditor'])[2]//span[@class='ql-picker-item'])[1]")).click();
		//Select Large
		driver.findElement(By.xpath("(//span[@class='ql-size ql-picker'])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='ql-size ql-picker ql-expanded']//span[@class='ql-picker-item'])[3]")).click();
		//Select Bold
		driver.findElement(By.xpath("(//button[@class='ql-bold'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[2]")).sendKeys("This is your last test in the page");
		
		
	}

}
