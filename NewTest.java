package datadriven2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;


public class NewTest {
	
	WebDriver driver;
  
 @DataProvider(name = "Authentication")

  public static Object[][] credentials() {

          // The number of times data is repeated, test will be executed the same no. of times

          // Here it will execute two times

  return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_2", "Test@123" }};

  }
 
  @Test(dataProvider="Authentication")
   public void login(String usrname,String password) {
	   driver=new ChromeDriver();
	   
	   driver.get("http://www.guanggoo.com/login");
	   
	   driver.findElement(By.id("email")).sendKeys(usrname);
	   
	   driver.findElement(By.id("password")).sendKeys(password);
	   
	   driver.quit();
	   	   
   }
   
}
