package pomPages_OR_objtRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Declaration

	@FindBy(xpath="//h3[text()='Login']")
	private WebElement pageheader;
	
	@FindBy(id="email")
	private WebElement usernameTF;
	
	@FindBy(name="password")
	private WebElement passwordTF;

	@FindBy(name="login")
	private WebElement loginbtn;
	
	//Initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	 //Utilization
	
	public String getpageheader()
	{
		return pageheader.getText();
	}
	public void loginToApp(String username,String password)
	{
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginbtn.click();
	}
}
