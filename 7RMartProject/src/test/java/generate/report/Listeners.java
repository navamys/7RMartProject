package generate.report;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtendReportUtility;

public class Listeners implements ITestListener {
	 ExtentTest test;
	 
	 	ExtentReports extent = ExtendReportUtility.createExtentReports(); 
	 	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); 
	  
	 	public void onTestStart(ITestResult result) { 
	  //once TC run starts, will listen ITestListener console and fetch name of TC and add to report
	 		ITestListener.super.onTestStart(result); 
	 		test = extent.createTest(result.getMethod().getMethodName()); 
	 		extentTest.set(test); 
	  
	 	} 
	  
	 	public void onTestSuccess(ITestResult result) { 
	  //if status is pass, add test as pass in report
	 		ITestListener.super.onTestSuccess(result); 
	 		extentTest.get().log(Status.PASS, "Test Passed"); 
	  
	 	} 
	 	public void onTestFailure(ITestResult result) { 
	  //if TC status fail, add test as fail and add specific exception(printStackTrace method used) reason as well
	 		ITestListener.super.onTestFailure(result); 
	 		extentTest.get().log(Status.FAIL, "Test Failed"); 
	 		extentTest.get().fail(result.getThrowable()); 
	 		WebDriver driver = null; 
	 		String testMethodName = result.getMethod().getMethodName(); 
	 		try { 
	 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
	 					.get(result.getInstance()); 
	 		} catch (IllegalArgumentException e) { 
	  
	 			e.printStackTrace(); 
	 		} catch (IllegalAccessException e) { 
	  
	 			e.printStackTrace(); 
	 		} catch (NoSuchFieldException e) { 
	  
	 			e.printStackTrace(); 
	 		} catch (SecurityException e) { 
	  
	 			e.printStackTrace(); 
	 		} 
	  
	 		try { 
	 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
	 					.get(result.getInstance()); 
	 		} catch (Exception e) { 
	 		} 
	 	} 
	 public void onTestSkipped(ITestResult result) { 
		 //sts skip, add test skipped in report
	 		ITestListener.super.onTestSkipped(result); 
	 		extentTest.get().log(Status.SKIP, "Test Skipped"); 
	 		String testMethodName = result.getMethod().getMethodName(); 
	  
	 	} 
	  
	 	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { 
	  //%, pass, fail numbers
	 		ITestListener.super.onTestFailedButWithinSuccessPercentage(result); 
	 	} 
	 public void onTestFailedWithTimeout(ITestResult result) { 
	  
	 		ITestListener.super.onTestFailedWithTimeout(result); 
	 	} 
	  
	 	public void onStart(ITestContext context) { 
	  //create graph
	 		ITestListener.super.onStart(context); 
	 	} 
	  
	 	public void onFinish(ITestContext context) { 
	  //flush mthd is used to generate report, report will get generated only if we call this flush mthd
	 		ITestListener.super.onFinish(context); 
	 		extent.flush();

}}
