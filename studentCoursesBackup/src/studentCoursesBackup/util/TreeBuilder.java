package studentCoursesBackup.util;

import studentCoursesBackup.myTree.BST;
import studentCoursesBackup.myTree.Node;

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
						int key =Integer.parseInt(part[0]);
						String course = part[1];
						Node temp=  treeOrig.search(key);	
						if(temp==null)
						{
							Node nodeOrig= new Node(key);
							treeOrig.insert(key, course);
							
						}
						else
						{
							temp.setCourses(course);
						}
						
					}
					treeOrig.printNodes();
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
						
						//System.out.println(currentline);
						
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
