package testCases;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.Test;

public class testCases1 {

	private WebDriver driver;
	  private String baseUrl;
	  private String num;
	  private String result;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private String srcstring = "D://inputgit.csv";
	  public CsvReader r;

	  @Before
	  public void setUp() throws Exception {
		r = new CsvReader(srcstring, ',',Charset.forName("GBK"));
		r.readHeaders();
		driver = new FirefoxDriver();
	    baseUrl = "http://121.193.130.195:8080";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testSuite1() throws Exception {
	    driver.get(baseUrl + "/");
	    while( r.readRecord()){
	    	driver.findElement(By.id("name")).clear();
	    	driver.findElement(By.id("name")).sendKeys(r.get("—ß∫≈"));
	    	num = r.get("—ß∫≈").substring(4,10 );	    	
	    	driver.findElement(By.id("pwd")).clear();
	    	driver.findElement(By.id("pwd")).sendKeys(num);
	    	driver.findElement(By.id("submit")).click();
	    	assertEquals(r.get("githubµÿ÷∑"), driver.findElement(By.xpath("//tbody[@id='table-main']/tr[3]/td[2]")).getText());
	    	driver.get(baseUrl + "/");
	    }
	  }
	  
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
