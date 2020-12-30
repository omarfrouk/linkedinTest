package linkedin;
    
import java.util.ArrayList;
import java.util.List;
 
import org.testng.annotations.*;
    
  
public class searchTests extends BaseTest {  
	linkedin.searchPage searchPg; 
	private String searchDataPath = "src\\test\\resources\\inputData\\searchData.csv";   
	
	@DataProvider(name="searchData")
    public Object[][]  getSearchData() throws Exception { 
		return linkedin.CSVFiles.readCSVFile(searchDataPath); 
    }
	
	@Test (dataProvider = "searchData")
	public void search_with_filter(String name, String filter) throws Exception  { 
		List<String> linkedinSearchLinks = new ArrayList<String>(); 
		List<String> googleSearchLinks = new ArrayList<String>(); 
		 //search from linkedin
		searchPg =new linkedin.searchPage(driver);   
		searchPg.signin();
		searchPg.setLinkedinSearchFiled(name);  
		searchPg.setFilter(filter); 
		linkedinSearchLinks=searchPg.getLinkedinSearchData(filter);
		
		//search from google 
		driver.get("https://www.google.com/search?q="+name+"+"+filter+"+linkedin.com&oq="+name); 
		googleSearchLinks=searchPg.getGoogleSearchData();  
		for (int i = 0; i < googleSearchLinks.size(); i++) {   
			if( !(linkedinSearchLinks.get(i).equals(googleSearchLinks.get(i))))
			  System.out.println("\""+linkedinSearchLinks.get(i)+"\""+" does not match "+"\""+googleSearchLinks.get(i)+"\"");
		  }   
	} 
	  
}





