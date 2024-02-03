package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries_OR_Utilities.BaseClass;
import genericLibraries_OR_Utilities.IConstantPath;

public class AddUserTest extends BaseClass{
	SoftAssert soft=new SoftAssert();
	@Test
	public void addUserTest()
	{
		home.clickUserTab();
		soft.assertEquals(user.getPageHeader(), "\r\n"
				+ "        Users\r\n"
				+ "      ");

		user.clickNewButton();
		soft.assertEquals(newUser.getPageHeader(), "Add New User");

	Map<String,String> map=excel.readFromExcel("Add User");
	
	
	newUser.setEmail(map.get("Email"));
	newUser.setPassword(map.get("Password"));
	newUser.setFirstname(map.get("Firstname"));
	newUser.setLastname(map.get("Lastname"));
	newUser.setContactInfo(map.get("Contact info"));
	newUser.setAddress(map.get("Address"));
	newUser.setPhotoUpload(map.get("Photo"));
	newUser.saveButton();
	soft.assertEquals(user.getSuccessMessage(), "Success!");
	if (user.getSuccessMessage().equals("Success!"))
		excel.updatedTestStatus("Add User", "Pass", IConstantPath.EXCEL_PATH);
	else
		excel.updatedTestStatus("Add User", "Fail", IConstantPath.EXCEL_PATH);

	soft.assertAll();

	}
	

}
