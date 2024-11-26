package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
	//is a custom report
	public static final ExtentReports extentReports = new ExtentReports();
	
	public synchronized static ExtentReports createExtentReports() {
		//aventstack will provide required classes and interfaces
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		//specifies location where we need to generate report
		reporter.config().setReportName("7RMart Project");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", "Navamy");
		return extentReports;
	}
}
//once we run, new folder get created-extend report named extend-report.html (just like test-output)