import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//give me the count of links on the page. so in html all link will have tag as <a>
		System.out.println(driver.findElements(By.tagName("a")).size());
		//till line12 driver object has scope of all elements
		//for finding links present only in footer we need to limit driver scope
		WebElement footerdriver = driver.findElement(By.id("gf-BIG")); //limit the scope of driver
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//Count the number of links in first column footer
		WebElement columndriver = footerdriver.findElement(By.xpath(""));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//click on each link in the column and check if pages are opening
		//if we directly write xpath for each link, tmrw the link may be added or removed as it is dynamic. so always use count of link concpt
		//in that webpage first link is not working, so going with i=1 
		for(int i=1; i<columndriver.findElements(By.tagName("a")).size(); i++)
		{
			String clickonlink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink); //it will open that link in same page, if we need to open second link selenium need to go back and it will take time
			//instead use optimized way -> open in separate tab (ctrl + click link)
			Thread.sleep(3000);
		}
			
		//open all the tabs. 
		//hasNext()-> tells next index present or not ; next()-> moves to next index
			Set<String> abc= driver.getWindowHandles();
			Iterator<String> it =abc.iterator();
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}

	}

}
