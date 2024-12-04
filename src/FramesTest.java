import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		//driver.findElement(By.id("draggable")).click(); //this present inside frames so can't mention like this, so using frames concept
		//Frames we can tell driver to switch by passing index value or webelement. if you are using index first find count of frames - line 15
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0); // use index or webelement-line17
		//driver.switchTo().frame(driver.findElement(By.cssSelector("")));
		Actions a =new Actions(driver);
		// for drag and drop action need mention source and target 
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		

	}

}
