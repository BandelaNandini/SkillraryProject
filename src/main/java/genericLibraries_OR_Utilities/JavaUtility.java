package genericLibraries_OR_Utilities;
/**
 * This class contains reuasble methods to perform java related operations
 * @author NANDINI
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {
	
	/**
	 * This method fetches current date and time in specified format
	 * @return
	 */
	
	public String getCurrentTime()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		return sdf.format(date);
	}

}
