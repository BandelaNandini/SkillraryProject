package genericLibraries_OR_Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages_OR_objtRepo.AddNewCategoryPage;
import pomPages_OR_objtRepo.AddNewCoursePage;
import pomPages_OR_objtRepo.AddNewUserPage;
import pomPages_OR_objtRepo.CategoryListPage;
import pomPages_OR_objtRepo.CourseListPage;
import pomPages_OR_objtRepo.HomePage;
import pomPages_OR_objtRepo.LoginPage;
import pomPages_OR_objtRepo.UserPage;

public class BaseClass {

	protected WebDriver driver;
	protected PropertiesUtility property;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected ExcelUtility excel;

	protected LoginPage login;
	protected HomePage home;
	protected UserPage user;
	protected CourseListPage course;
	protected CategoryListPage category;
	protected AddNewUserPage newUser;
	protected AddNewCoursePage newCourse;
	protected AddNewCategoryPage newCategory;
	
	protected static WebDriver sdriver;
	protected static JavaUtility sjutil;
		

	// @BeforeSuite--->As there are no configuration settings or Database
	// connections this annotations are not used
	// @BeforeTest---->As there are no parallel executions this annotations are not
	// used
	@BeforeClass
	public void classSetup() {
		web = new WebDriverUtility();
		jutil = new JavaUtility();
		property = new PropertiesUtility();
		excel = new ExcelUtility();

		property.propertiesInit(IConstantPath.PROPERTIES_FILE_PATH);

		driver = web.launchBrowser(property.readFromProperties("browser"));
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
		sdriver=driver;
        sjutil=jutil;
	}

	@BeforeMethod
	public void methodSetup() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		user = new UserPage(driver);
		course = new CourseListPage(driver);
		category = new CategoryListPage(driver);
		newUser = new AddNewUserPage(driver);
		newCourse = new AddNewCoursePage(driver);
		newCategory = new AddNewCategoryPage(driver);

		excel.excelInit(IConstantPath.EXCEL_PATH, "sheet1");

		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(login.getpageheader(), "Login");
		login.loginToApp(property.readFromProperties("username"), property.readFromProperties("password"));
		Assert.assertEquals(home.getpageheader(), "Home");
        
	}

	@AfterMethod
	public void methodTearDown() {
		excel.closeExcel();
		home.signoutOfApplication();
	}

	@AfterClass
	public void classTearDown() {
		web.quitAllWindows();
	}
	// @AfterTest
	// @AfterSuite

}
