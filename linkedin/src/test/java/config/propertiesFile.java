package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
  
public class propertiesFile{
	
	public static void readPropertiesFile() {
		Properties prop=new Properties();
		InputStream input;
		try {
			input = new FileInputStream("src\\test\\java\\config\\config.properties"); 
			prop.load(input);  
			linkedin.BaseTest.driverPath=prop.getProperty("driverPath");
			linkedin.BaseTest.url=prop.getProperty("url");
			linkedin.searchTests.filtersPath=prop.getProperty("filtersPath");
			linkedin.searchTests.searchDataPath=prop.getProperty("searchDataPath");
			
			linkedin.signinPage.email=prop.getProperty("email"); 
			linkedin.signinPage.password=prop.getProperty("password");
			linkedin.linkedinSearchPage.searchDataOutput=prop.getProperty("searchDataOutput"); 
			
			
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
	
	}

}
