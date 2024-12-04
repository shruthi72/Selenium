import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrollingjavascript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Window scrolling
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		//table scrolling
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//sum amount in column 4
		List<WebElement>values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum =0;
		for(int i=0;i<values.size();i++)
		{
			sum = sum+Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
		//comparing result of sum with amount shown on webpage
		int total=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());//it is in string so need to change as int in order to compare values
		Assert.assertEquals(sum, total);
		

	}

}
