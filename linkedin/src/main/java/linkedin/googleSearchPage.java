package linkedin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import org.openqa.selenium.WebDriver;

public class googleSearchPage extends BasePage {

	public static String searchDataOutput;   
	public googleSearchPage(WebDriver driver) throws IOException {
		super(driver); 
	}
    
	public static void getGoogleSearchForLinkedin(String name, String filter) {
		driver.get("https://www.google.com/search?q="+name+"+"+filter+"+linkedin.com&oq="+name); 
	}
  public List<String> getGoogleSearchData() throws Exception {  
	  List<String> googleSearchLinks = new ArrayList<String>(); 
	  //googleSearchLinks.clear();
	  Locators.resetGoogleVariableValue();
	  for (int i = 1; i < 9; i++) { 
		  try {
			  googleSearchLinks.add(getAttribute(Locators.tittleOfResultFromGoogle,"href"));
		} catch (Exception e) {
			googleSearchLinks.add(getAttribute(Locators.tittleOfResultFromGoogleAlter,"href"));
		} 
	  Locators.changeGoogleVariableValue();
	  scrollDown(150);
	  } 
	  
	  return googleSearchLinks; 
  }
   
}
