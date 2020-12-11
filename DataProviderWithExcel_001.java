package practiceTestCases;

		import java.util.concurrent.TimeUnit;

		import org.openqa.selenium.By;

		import org.openqa.selenium.WebDriver;

		import org.openqa.selenium.chrome.*;

		import org.testng.annotations.AfterMethod;

		import org.testng.annotations.BeforeMethod;

		import org.testng.annotations.Test;

		import org.testng.annotations.DataProvider;

		import utility.ExcelUtils;

	public class DataProviderWithExcel_001 {

		WebDriver driver;

	    @BeforeMethod

	    public void beforeMethod() throws Exception {

		    driver = new ChromeDriver();

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        driver.get("http://www.guanggoo.com/login");	 

		}

	@Test(dataProvider="Authentication")

    public void Registration_data(String sUserName,String sPassword)throws  Exception{

       

		driver.findElement(By.id("email")).sendKeys(sUserName);

		System.out.println(sUserName);

		driver.findElement(By.id("password")).sendKeys(sPassword);

		System.out.println(sPassword);
		
        driver.findElement(By.xpath("//div/button[contains(text(),'登录')]"));

        

		}

    @DataProvider

    public Object[][] Authentication() throws Exception{

         Object[][] testObjArray = ExcelUtils.getTableArray("/Users/anran/eclipse-workspace/datadriven2/src/testData/TestData.xlsx","Sheet1");

         return (testObjArray);

		}

    @AfterMethod

    public void afterMethod() {

  	    driver.close();

    	}

}