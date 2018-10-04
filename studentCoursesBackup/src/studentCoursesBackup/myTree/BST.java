package studentCoursesBackup.myTree;

import studentCoursesBackup.util.Results;

public class BST {

    private Node root;
    Results res= new Results();
	public BST() {
		root=null;
	}
	
	
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

     public void insert(Node node, String courseIn, Node b1, Node b2)
     {
         root = insert(root, node, courseIn, b1,b2);
     }

     /* Function to insert data recursively */

     private Node insert(Node node, Node cnode, String courseIn, Node b1, Node b2)
     {
         if (node == null)
         {
             node = new Node(cnode.getbNumber());
         	 node.setCourses(courseIn);
         	 if(b1!=null&& b2!=null)
         	 {
         		 
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


    public void printNodes()
    {
        inorder(root);
    }

    private void inorder(Node r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            res.finalResult(r.getbNumber() +" : " +r.getCourses()+"\n");
            inorder(r.getRight());
        }
    }
}
