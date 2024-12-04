import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntro {

	public static void main(String[] args) {
		// Invoking Browser
		// Chrome - ChromeDriver ->Methods close get
		// Firefox - FirefoxDriver ->Methods close get
		//ChromeDriver can access webdriver methods + class methods
		
		//Chromedriver.exe -> Chrome browser
		//Step to invok chrome drive -> instead of manual call here use below sel manager
		//Selenium Manager
		//System.setProperty("webdriver.chrome.driver", "exe file path");
		WebDriver driver = new ChromeDriver();
		
		//Firefox Launch
		//geckodriver -> Firefox browser
		WebDriver driver1 = new FirefoxDriver();
		
		//Microsoft Edge Launch
		//msedgedriver -> Edge browser
		WebDriver driver2 = new EdgeDriver();
		
		driver.get("https://in.search.yahoo.com/search?fr=mcafee&type=E211IN826G0&p=selenium&guccounter=1");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		//driver.quit();
	}

}
