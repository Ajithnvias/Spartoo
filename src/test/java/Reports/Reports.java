package Reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import TestReports.Report;

public class Reports implements ITestListener {
	
	ExtentTest test;
	ExtentReports reports = Report.ReportConfig();
	ThreadLocal<ExtentTest> extest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
	
	}

	public void onFinish(ITestContext context) {
	reports.flush();
	}


}
