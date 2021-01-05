package linkedin;
   
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
 
public class BaseTest {
	WebDriver driver;
	public static String url; 
	public static String driverPath;  
    
	 
    @BeforeMethod
    public void invokeBrowser() throws Exception { 
    	
    	config.propertiesFile.readPropertiesFile();
    	System.setProperty("webdriver.chrome.driver", driverPath); 
        driver = new ChromeDriver();
        driver.get(url);  
    }
    @AfterMethod
    public void terminateBrowser() {  
        driver.close(); 
    } 
    
    
}
