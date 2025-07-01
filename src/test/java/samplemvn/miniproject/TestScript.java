package samplemvn.miniproject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerClass.class)
public class TestScript extends BaseClass {

	@Test
	public void loginTest() {
		driver.findElement(By.linkText("Log in")).click();

		driver.findElement(By.id("Email")).sendKeys("lewisH@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Lewis@44");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();

		Assert.assertEquals(driver.getTitle(), "Demo Web Shop",
				"Homepage is not displayed as expected. There must be problem with login");
	}

}
