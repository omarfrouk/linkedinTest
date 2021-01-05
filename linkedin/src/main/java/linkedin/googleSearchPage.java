package linkedin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class googleSearchPage extends BasePage {
    
	public googleSearchPage(WebDriver driver) throws IOException {
		super(driver); 
	}
	 
	public void setGoogleSearchFiled(String data) {
		setFieldText(Locators.googleSearchFiled, data); 
		sendKeysToInputs(Locators.googleSearchFiled, Keys.ENTER); 
	}
  public List<String> getGoogleSearchData() throws Exception {  
	  List<String> googleSearchLinks = new ArrayList<String>();  
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
  public void comparTwolists(List<String> firstList, List<String> secondList) {
		for (int i = 0; i < firstList.size(); i++) {   
		if( !(firstList.get(i).equals(secondList.get(i))))
		  System.out.println("\""+firstList.get(i)+"\""+" does not match "+"\""+secondList.get(i)+"\"");
	  }  
  }
   
}
