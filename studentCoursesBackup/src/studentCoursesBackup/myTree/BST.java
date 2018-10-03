package studentCoursesBackup.myTree;


public class BST {

    private Node root;
    
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

     public void insert(int data, String courseIn)
     {
         root = insert(root, data, courseIn);
     }

     /* Function to insert data recursively */

     private Node insert(Node node, int data, String courseIn)
     {
         if (node == null)
         {
             node = new Node(data);
         	 node.setCourses(courseIn);
         }
         else
         {
             if (data <= node.getbNumber())
                 node.left = insert(node.left, data ,courseIn);
             else
                 node.right = insert(node.right, data , courseIn);
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
            System.out.println(r.getbNumber() +" : " +r.getAllCourses());
            inorder(r.getRight());
        }
    }
}
