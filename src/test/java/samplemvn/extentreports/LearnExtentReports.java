package samplemvn.extentreports;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LearnExtentReports {

	@Test
	public void createReport() {

		String time = LocalDateTime.now().toString().replace(":", "-");

		// step 1: Create ExtentSparkReporter object
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Reports/extentreport" + time + ".html");

		// step 2: Create ExtentReports object
		ExtentReports eReport = new ExtentReports();

		// step 3: Attach ExtentSparkReporter to ExtentReports object
		eReport.attachReporter(spark);

		// step 4: ExtentTest object
		ExtentTest test = eReport.createTest("createReport");

		// step 5: Call log(Status, "message")
		test.log(Status.FAIL, "log message added into report");

		// step 6: Call flush()
		eReport.flush();
	}

}
