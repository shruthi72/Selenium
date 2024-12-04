import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multiplewindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);		
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentWindowID=it.next();
		String childWindowID=it.next();
		driver.switchTo().window(childWindowID);
		driver.get("rahulshettyacademy.com");
		String courseName=driver.findElements(By.cssSelector("")).get(1).getText();
		driver.switchTo().window(parentWindowID);
		WebElement name=driver.findElement(By.cssSelector(""));
		name.sendKeys(courseName);
		//Taking WebElement Partial Screenshot
		File file=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("screenshot.png"));
		//driver.quit();		
		
		//get height and width of Name field edit box
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		

		

	}

}
