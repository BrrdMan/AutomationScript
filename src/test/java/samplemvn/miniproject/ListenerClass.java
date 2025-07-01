package samplemvn.miniproject;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerClass extends BaseClass implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test script has passed", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Test script has failed", true);
		TakesScreenshot ts = (TakesScreenshot) driver;
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);

		ExtentTest test = report.createTest("loginTest");
		test.log(Status.FAIL, "Test Script has failed. Screenshot of failure is attached");
		test.addScreenCaptureFromBase64String(screenshot);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test script has been skipped", true);
	}

}
