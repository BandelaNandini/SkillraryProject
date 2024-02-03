package pomPages_OR_objtRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries_OR_Utilities.WebDriverUtility;

public class CategoryListPage {
	

	// Declaration

	@FindBy(xpath = "//h1[normalize-space(text())='Category']")
	private WebElement pageHeader;

	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newButton;

	private String deletepath = "//td[text()='%s']/ancestor::tr/descendant::button[text()=' Delete']";
	// "%s" for string replacement,"%d" for integer replacement

	@FindBy(name = "delete")
	private WebElement deleteButton;

	@FindBy(xpath = "//h4[text()=' Success!']")
	private WebElement successmassage;

	// Initialization

	public CategoryListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void clickNewButton() {

		newButton.click();
	}

	public void deleteCategory(WebDriverUtility web, String categoryName) {
		web.convertpathToWebElement(deletepath, categoryName).click();
		deleteButton.click();
	}

	public String getSuccessMessage() {
		return successmassage.getText();
	}

}


