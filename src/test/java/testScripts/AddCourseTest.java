package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries_OR_Utilities.BaseClass;
import genericLibraries_OR_Utilities.IConstantPath;

public class AddCourseTest extends BaseClass{
	SoftAssert soft=new SoftAssert();
	@Test
	public void addCourseTest()
	{
		home.clickCoursesTab();
		home.clickCourseListLink();
		soft.assertEquals(course.getPageHeader(), "Course List");
		course.clickNewButton();
		soft.assertEquals(newCourse.getPageHeader(), "");

	Map<String,String> map=excel.readFromExcel("Add Course");
	newCourse.setName(map.get("Name"));
	newCourse.selectCategory(web, map.get("Category"));
	newCourse.setPrice(map.get("Price"));
	newCourse.uploadPhoto(map.get("Photo"));
	newCourse.setDescription(map.get("Description"), web);
	newCourse.saveButton();
	soft.assertEquals(course.getSuccessMessage(), "Success!");

	System.out.println(course.getSuccessMessage());
	course.deleteCourse(web, map.get("Name"));
	soft.assertEquals(course.getSuccessMessage(), "Success!");

	System.out.println(course.getSuccessMessage());

	if (course.getSuccessMessage().equals("Success!"))
		excel.updatedTestStatus("Add Course", "Pass", IConstantPath.EXCEL_PATH);
	else
		excel.updatedTestStatus("Add Course", "Fail", IConstantPath.EXCEL_PATH);

	soft.assertAll();
	}
	

}
