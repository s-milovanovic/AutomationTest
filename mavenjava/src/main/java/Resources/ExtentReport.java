package Resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport extends BasePage {
	static ExtentReports extent;

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "\\reports\\report.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("iGame Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setTimeStampFormat("HH:mm:ss");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Tester", "Srdjan Milovanovic");
		return extent;
	}

	public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		/*
		 * TakesScreenshot ts = (TakesScreenshot) driver; File source =
		 * ts.getScreenshotAs(OutputType.FILE); String filePath =
		 * System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		 * FileUtils.copyFile(source, new File(filePath)); return filePath;
		 */
		// driver = initializeDriver();

		String filePath = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		System.out.println("Drajver u bejzu: " + driver);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(filePath));
		return filePath;
	}

}
