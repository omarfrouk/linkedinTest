package linkedin;
    

import org.testng.annotations.*;
import org.testng.Assert;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
    
  
public class searchTests extends BaseTest {  
	linkedin.linkedinSearchPage linkedinSearchPg;
	linkedin.googleSearchPage googleSearchPg;
	linkedin.signinPage signinPg;
	public static String searchDataPath;
	public static String filtersPath;   
	
	//@DataProvider(name="searchData")
    public Object[][]  getSearchData() throws Exception { 
    	config.propertiesFile.readPropertiesFile(); 
		return linkedin.CSVFiles.readCSVFile(searchDataPath); 
    }
	//@Test (dataProvider = "searchData")
	public void comparison_linkedin_search_with_google_search_with_using_filters(String name, String filter) throws Exception  { 
		List<String> linkedinSearchLinks = new ArrayList<String>(); 
		List<String> googleSearchLinks = new ArrayList<String>(); 
		 //search from linkedin
		linkedinSearchPg =new linkedin.linkedinSearchPage(driver);  
		googleSearchPg =new linkedin.googleSearchPage(driver); 
		signinPg=new linkedin.signinPage(driver);
		
		signinPg.signin();
		linkedinSearchPg.setLinkedinSearchFiled(name);  
		linkedinSearchPg.setFilter(filter); 
		linkedinSearchLinks=linkedinSearchPg.getLinkedinSearchData(filter);
		
		//search from google(get google web site)
		googleSearchPage.getGoogleSearchForLinkedin(name,filter); 
		googleSearchLinks=googleSearchPg.getGoogleSearchData();  
//		for (int i = 0; i < googleSearchLinks.size(); i++) {   
//			if( !(linkedinSearchLinks.get(i).equals(googleSearchLinks.get(i))))
//			  System.out.println("\""+linkedinSearchLinks.get(i)+"\""+" does not match "+"\""+googleSearchLinks.get(i)+"\"");
//		  }   
		Assert.assertNotEquals(linkedinSearchLinks, googleSearchLinks,"The two lists are match");
	} 
	
	//@DataProvider(name="filterAssertion")
    public Object[][]  getFilter() throws Exception,IOException { 
		config.propertiesFile.readPropertiesFile(); 
		return linkedin.CSVFiles.readCSVFile(filtersPath);  
    }
    
	//@Test(dataProvider="filterAssertion")
	public void search_filters_should_be_displayed_test1(String name,String filter ) throws IOException {
		//String name="ali";String filter="People";
		linkedinSearchPg =new linkedin.linkedinSearchPage(driver);   
		signinPg=new linkedin.signinPage(driver);
		
		signinPg.signin();
		linkedinSearchPg.setLinkedinSearchFiled(name); 
		Assert.assertTrue(linkedinSearchPg.isFilterDisplayed(filter));
		linkedinSearchPg.setFilter(filter);  
	} 
	@Test
	public void search_filters_should_be_displayed_test2() throws IOException {
		linkedinSearchPg =new linkedin.linkedinSearchPage(driver);   
		signinPg=new linkedin.signinPage(driver);
		
		signinPg.signin();
		String name="Ali";
		linkedinSearchPg.setLinkedinSearchFiled(name); 
		String[] expectedFilters={"People","Jobs","Content"};  
		String[] actualFilters= new String[3];
		actualFilters=linkedinSearchPg.getsearchFilters(); 
		assertThat(expectedFilters, is(actualFilters));  
		
	} 
	
	  
}





