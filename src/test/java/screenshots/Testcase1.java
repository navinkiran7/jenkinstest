package screenshots;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.MyListeners;

//@Listeners(screenshots.ListenerClass.class)
@SuppressWarnings("unused")
public class Testcase1 extends MyListeners{
 
  @BeforeTest
  public void setup()
  {
   initialize();
  }
  @Test
  public void testMethod1() {
   
   driver.findElement(null);
  }
  @AfterTest
  public void tearDown()
  {
   driver.quit();
  }
}