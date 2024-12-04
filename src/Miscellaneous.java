import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscellaneous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Code Format, align in eclipse - ctrl + shift + F5
		//Naming convention in defining class, methods, variables - camelCase
		
		//Debugging
		
		WebDriver driver = new ChromeDriver();
		//line 16, 18 gave Toggle Breakdown by right click on line number
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		getDebug(driver);

	}
	public static void getDebug(WebDriver driver)
	{
		int a=5;
		System.out.println(a);
		driver.close();
	}

}
