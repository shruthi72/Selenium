import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Misc2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//driver.manage().deleteCookieNamed("sessionkey"); - delete specific name cookie
		//Login Page id
		//Line 12,13 Usage: when you want delete that current session and need to get home page
		driver.get("https://www.google.com/");
		
		//Taking Screenshot 
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //File Object
		//below fileUtils convert file object into physical file
		FileUtils.copyFile(src,new File("C:\\Users\\User\\screenshot.png"));

	}

}
