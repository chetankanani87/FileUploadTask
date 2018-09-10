package fileUploadTask;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import lib.BrowserDriverUtility;
import lib.EmailWithAttachmentUtility;
import lib.ExtentReportUtility;
import lib.ScreenshotUtility;

public class SingleFileUploadTask {
	WebDriver dr = BrowserDriverUtility.InvokeBrowser("webdriver.chrome.driver",
			"C:\\Chetan\\SeleniumSuite\\WebDrivers\\chromedriver.exe",
			"C:\\Chetan\\AutoIT\\AutoIT_Stuff\\fileupload.html");
	ExtentReports report = ExtentReportUtility.InvokeExtentReport();
	ExtentTest logger = report.createTest("File Upload Test");
	String path1, path2;

	@BeforeTest
	public void InvokeBrowser() {
		try {
			path1 = ScreenshotUtility.CaptureScreenshot(dr, "1_MainPage");
			logger.pass("Main Page - Screenshot taken.", MediaEntityBuilder.createScreenCaptureFromPath(path1).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void FileUpload() {
		try {
			dr.findElement(By.id("1")).click();

			Runtime.getRuntime().exec("C:\\Chetan\\AutoIT\\AutoIT_Stuff\\FileUpload.exe");
			Thread.sleep(2000);
			path2 = ScreenshotUtility.CaptureScreenshot(dr, "2_FileUploaded");
			logger.pass("File is uploaded successfully - Screenshot taken.",
					MediaEntityBuilder.createScreenCaptureFromPath(path2).build());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterTest
	public void tearDown() {
		try {
			EmailWithAttachmentUtility.SendEmail("Test Case Passed - File is uploaded successfully...!!!",
					"Congratulations...!!!", path1, "Screenshot of Main page which is working fine...!!!", path2,
					"Screenshot of attached file, which is working fine...!!!");
			report.flush();
			Thread.sleep(1000);
			dr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
