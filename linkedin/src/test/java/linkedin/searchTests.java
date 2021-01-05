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
	public static String googleURL;   
	public static String linkedinURL;  
	
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
		
		//(get linkedin web site)
		linkedinSearchPg.setWebSite(linkedinURL); 
		signinPg.signin();
		linkedinSearchPg.setLinkedinSearchFiled(name);  
		linkedinSearchPg.setFilter(filter); 
		linkedinSearchLinks=linkedinSearchPg.getLinkedinSearchData(filter);
		
		//search from google(get google web site)
		googleSearchPg.setWebSite(googleURL);  
		googleSearchPg.setGoogleSearchFiled(name+" "+filter+" linkedin.com"); 
		googleSearchLinks=googleSearchPg.getGoogleSearchData();  
		googleSearchPg.comparTwolists(linkedinSearchLinks, googleSearchLinks);
		Assert.assertNotEquals(linkedinSearchLinks, googleSearchLinks,"The two lists are match");
	} 
	
	//@DataProvider(name="filterAssertion")
    public Object[][]  getFilter() throws Exception,IOException { 
		config.propertiesFile.readPropertiesFile(); 
		return linkedin.CSVFiles.readCSVFile(filtersPath);  
    }
    
	//@Test(dataProvider="filterAssertion")
	public void search_filters_should_be_displayed_test1(String name,String filter ) throws IOException {
		linkedinSearchPg =new linkedin.linkedinSearchPage(driver);   
		signinPg=new linkedin.signinPage(driver);
		
		//(get linkedin web site)
		linkedinSearchPg.setWebSite(linkedinURL); 
		signinPg.signin();
		linkedinSearchPg.setLinkedinSearchFiled(name); 
		Assert.assertTrue(linkedinSearchPg.isFilterDisplayed(filter));
	} 
	@Test
	public void search_filters_should_be_displayed_test2() throws IOException {
		linkedinSearchPg =new linkedin.linkedinSearchPage(driver);   
		signinPg=new linkedin.signinPage(driver);
		
		//(get linkedin web site)
		linkedinSearchPg.setWebSite(linkedinURL); 
		signinPg.signin();
		String name="Ali";
		linkedinSearchPg.setLinkedinSearchFiled(name); 
		String[] expectedFilters={"People","Jobs","Content"};   
		String[] actualFilters= new String[3];
		actualFilters=linkedinSearchPg.getsearchFilters(); 
		assertThat(actualFilters,is(expectedFilters));  
		
	} 
	
	  
}





