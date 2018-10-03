package studentCoursesBackup.util;

import studentCoursesBackup.myTree.BST;

/**
 * @author Aaditya Sakharam Patil
 *
 */
public class TreeBuilder {

	public TreeBuilder(String fileName, int operation)
	{
		FileProcessor inFile = null;
		FileProcessor delFile =null;
		switch (operation)
		{
			case 1:
				try {
					BST treeOrig = new BST();
					BST backup1= new BST();
					BST backup2 = new BST();
					inFile = new FileProcessor(fileName); 
					String currentline;
					while ((currentline = inFile.readLine()) != null) 
					{
						String part[] = currentline.split("[ ,:;-]+");
						System.out.println(currentline);
						
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				    System.exit(1);
				}
				finally {
					inFile.close();
				}
			case 2:
				try {
					delFile = new FileProcessor(fileName); 
					String currentline;
					System.out.println("Delete File");
					while ((currentline = delFile.readLine()) != null) 
					{
						
						System.out.println(currentline);
						
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				    System.exit(1);
				}
				finally {
					delFile.close();
				}
		}
	}
	
	
}
