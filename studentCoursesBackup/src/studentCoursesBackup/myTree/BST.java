package studentCoursesBackup.myTree;

import studentCoursesBackup.util.Results;

/**
 * @author Aaditya Sakharam Patil
 * to create BST
 * Also implements search and insert functionality
 * prints nodes
 * 
 * references: 
 * https://www.sanfoundry.com/java-program-implement-binary-search-tree/
 * https://www.geeksforgeeks.org/
 * 
 */
 

public class BST {

    private Node root;
    
    Results res= new Results();
	
    public BST() {
		root=null;
	}
	

	/**
	 * searches for Node by traversing
	 * @param bNumber
	 * returns a Node if found else returns null
	 *
	 */
	 public Node search(int bNumIn)
	 {
			if(root==null){
				return null;
			}
			Node temp= root;
			int rval=temp.getbNumber();
			while(temp!=null && rval!=bNumIn)
			{
				rval=temp.getbNumber();
				if (bNumIn < rval)
					temp = temp.getLeft();
				else if (bNumIn > rval)
					temp = temp.getRight();
				if(temp==null)
				{
					return null;
				}
			}
			return temp;
			
	 }


	/**
	 * To insert node and set the root
	 *
	 */
     public void insert(Node node, String courseIn, Node b1, Node b2)
     {
         root = insert(root, node, courseIn, b1,b2);
     }

     /** 
      * Function to insert data recursively 
      * @param node, backupNdes, course
      * returns node
      */
     private Node insert(Node node, Node cnode, String courseIn, Node b1, Node b2)
     {
         if (node == null)
         {
             node = new Node(cnode.getbNumber());
         	 node.setCourses(courseIn);
         	 if(b1!=null&& b2!=null)
         	 {
         		 //setting observers
         		 node.register(b1);
         		 node.register(b2);
         	 }
         }
         else
         {
             if (cnode.getbNumber() <= node.getbNumber())
                 node.left = insert(node.left, cnode, courseIn,b1,b2);
             else
                 node.right = insert(node.right, cnode, courseIn,b1,b2);
         }
         return node;
     }


	/**
	 * to print nodes in order
	 *
	 */
    public void printNodes()
    {
        inorder(root);
    }
    
    /**
	 * to print nodes
	 * @param node
	 * stores results
	 */
    private void inorder(Node r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            res.finalResult(r.getbNumber() +" : " +r.getCourses()+"\n");
            inorder(r.getRight());
        }
    }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((res == null) ? 0 : res.hashCode());
		result = prime * result + ((root == null) ? 0 : root.hashCode());
		return result;
	}


	/**
	 * toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}


	/** 
	 * finalize() method
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}


}
