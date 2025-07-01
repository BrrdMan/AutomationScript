package samplemvn.extentreports;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AddScreenshotToReport {

	@Test
	public void addScreenshot() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.flipkart.in/");

		// Take a screenshot of webpage in BASE64 format
		TakesScreenshot ts = (TakesScreenshot) driver;
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);

		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Reports/screenshotReport.html");
		ExtentReports eReport = new ExtentReports();
		eReport.attachReporter(spark);
		ExtentTest test = eReport.createTest("addScreenshot");
		test.log(Status.INFO, "This is a screenshot report");
		// Attach the screenshot to the report
		test.addScreenCaptureFromBase64String(screenshot);
		eReport.flush();
	}

}
