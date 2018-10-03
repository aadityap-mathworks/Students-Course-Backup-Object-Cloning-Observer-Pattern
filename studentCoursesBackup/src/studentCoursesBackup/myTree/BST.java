package studentCoursesBackup.myTree;

public class BST {

    private Node root;
    
	public BST() {
		root=null;
	}
	
	
    private Node search(Node node, int val)
    {
    	int rval = node.getbNumber();
        while ((node != null)&& (rval!=val))
        {
        	rval = node.getbNumber();
            if (val < rval)
                node = node.getLeft();
            else if (val > rval)
                node = node.getRight();
            else
            {
                return null;
            }

        }
        return node;
    }
	
    
    public void insert(int data)
    {
        root = insert(root, data);
    }

    /* Function to insert data recursively */
    private Node insert(Node node, int data)
    {
        if (node == null)
            node = new Node(data);
        else
        {
            if (data <= node.getbNumber())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }
  
    

}
