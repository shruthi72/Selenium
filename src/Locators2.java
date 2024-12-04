import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "rahul";
		WebDriver driver = new ChromeDriver();
		String LoginPass = getPassword(driver); //instead of creating an object to call method, change the method as static
		//implicit wait - giving time delay to ask selenium wait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(LoginPass);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		//Used tagname locator as that page has only one p tag
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");

		//Xpath for clicking button using button text. Syntax: //tagname[text()='text name'] or //*[text()='text name']
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
		
	}

	
//below method to get password from the webpage	
public static String getPassword(WebDriver driver) throws InterruptedException
{
	driver.get("https://rahulshettyacademy.com/locatorspractice/");
	driver.findElement(By.linkText("Forgot your password?")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
	String passwordname = driver.findElement(By.cssSelector("form p")).getText();
	//Please use temporary password 'rahulshettyacademy' to Login.
	String passArray[] = passwordname.split("'");
	//passArray[0]=Please use temporary password
	//passArray[1]=rahulshettyacademy' to Login.
	String password1 = passArray[1].split("'")[0];
	//0th index =rahulshettyacademy
	//1st index =to Login.
	return password1;
}

}
