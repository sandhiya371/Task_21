package Task21;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class qus_2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// current window
		String mainWindow = driver.getWindowHandle();
		System.out.println("The main window is:" + mainWindow);

		WebElement clickHereLink = driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickHereLink.click();

		Set<String> mWind = driver.getWindowHandles();

		for (String x : mWind) {

			System.out.println(x);

			if (!x.equals(mWind)) {
				driver.switchTo().window(mainWindow);
				WebElement output = driver.findElement(By.xpath("//div[@class='example']/*[text()='New Window']"));

				output.getText();
				System.out.println(output.getText());
				if (output.equals("New Window")) {
					System.out.println("Successfully logged into new window" + driver.getTitle());

				}
				driver.close();
			}
		}

		
		driver.switchTo().window(mainWindow);
		System.out.println("Successfully logged into main window" + driver.getTitle());

		driver.quit();
	}

}
