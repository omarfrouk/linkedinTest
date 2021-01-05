package linkedin;
 
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import org.openqa.selenium.Keys;

public class linkedinSearchPage extends BasePage {
	
	public static String searchDataOutput;   
	
	public linkedinSearchPage(WebDriver driver) throws IOException {
		super(driver); 
	}
    
  public void setLinkedinSearchFiled(String name) { 
	setFieldText(Locators.searchfiled, name); 
	sendKeysToInputs(Locators.searchfiled, Keys.ENTER); 
  }   
  public String[] getsearchFilters() { 
	  String[] filters= new String[3];
	  for (int i = 0; i <filters.length; i++) {
		  if(isElementDisplayed(Locators.filters))  
			  filters[i]=getElementText(Locators.filters);
		  Locators.changeFilterValue(); 
	}
	  return filters; 
  }

  public boolean isFilterDisplayed(String filter) { 
	  if(filter.equals("People")) 
		  return isElementDisplayed(Locators.peopleFilterButton);  
	  else if(filter.equals("Jobs")) 
		  return isElementDisplayed(Locators.jobsFilterButton);
	  else if(filter.equals("Content")) 
		  return isElementDisplayed(Locators.contentFilterButton);
	  else if(filter.equals("Companies")) {    
		  clickElemet(Locators.moreFilters);   
		  return isElementDisplayed(Locators.companiesFilter);  
	  }else if(filter.equals("Schools")) {    
		  clickElemet(Locators.moreFilters);   
		  return isElementDisplayed(Locators.schoolsFilter);  
	  }else if(filter.equals("Groups")) {    
		  clickElemet(Locators.moreFilters);   
		  return isElementDisplayed(Locators.groupsFilter);  
	  }else if(filter.equals("Events")) {    
		  clickElemet(Locators.moreFilters);   
		  return isElementDisplayed(Locators.eventsFilter);  
	  }
	  else
		  return false;
	    }
  public void setFilter(String filter) {  
	  if(filter.equals("People")) 
		  clickElemet(Locators.peopleFilterButton);  
	  else if(filter.equals("Jobs")) 
		  clickElemet(Locators.jobsFilterButton);
	  else if(filter.equals("Content")) 
		  clickElemet(Locators.contentFilterButton);
	  else if(filter.equals("Companies")) {    
		  clickElemet(Locators.moreFilters);   
		  clickElemet(Locators.companiesFilter);  
	  }else if(filter.equals("Schools")) {    
		  clickElemet(Locators.moreFilters);   
		  clickElemet(Locators.schoolsFilter);  
	  }else if(filter.equals("Groups")) {    
		  clickElemet(Locators.moreFilters);   
		  clickElemet(Locators.groupsFilter);  
	  }else if(filter.equals("Events")) {    
		  clickElemet(Locators.moreFilters);   
		  clickElemet(Locators.eventsFilter);  
	  } 
  } 
  public List<String> getLinkedinSearchData(String filter) throws Exception {
	  Locators.resetLenkidinPeopleVariableValue();
	  Locators.resetLenkidinCompaniesVariableValue();
	  List<String> linkedinSearchLinks = new ArrayList<String>();  
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
	  return linkedinSearchLinks;
  } 
  
   
}
