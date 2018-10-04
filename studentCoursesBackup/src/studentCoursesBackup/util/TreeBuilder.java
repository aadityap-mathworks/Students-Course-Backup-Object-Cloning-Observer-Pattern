package studentCoursesBackup.util;

import studentCoursesBackup.myTree.BST;
import studentCoursesBackup.myTree.Node;

/**
 * @author Aaditya Sakharam Patil
 *
 */
public class TreeBuilder {

	BST treeOrig = new BST();
	BST backup1= new BST();
	BST backup2 = new BST();
	public TreeBuilder(String inputFile, String deleteFile)
	{
		FileProcessor inFile = null;
		FileProcessor delFile =null;
		try 
				{
					inFile = new FileProcessor(inputFile); 
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
					//treeOrig.printNodes();
					
					
					delFile = new FileProcessor(deleteFile); 
					String deleteline;
					
					while ((deleteline = delFile.readLine()) != null) 
					{
						String part[] = deleteline.split("[ ,:;-]+");
						int key =Integer.parseInt(part[0]);
						String course = part[1];
						Node temp=  treeOrig.search(key);
						if(temp!=null)
						{
							temp.delCourses(course);
						}
					}
//					System.out.println("\n After Deletion:");
//					treeOrig.printNodes();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				    System.exit(1);
				}
				finally {
					inFile.close();
					delFile.close();
				}
	
	}
	
	public BST tree(String type)
	{
		switch (type)
		{
		case "orig":
			return treeOrig;
			
		case "backup1":
			return backup1;
			
		case "backup2":
			return backup2;
			
		default:
			break;
		}
		return null;
	}
	
	
}
