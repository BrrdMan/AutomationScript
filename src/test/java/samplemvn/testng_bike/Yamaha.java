package samplemvn.testng_bike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Yamaha {

	@Test(groups = "system")
	public void launch() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://yamahamotorsports.com/");
		Reporter.log("Yamaha launched", true);
	}
}
