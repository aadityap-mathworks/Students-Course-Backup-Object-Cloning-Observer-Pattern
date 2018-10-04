package studentCoursesBackup.util;

import studentCoursesBackup.myTree.BST;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.op;

/**
 * @author Aaditya Sakharam Patil
 * references: 
 * https://www.sanfoundry.com/java-program-implement-binary-search-tree/
 * https://www.geeksforgeeks.org/
 */
public class TreeBuilder {

	//instances of BST
	BST treeOrig = new BST();
	BST backup1= new BST();
	BST backup2 = new BST();
	
	/**
	 * Builds a tree
	 * clones nodes and adds to backup trees
	 * @param input file and delete file
	 * */
	public TreeBuilder(String inputFile, String deleteFile)
	{
		FileProcessor inFile = null;
		FileProcessor delFile =null;
		try 
				{
					inFile = new FileProcessor(inputFile); 
					String currentline;
					while ((currentline = inFile.readInputLine()) != null) 
					{
						String part[] = currentline.split("[ :]+");
						String course;
						
						//to check if input format is correct and set course
						if(part.length==1)	
						{				
							course="";
						}
						else if(part.length==2)
						{
							course= part[1];
						}
						else
						{
							continue;						
						}
						int key =Integer.parseInt(part[0]);
						//search a node
						Node temp=  treeOrig.search(Integer.valueOf(key));	
						
						//if node does not exist
						if(temp==null)
						{
							//create original nde
							Node nodeOrig= new Node(Integer.valueOf(key));
							
							//clone the original nodes
							Node backupNode1 = nodeOrig.clone();
							Node backupNode2 = nodeOrig.clone();
							
							//insert nodes to respective trees 
							backup1.insert(backupNode1, course ,null,null);
							backup2.insert(backupNode2, course,null,null);
							Node obs1= backup1.search(key);
							Node obs2= backup2.search(key);
							treeOrig.insert(nodeOrig, course,obs1,obs2);
						}
						else
						{
							//if node exists then update the course
							Node temp2 = treeOrig.search(Integer.valueOf(key));
							if(!course.equals(""))
							{					
								temp2.update(course, op.INSERT);
								//notify all the observers
								temp2.notifyAllObservers(course, op.INSERT);
							}
						}
						
					}
					
					//to delete courses
					delFile = new FileProcessor(deleteFile); 
					String deleteline;
					
					while ((deleteline = delFile.readInputLine()) != null) 
					{
						String part[] = deleteline.split("[ :]+");
						//to check if input format is correct
						if(part.length!=2)	
						{				
							continue;
						}
						int key =Integer.parseInt(part[0]);
						String course = part[1];
						//search node
						Node temp=  treeOrig.search(Integer.valueOf(key));
						if(temp!=null)
						{
							temp.update(course, op.DELETE);
							temp.notifyAllObservers(course, op.DELETE);
						}
					}
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
	
	/**
	 * to get the type of tree
	 *@param type
	 *returns BST
	 */
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

	/**
	 * toString()
	 */
	@Override
	public String toString() {
		return "TreeBuilder [treeOrig=" + treeOrig + ", backup1=" + backup1 + ", backup2=" + backup2 + "]";
	}

	/**
	 * hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backup1 == null) ? 0 : backup1.hashCode());
		result = prime * result + ((backup2 == null) ? 0 : backup2.hashCode());
		result = prime * result + ((treeOrig == null) ? 0 : treeOrig.hashCode());
		return result;
	}

	/**
	 * finalize() is just a placeholder
	 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	
	
	
	
}
