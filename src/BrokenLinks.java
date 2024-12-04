import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//Broken URL
		//Step 1: to get all url's tied up to the links using selenium
		//Java methods will call URL's and get you the status code
		//if status code>400 then that url is not working-link tied up to the url is broken
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();
		for(WebElement link :links)
		{ 
			
			String url= link.getAttribute("href");
			
			//need to call openConnection() method which is in present in URL(url) class by creating an object and its return type is HttpURLConnection
			HttpURLConnection conn=(HttpURLConnection)new URI(url).toURL().openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode<400, "The link with Text"+link.getText()+"is broken with code"+respCode); //Soft Assertions
			
			/*if(respCode>400)
			{
				System.out.println("The link with Text"+link.getText()+"is broken with code"+respCode);
				Assert.assertTrue(true);
			}*/ //Hard Assertions

		}
			
		a.assertAll(); //used for reporting the failure logs

	}

}
