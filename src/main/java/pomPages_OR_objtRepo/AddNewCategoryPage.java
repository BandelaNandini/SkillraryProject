package pomPages_OR_objtRepo;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class AddNewCategoryPage {

		// Declaration

		@FindBy(xpath = "//b[text()='Add New Category']")
		private WebElement pageHeader;

		@FindBy(id = "name")
		private WebElement nameTF;

		@FindBy(xpath = "//button[@name='add']")
		private WebElement saveButton;

		// Initialization

		public AddNewCategoryPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		// Utilization

		public String getPageHeader() {
			return pageHeader.getText();
		}

		public void setName(String categoryname) {
			nameTF.sendKeys(categoryname);
		}
		public void saveButton() {

			saveButton.click();
		}

}
