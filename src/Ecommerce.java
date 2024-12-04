import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecommerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //implicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		String itemNeeded[]= {"Cucumber", "Brocolli","Beetroot"};

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		getItems(driver,itemNeeded);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();//here using text as it is static
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

		
	}		
		
public static void getItems(WebDriver driver,String itemNeeded[])
{
		int j=0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++)
		{
			String[] name=products.get(i).getText().split("-");
			//format it to get actual vegetable name by using split and trim
			//name[0]="Cucumber " name[1]=" 1 kg"
			String formatName=name[0].trim();
			
			//convert array into array list for easy search
			//check whether name you extracted is present in arraylist or not
			List<String> itemsNeededList=Arrays.asList(itemNeeded);
			if(itemsNeededList.contains(formatName))
			{
				j++;
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(); --> inconsistent as text locator has dynamic text
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				//break; -> due to multiple items break can't be used here. so used another variable and put condition with size of array times
				if(j==itemNeeded.length)
					break;
				
			}
		}

	}
}


