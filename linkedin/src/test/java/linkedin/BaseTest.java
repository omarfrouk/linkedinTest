package linkedin;
   
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
 
public class BaseTest {
	WebDriver driver; 
	public static String driverPath;  
    
	 
    @BeforeMethod
    public void invokeBrowser() throws Exception {  
    	config.propertiesFile.readPropertiesFile();
    	System.setProperty("webdriver.chrome.driver", driverPath); 
        driver = new ChromeDriver(); 
    }
    @AfterMethod
    public void terminateBrowser() {  
        driver.close(); 
    } 
    
    
}
