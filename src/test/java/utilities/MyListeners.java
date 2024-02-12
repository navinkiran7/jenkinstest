package utilities;
import java.io.File;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class MyListeners {
 public static WebDriver driver;
   
   public static void initialize()
   {    System.setProperty("C:\\Users\\navin\\eclipse-workspace\\ps\\drivers\\chromedriver.exe", null);
    driver= new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("demowebshop.tricentis.com/login  ");
   }
   public void captureScreenshot(String methodname)
   { 
    Date d = new Date();
    String timestamp = d.toString().replace(":", "_").replace(" ", "");
    try {
     File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    }
    catch (Exception e) {
   e.getMessage();// TODO: handle exception
  }
   }
}
