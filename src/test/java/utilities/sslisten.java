package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class sslisten extends MyListeners implements ITestListener {
  @Test
  public void onTestFailure(ITestResult result) {
   System.out.println("Test is failed");
   try {
    captureScreenshot(result.getName());
   }
   catch (Exception e) {
  e.getMessage();
 }
  }
}