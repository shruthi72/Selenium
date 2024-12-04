import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		//implicit wait - giving time delay to ask selenium wait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("handson");
		driver.findElement(By.name("inputPassword")).sendKeys("Pass");
		driver.findElement(By.className("signInBtn")).click();

		//<input type="text" placeholder="Username" id="inputUsername"value="">
		//input -> tag name ; typ, place, id, value -> attribute ; text, username, inputusername -> attribute associated value
		 
		// CSS Selector conversion:
		//Syntax for Class name to CSS : tagname.classname (eg for SignInBtn: Button.SignInBtn)
		//Syntax for id name to CSS : tagname#id (eg; input#inputUsername)
		//Syntax if unique attribute not present: tagname[attribute='value']:nth-child(3)
		
		//Syntax if no class, id, name present: tagname[attribute='value']
		//<input type="text" placeholder="Username" value="">
		//eg: input[placeholder='Username'] --> customized syntax
		
		//Validate XPath and CSS Selectors written
		//Download chrome extension - SelectorsHub/ChroPath and put Syntax for checking how many class are present in that code
		
		// or go to console and type Syntax: $('p.error') -> CSS Selector plugin vaidation in console
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		// XPath conversion:
		//Syntax: //tagname[@attribute='value']
		//<input type="text" placeholder="Username" value="">
		//eg: //input[@placeholder='Username']
		//Syntax if unique attribute not present: //tagname[@attribute='value'][index value]
		
		// or go to console and type Syntax: $x('//input[@placeholder="Name"]') -> xpath plugin validation in console
		Thread.sleep(1000); //To avoid interception error -> when application is changing state from one view to other, need to wait for few seconds to get stable
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("ABC");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("abcd@gmail.com"); //avoid using index
		
		//xpath parent child
		//search in selector hub with form tag -> //parent tagname/child tagname -> e.g: //form/input[3]
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("7397037495");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		//css parent child
		//search in selector hub with form tag -> parent tagname child tagname -> e.g: form p
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());	
		
		//xpath parent child with childindex
		//search in selector hub with form tag -> //div[@class='forgot-pwd-btn-conainer']/button[1]
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		
		/*CSS with regular expression to find partial text
		 * Synatx: tagname[attribute*='partial word']
		 */
		
		//correct credentials for username, password using css 
		// CSS Syntax for id tag: #idvalue
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		// CSS Syntax for password with regular expression: tagname[attribute*='value']
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		
		//Xpath for Sign In button Syntax to find in selector: //button[@class='submit signInBtn']
		// Syntax for regular expression: //button[contains(@class,'submit')]
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		
	}

}
