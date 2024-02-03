package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries_OR_Utilities.BaseClass;
import genericLibraries_OR_Utilities.IConstantPath;

public class AddCategoryTest extends BaseClass {

	SoftAssert soft = new SoftAssert();

	@Test
	public void addCategoryTest() {
		home.clickCoursesTab();
		home.clickCategoryLink();
		soft.assertEquals(category.getPageHeader(), "Category");
		category.clickNewButton();
		soft.assertEquals(newCategory.getPageHeader(), "");
		Map<String, String> map = excel.readFromExcel("Add Category");
		newCategory.setName(map.get("Name"));
		newCourse.saveButton();
		soft.assertEquals(category.getSuccessMessage(), "Success!");
		System.out.println(category.getSuccessMessage());
		category.deleteCategory(web, map.get("Name"));
		soft.assertEquals(category.getSuccessMessage(), "Success!");
		System.out.println(course.getSuccessMessage());
		if (category.getSuccessMessage().equals("Success!"))
			excel.updatedTestStatus("Add Category", "Pass", IConstantPath.EXCEL_PATH);
		else
			excel.updatedTestStatus("Add Category", "Fail", IConstantPath.EXCEL_PATH);

		soft.assertAll();
	}
}
