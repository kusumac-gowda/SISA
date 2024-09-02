package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPage {
	
		public WebDriver driver;

		@BeforeClass
         public void valid() {
		
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		}
		
		@Test(priority=1)
		 public void validCredentials() {
			driver.get("https://radaruat.sisainfosec.com/");
			driver.findElement(By.xpath("//input[@id='usernameOrEmailAddress']")).sendKeys("valid emailid");
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("valid password", Keys.ENTER);
			System.out.println("Login Succesful");
			
		
		}
		
		@Test(priority=2)
		public void invalidCredentials()
		{
			driver.get("https://radaruat.sisainfosec.com/");
			driver.findElement(By.xpath("//input[@id='usernameOrEmailAddress']")).sendKeys("invalid emailid");
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("invalid password", Keys.ENTER);
			WebElement ele=driver.findElement(By.xpath("//div[text()='Login failed!']"));
			System.out.println(ele.getText());
			System.out.println("invalid emailid and password");
			
		}
		
		@Test(priority=3)
		public void invalidEmailid()
		{
			driver.get("https://radaruat.sisainfosec.com/");
			driver.findElement(By.xpath("//input[@id='usernameOrEmailAddress']")).sendKeys("invalid emailid");
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("valid password", Keys.ENTER);
			WebElement ele=driver.findElement(By.xpath("//div[text()='Login failed!']"));
			System.out.println(ele.getText());
			System.out.println("invalid emailid");
			
		}
		
		@Test(priority=4)
		public void invalidPassword()
		{
			driver.get("https://radaruat.sisainfosec.com/");
			driver.findElement(By.xpath("//input[@id='usernameOrEmailAddress']")).sendKeys("valid emailid");
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("invalid password", Keys.ENTER);
		    WebElement ele=driver.findElement(By.xpath("//div[text()='Login failed!']"));
			System.out.println(ele.getText());
			System.out.println("invalid password");
			
		}
		
		@Test(priority=5)
		public void emptyCredentials()
		{
			driver.get("https://radaruat.sisainfosec.com/");
			WebElement element=driver.findElement(By.xpath("//button[text()='Log in']"));
			element.click();
			WebElement emptyid=driver.findElement(By.xpath("//p[@id='usernameOrEmailAddress-error']"));
			WebElement emptypass=driver.findElement(By.xpath("//p[@id='pass-error']"));
			System.out.println(emptyid.getText()+ " , "+emptypass.getText());
			System.out.println("Please enter emailid and password");
	
		}
		
		
		@Test(priority=6)
		public void blankEmailid()
		{
			driver.get("https://radaruat.sisainfosec.com/");
			driver.findElement(By.xpath("//input[@id='usernameOrEmailAddress']")).sendKeys(" ");
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("valid password", Keys.ENTER);
			WebElement ele=driver.findElement(By.xpath("//div[text()='Your request is not valid!']"));
			System.out.println(ele.getText());
			WebElement okButton=driver.findElement(By.xpath("//button[text()='OK']"));
			okButton.click();
			System.out.println("emailid is required");
			
		}
		
		@Test(priority=7)
		public void blankPassword()
		{
			driver.get("https://radaruat.sisainfosec.com/");
			driver.findElement(By.xpath("//input[@id='usernameOrEmailAddress']")).sendKeys("valid emailid");
			WebElement element=driver.findElement(By.xpath("//button[text()='Log in']"));
			element.click();
			WebElement ele=driver.findElement(By.xpath("//p[@id='pass-error']"));
			System.out.println(ele.getText());
			System.out.println("password is required");
			
		}
		

}
