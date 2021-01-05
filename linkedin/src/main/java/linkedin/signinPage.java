package linkedin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;  
public class signinPage extends BasePage {
	
	public static String email;
	public static String password;
	
	public signinPage(WebDriver driver) throws IOException {
		super(driver); 
	}
  
	public void signin() {
		setFieldText(Locators.email,email); 
		setFieldText(Locators.password,password);
		clickElemet(Locators.signinButton);  
	}
}
