package samplemvn.miniproject;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentReports report;
	String timestamp = LocalDateTime.now().toString().replace(":", "-");

	@BeforeSuite
	public void reportConfig() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Reports/extentReport" + timestamp + ".html");
		report = new ExtentReports();
		report.attachReporter(spark);
	}

	@BeforeClass
	public void openBrowser() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--start-maximized");

		driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://demowebshop.tricentis.com/");
	}

	@AfterSuite
	public void reportBackup() {
		report.flush();
	}

}
