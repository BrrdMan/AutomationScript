package samplemvn.testng_bike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class KawasakiTest {

	@Test(groups = "regression")
	public void launch() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.kawasaki-india.com/");
		Reporter.log("Kawasaki launched", true);
	}
}
