package linkedin;
 
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
 
import org.openqa.selenium.Keys;

public class searchPage extends BasePage {
	
	private String email="omar0099_gath@hotmail.com";
	private String password="mypass";
	private String searchDataOutput = "src\\test\\resources\\outputData\\searchDataOutput.csv";  
	private List<String> linkedinSearchLinks = new ArrayList<String>(); 
	private List<String> googleSearchLinks = new ArrayList<String>(); 
	
	public searchPage(WebDriver driver) {
		super(driver);
	}
  
	public void signin() {
		setFieldText(Locators.email,email); 
		setFieldText(Locators.password,password);
		clickElemet(Locators.signinButton);  
	}
  public void setLinkedinSearchFiled(String name) { 
	setFieldText(Locators.searchfiled, name); 
	sendKeysToInputs(Locators.searchfiled, Keys.ENTER); 
  }   
  public void setFilter(String filter) {  
	  if(filter.equals("People")) {
		  clickElemet(Locators.peopleFilterButton);  
		  }
	  if(filter.equals("Companies")) {    
		  clickElemet(Locators.moreFilters);   
		  clickElemet(Locators.companiesFilter);  
	  }   
  } 
  public List<String> getLinkedinSearchData(String filter) throws Exception {
	  Locators.resetLenkidinPeopleVariableValue();
	  Locators.resetLenkidinCompaniesVariableValue();
	  linkedinSearchLinks.clear();
	  //store data from search into list
	  List<String[]> temp= new ArrayList<>(); 
	  temp.clear(); 
	  for (int i = 1; i < 9; i++) {
		  if(filter.equals("People")){
			  String[] temp1 = {getElementText(Locators.linkedinResultSearchNamePeople),
					  getAttribute(Locators.linkedinResultSearchLinkPeople,"href"),
					  getElementText(Locators.linkedinResultSearchPasitionPeople),
					  getElementText(Locators.linkedinResultSearchLocatonPeople) }; 
			  //store linkedin links into list
			  linkedinSearchLinks.add(getAttribute(Locators.linkedinResultSearchLinkPeople,"href"));
			  temp.add(temp1);
			//increment value of variables (first 8 results)
			  Locators.changeLenkidinPeopleVariableValue(); 
		  
		  }else if(filter.equals("Companies")){
			  String[] temp2 = {getElementText(Locators.linkedinResultSearchNameCompanies),
					  getAttribute(Locators.linkedinResultSearchLinkCompanies,"href"),
					  getElementText(Locators.linkedinResultSearchPasitionAndLocatonCompanies)}; 
			  //store linkedin links into list
			  linkedinSearchLinks.add(getAttribute(Locators.linkedinResultSearchLinkCompanies,"href"));
			  temp.add(temp2);
			//increment value of variables (first 8 results)
			  Locators.changeLenkidinCompaniesVariableValue();  
			  
	  }
		  
		  scrollDown(150);
	  }    
	  //store data into csv file
	  CSVFiles.writeToCSVFile(searchDataOutput, temp);   
//	  for (int i = 0; i < linkedinSearchLinks.size(); i++) {
//		  System.out.println(temp.get(i)[0]); 
//		  System.out.println(linkedinSearchLinks.get(i)); 
//	  }
	  return linkedinSearchLinks;
  } 
  
  public List<String> getGoogleSearchData() throws Exception {  
	  googleSearchLinks.clear();
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
	  
//	  for (int i = 0; i < googleSearchLinks.size(); i++) { 
//		  System.out.println(googleSearchLinks.get(i)); 
//	  }
	  return googleSearchLinks; 
  }
  public void linksComparison (){
	  for (int i = 0; i < googleSearchLinks.size(); i++) {  
		  try {
			  Assert.assertEquals(linkedinSearchLinks.get(i),googleSearchLinks.get(i)); 
		} catch (Exception e) {
			System.out.println("\""+linkedinSearchLinks.get(i)+"\""+" does not match "+"\""+googleSearchLinks.get(i)+"\"");
		} 
	  }
	  
}
  
}
