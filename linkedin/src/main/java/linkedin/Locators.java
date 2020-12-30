package linkedin;

import org.openqa.selenium.By;

public class Locators {
	public static final By email=By.id("username");
	public static final By password =By.id("password"); 
	public static final By signinButton =By.xpath("//button[text()='Sign in']");
	public static final By searchfiled =By.xpath("//*[@id=\"ember20\"]/input");
	public static final By moreFilters =By.xpath("//button//span[text()='More']");//button[@aria-expanded=\"false\" and @class='artdeco-dropdown__trigger search-vertical-filter__dropdown-trigger artdeco-button artdeco-button--tertiary artdeco-button--2 artdeco-button--muted artdeco-dropdown__trigger--placement-bottom ember-view']");//span[text()='More']");
	public static final By peopleFilterButton =By.xpath("//span[text()='People']");
	public static final By companiesFilter =By.xpath("//*[text()='Companies']");//ul[@class='list-style-none']/li/button/span[text()='Companies']");
	
	public static int i=1;
	public static  By linkedinResultSearchNamePeople=By.xpath("//div[@class='search-results ember-view']/div/ul/li["+i+"]//h3//span//span[@class='name actor-name']");
	public static  By linkedinResultSearchLinkPeople=By.xpath("//div[@class='search-results ember-view']/div/ul/li["+i+"]//a[@class='search-result__result-link ember-view']");
	public static  By linkedinResultSearchPasitionPeople=By.xpath("//div[@class='search-results ember-view']/div/ul/li["+i+"]//p[1]");
	public static  By linkedinResultSearchLocatonPeople=By.xpath("//div[@class='search-results ember-view']/div/ul/li["+i+"]//p[2]");
	
	public static void changeLenkidinPeopleVariableValue() {
		i+=1;
		linkedinResultSearchNamePeople=By.xpath("//div[@class='search-results ember-view']/div/ul/li["+i+"]//h3//span//span[@class='name actor-name']");
		linkedinResultSearchLinkPeople=By.xpath("//div[@class='search-results ember-view']/div/ul/li["+i+"]//a[@class='search-result__result-link ember-view']");
		linkedinResultSearchPasitionPeople=By.xpath("//div[@class='search-results ember-view']/div/ul/li["+i+"]//p[1]");
		linkedinResultSearchLocatonPeople=By.xpath("//div[@class='search-results ember-view']/div/ul/li["+i+"]//p[2]");
		
	}
	public static void resetLenkidinPeopleVariableValue() {
		i=1;
		linkedinResultSearchNamePeople=By.xpath("//div[@class='search-results ember-view']/div/ul/li["+i+"]//h3//span//span[@class='name actor-name']");
		linkedinResultSearchLinkPeople=By.xpath("//div[@class='search-results ember-view']/div/ul/li["+i+"]//a[@class='search-result__result-link ember-view']");
		linkedinResultSearchPasitionPeople=By.xpath("//div[@class='search-results ember-view']/div/ul/li["+i+"]//p[1]");
		linkedinResultSearchLocatonPeople=By.xpath("//div[@class='search-results ember-view']/div/ul/li["+i+"]//p[2]");
		
	}
	
	public static int ii=1;
	public static  By linkedinResultSearchNameCompanies=By.xpath("//ul/li["+ii+"]/div/div/div[2]/div[1]/div/div[1]/span/div/span/span/a");
	public static  By linkedinResultSearchLinkCompanies=By.xpath("//ul/li["+ii+"]/div/div/div[2]/div[1]/div/div[1]/span/div/span/span/a");
	public static  By linkedinResultSearchPasitionAndLocatonCompanies=By.xpath("//ul/li["+ii+"]/div/div/div[2]/div[1]/div/div[2]/div[1]"); 
	
	public static void changeLenkidinCompaniesVariableValue() {
		ii+=1;
		linkedinResultSearchNameCompanies=By.xpath("//ul/li["+ii+"]/div/div/div[2]/div[1]/div/div[1]/span/div/span/span/a");
		linkedinResultSearchLinkCompanies=By.xpath("//ul/li["+ii+"]/div/div/div[2]/div[1]/div/div[1]/span/div/span/span/a");
		linkedinResultSearchPasitionAndLocatonCompanies=By.xpath("//ul/li["+ii+"]/div/div/div[2]/div[1]/div/div[2]/div[1]"); 
		
	}
	public static void resetLenkidinCompaniesVariableValue() {
		ii=1;
		linkedinResultSearchNameCompanies=By.xpath("//ul/li[\"+ii+\"]/div/div/div[2]/div[1]/div/div[1]/span/div/span/span/a");
		linkedinResultSearchLinkCompanies=By.xpath("//ul/li[\"+ii+\"]/div/div/div[2]/div[1]/div/div[1]/span/div/span/span/a");
		linkedinResultSearchPasitionAndLocatonCompanies=By.xpath("//ul/li["+ii+"]/div/div/div[2]/div[1]/div/div[2]/div[1]"); 
		
	}
 
	public static int j=2;
	public static By tittleOfResultFromGoogle=By.xpath("//*[@id=\"rso\"]/div["+j+"]/div/div[1]/a");
	public static By tittleOfResultFromGoogleAlter=By.xpath("//*[@id=\"rso\"]/div/div["+j+"]/div/div[1]/a");
	public static void changeGoogleVariableValue() {
		j+=1;
		tittleOfResultFromGoogle=By.xpath("//*[@id=\"rso\"]/div["+j+"]/div/div[1]/a");
		tittleOfResultFromGoogleAlter=By.xpath("//*[@id=\"rso\"]/div/div["+j+"]/div/div[1]/a");
	} 
	public static void resetGoogleVariableValue() {
		j=2;
		tittleOfResultFromGoogle=By.xpath("//*[@id=\"rso\"]/div["+j+"]/div/div[1]/a");
		tittleOfResultFromGoogleAlter=By.xpath("//*[@id=\"rso\"]/div/div["+j+"]/div/div[1]/a");
	} 
}
