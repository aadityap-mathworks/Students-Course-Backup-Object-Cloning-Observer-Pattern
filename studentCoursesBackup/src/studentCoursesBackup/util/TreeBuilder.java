package studentCoursesBackup.util;

import studentCoursesBackup.myTree.BST;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.op;

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
						Node temp=  treeOrig.search(Integer.valueOf(key));	
						if(temp==null)
						{
							Node nodeOrig= new Node(Integer.valueOf(key));
							Node backupNode1 = nodeOrig.clone();
							Node backupNode2 = nodeOrig.clone();
//							nodeOrig.register(backupNode1);
//							nodeOrig.register(backupNode2);
							backup1.insert(backupNode1, course ,null,null);
							backup2.insert(backupNode2, course,null,null);
							Node obs1= backup1.search(key);
							Node obs2= backup2.search(key);
							
							treeOrig.insert(nodeOrig, course,obs1,obs2);
						}
						else
						{
							Node temp2 = treeOrig.search(Integer.valueOf(key));
							temp2.update(course, op.INSERT);
							temp2.notifyAllObservers(course, op.INSERT);
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
						Node temp=  treeOrig.search(Integer.valueOf(key));
						if(temp!=null)
						{
							temp.update(course, op.DELETE);
							temp.notifyAllObservers(course, op.DELETE);
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
