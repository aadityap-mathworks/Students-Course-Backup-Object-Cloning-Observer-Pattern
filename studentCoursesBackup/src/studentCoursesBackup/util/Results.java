
package studentCoursesBackup.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Aaditya Sakharam Patil
 *
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	

	
	
	
	public void writeToFile() 
	{
		File out=null;
		FileWriter fw = null;
		
		try {
			 
			out= new File("/home/aadya/Desktop/aadityaSakharam_patil_assign1/coursesRegistration/src/registration_results.txt");
			fw = new FileWriter(out);
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				
				fw.close();
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		
	}
	
	/**
	 * method to display results on StdOut
	 *
	 */
	public void displayStdOut() {
		
	}
	
	
	
}
