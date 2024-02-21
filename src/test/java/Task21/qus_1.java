package Task21;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class qus_1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.switchTo().frame(0);
		WebElement frameText = driver.findElement(By.xpath("//p[contains(text(),'Your content')]"));
		frameText.clear();
		frameText.sendKeys("Hello People");
		
		System.out.println("The value has been changed into the iframe. ");
		
		driver.close();

	}

}
//The value has been changed into the iframe. 

