package Task21;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class qus_3 {
 
	public static WebDriver driver;
 
	public static void main(String[] args) {
 
		WebDriver driver =new ChromeDriver();
		 
		driver.get("https://the-internet.herokuapp.com/nested_frames");
 
		driver.manage().window().maximize();
 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 
		System.out.println(driver.getCurrentUrl());
 
		driver.switchTo().frame("frame-top");
 
		
		// verify the frame count
				List<WebElement> ele = driver.findElements(By.tagName("frame"));
 
		System.out.println("Verified number of Frames is: " + ele.size());
 
		driver.switchTo().frame("frame-left");
 
		WebElement leftFrame = driver.findElement(By.xpath("/html/body[contains(text(),'LEFT')]"));
 
		String leftFrameText = leftFrame.getText();
 
		System.out.println("The Text Value of Left Frame : " + leftFrameText);
 
		driver.switchTo().parentFrame();
 
		driver.switchTo().frame("frame-middle");
 
		WebElement middleFrame = driver.findElement(By.xpath("//*[@id='content']"));
 
		String middleFrameText = middleFrame.getText();
 
		System.out.println("The Text Value of Middle Frame : " + middleFrameText);
 
		driver.switchTo().parentFrame();
 
		driver.switchTo().frame("frame-right");
 
		WebElement rightFrame = driver.findElement(By.xpath("/html/body[contains(text(),'RIGHT')]"));
 
		String rightFrameText = rightFrame.getText();
 
		System.out.println("The Text Value of Right Frame : " + rightFrameText);
 
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
 
		driver.switchTo().frame("frame-bottom");
		WebElement bottomFrame = driver.findElement(By.xpath("/html/body[contains(text(),'BOTTOM')]"));
 
		String bottomFrameText = bottomFrame.getText();
 
		System.out.println("The Text Value of Bottom Frame : " + bottomFrameText);
 
		driver.switchTo().parentFrame();
		
		
 
		System.out.println("Title of Frame is: "+ driver.getTitle());
 
		driver.quit();
	}

}
