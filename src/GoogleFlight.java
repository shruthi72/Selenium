import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleFlight {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		driver.findElement(By.id("nav-tools")).click();
		
		driver.findElement(By.cssSelector(".nav-action-signin-button")).click();		
		//driver.findElement(By.id("nav-action-inner")).click();
		
		driver.findElement(By.id("ap_email")).sendKeys("7397037495");
		driver.findElement(By.id("continue")).click();
		
		}

}
