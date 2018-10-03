
package studentCoursesBackup.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Aaditya Sakharam Patil
 *
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
public static ArrayList<String> finalList = new ArrayList<String>();
	
	/**
	 * method to store results
	 *
	 */
	public void finalResult(String res)
	{
		finalList.add(res);
	}
	
	
	public void writeToFile(String outFile) 
	{
		File out=null;
		FileWriter fw = null;
		
		try {
			 
			out= new File(outFile);
			fw = new FileWriter(out);
			fw.write(finalList+"\n");
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
	public void displayStdOut() 
	{
		System.out.println(finalList);
	}
	
}
