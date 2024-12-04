import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com"); // here get has inbulid synchronization so that selenium wait for the page to load completely
		driver.navigate().to("https://amazon.com"); // navigate doesn't has inbuild wait
		driver.navigate().back();
		driver.navigate().forward();
	

	}

}
