package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

// Class Name: Listeners
// Class Description: This class implements the Allure Report system
public class Listeners extends CommonOps implements ITestListener {

    public void onStart(ITestContext execution) {
        System.out.println("------------------- Starting Execution -------------------");
    }

    public void onFinish(ITestContext execution) {
        System.out.println("------------------- Ending Execution -------------------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }

    public void onTestSkipped(ITestResult test) {
        System.out.println("------------------- Skipped Test: " + test.getName() + "-------------------");
    }

    public void onTestStart(ITestContext test) {
        System.out.println("------------------- Starting Test: " + test.getName() + "-------------------");
    }

    // Method Name: onTestSuccess
    // Method Description: This method executes all the necessary actions if a test passed successfully
    // Method Parameters: ITestResults
    // Method Return: None
    public void onTestSuccess(ITestResult test) {
        System.out.println("------------------- Test: " + test.getName() + " Passed -------------------");
        if (!platform.equalsIgnoreCase("api")) {
            // Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Delete Recorded File
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if (file.delete())
                System.out.println("File Deleted Successfully");
            else
                System.out.println("Failed To Delete File");
        }
    }

    // Method Name: onTestFailure
    // Method Description: This method executes all the necessary actions if a test was failed
    // Method Parameters: ITestResults
    // Method Return: None
    public void onTestFailure (ITestResult test){
        System.out.println("------------------- Test: " + test.getName() + " Failed -------------------");
        if (!platform.equalsIgnoreCase("api")) {
            // Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveScreenshot();
        }
    }

    // Method Name: saveScreenshot
    // Method Description: This method takes a screenshot in case of test failure
    // Method Parameters: None
    // Method Return: Bytes
    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte[] saveScreenshot() {
        if (!platform.equalsIgnoreCase("mobile"))
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        else
            return ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.BYTES);
    }
}

