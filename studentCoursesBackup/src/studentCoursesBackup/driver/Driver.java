package studentCoursesBackup.driver;

import java.io.File;

/**
 * @author Aaditya Sakharam Patil
 *
 */
public class Driver {
	/**
	 * Main method
	 * @param Commandline args
	 * @return none
	 */
	public static void main(String[] args) {
		try {
			
			/**
			 * As the build.xml specifies the arguments as argX, in case the
			 * argument value is not given java takes the default value specified in
			 * build.xml. To avoid that, below condition is used
			 */
			if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || args[3].equals("${arg3}") || args[4].equals("${arg4}" )) 
			{
				System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
				System.exit(0);
			}
			
			/**
			 *argument validation
			 */
			File file1 = new File(args[0]);
			if (!file1.exists()) 
			{
				System.out.println("Input file does not exist.");
				System.exit(1);
			}
			File file2 = new File(args[1]);
			if (!file2.exists()) 
			{
				System.out.println("delete file does not exist.");
				System.exit(1);
			}
			
			
			
			
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			
		}
	
	}

	@Override
	public String toString() {
		return "Driver [toString()=" + super.toString() + "]";
	}
}
