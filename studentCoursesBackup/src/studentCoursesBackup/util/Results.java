
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
	String outputFile;
	
	public String getOutputFile() {
		return outputFile;
	}


	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}
 
	public Results()
	{
		
	}
	public Results(String fileName)
	{
		setOutputFile(fileName);
	}

	/**
	 * method to store results
	 *
	 */
	public void finalResult(String res)
	{
		finalList.add(res);
	}
	
	
	public void writeToFile() 
	{
		File out=null;
		FileWriter fw = null;
		
		try {
			 
			out= new File(outputFile);
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
	public void displayStdOut(String s) 
	{
		System.out.println(s+finalList);
	}
	
	public void clearResult()
	{
		finalList.clear();
	}
	
}
