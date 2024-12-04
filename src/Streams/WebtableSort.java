package Streams;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebtableSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("rahulshettyacademy.com/greenkart/#/offers");
		
		//Click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//Capture all webelements into list
		List<WebElement> elementList=driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all webelements into new(original) list
		List<String> originalList=elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the original list of step 3 -. sorted list
		List<String> sortedList=originalList.stream().sorted().collect(Collectors.toList());
		
		//compare original list vs sorted list -- for comparing two list use below equals
		Assert.assertTrue(originalList.equals(sortedList));
		
		List<String> price;
		//scan the name column with getText -> RIce -> print the price of the rice
		//Since Rice is in Page 4, used do while loop to do Pagination
		do
		{
		List<WebElement> rows=driver.findElements(By.xpath("//tr/td[1]"));
		price=elementList.stream().filter(s->s.getText().contains("Rice")).map(s->getvaluePrice(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));	
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("")).click();
		}
		}while(price.size()<1);

	}

	private static Object getvaluePrice(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("")).getText();
		return priceValue;
	}

}
