import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Translate {
	WebDriver driver;

	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("https://www.google.com/search?q=google+translate&rlz=1C1GCEU_" +

					"enUS973US973&oq=google+&aqs=chrome.0.69i59l2j69i57j69i60l3j69i65l2.2256j0j9&sourceid=chrome&ie=UTF-8");
			translate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void translate() throws InterruptedException {
		driver.findElement(By.id("tw-source-text-ta")).click();
	    driver.findElement(By.id("tw-source-text-ta")).sendKeys("Hello");
	    driver.findElement(By.id("tw-tl")).click();
	    driver.findElement(By.id("tl_list-search-box")).sendKeys("ma");
	    driver.findElement(By.cssSelector(".language_list_tl_list > .tw-lliw:nth-child(65)")).click();
		Thread.sleep(3000);
		String result = driver.findElement(By.xpath("//*[@id=\"tw-target-text\"]/span")).getText();
		System.out.println(" The Result is " + result);
	}

	public static void main(String[] args) {
		Translate test = new Translate();
		test.invokeBrowser();
	}
}