package TestReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {
	
public static ExtentReports reports;
	
	
	public static ExtentReports ReportConfig()
	{
		reports = new ExtentReports();
		reports.setSystemInfo("Platform", "Windows");
		reports.setSystemInfo("Browser","Chrome");
		String path = System.getProperty("user.dir")+"\\testReports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Testing Reports");
		reporter.config().setReportName("Yuvi");
		reporter.config().setTheme(Theme.DARK);
		reports.attachReporter(reporter);
		return reports;
	}

}
