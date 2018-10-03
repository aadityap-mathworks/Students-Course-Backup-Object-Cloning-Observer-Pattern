package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Aaditya Sakharam Patil
 *
 */

public class FileProcessor 
{
	private BufferedReader inputReader = null;
	
	public FileProcessor(String filename)
	{
		try {
			File input = new File(filename);
			inputReader = new BufferedReader(new FileReader(input));
		}
		catch(IOException e){
		    e.printStackTrace();
		    System.exit(1);
		}
		finally{ 
		}
	}
	
	
	 public String readLine() 
	 {
			try{
				String currentline;
				while ((currentline = inputReader.readLine()) != null) 
				{
					System.out.println(currentline);
					return currentline;
				}
			} catch (IOException ex)
	        {
	            System.out.println("Error occureed while reading the file '");
	            ex.printStackTrace();
	            System.exit(0);
	
	        }	
			finally {
				    
			}
			return null;
		}
	
	 
	 public void close(){
	    	try{
		    inputReader.close();
	    	}catch(IOException e){
		    e.printStackTrace();
	    	}
	    	finally {}
	}
	
}
