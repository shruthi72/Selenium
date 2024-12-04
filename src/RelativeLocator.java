import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;

public class RelativeLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("rahulsheetyacademy.com/angularpractice/");
		WebElement nameEditbox=driver.findElement(By.cssSelector("[name='name']"));
		driver.findElement(with(By.tagName("label")).above(nameEditbox)).getText();

	}

}
