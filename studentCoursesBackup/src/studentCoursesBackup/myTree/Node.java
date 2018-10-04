package studentCoursesBackup.myTree;

import java.util.ArrayList;

/**
 * @author Aaditya Sakharam Patil
 * references: 
 * https://www.sanfoundry.com/java-program-implement-binary-search-tree/
 * https://www.geeksforgeeks.org/
 * https://programmingmitra.blogspot.com/
 * 
 */
public class Node implements SubjectI, ObserverI, Cloneable{
	
	int bNumber;
	ArrayList <String> courses;
	Node left, right;
	ArrayList<ObserverI> observersList;
	
	/**
	 * constructor
	 *
	 */
    public Node()
    {
        left = null;
        right = null;
        bNumber = 0;
        courses =null;
        
    }
    
    /**
	 * constructor for node
	 *@param BNumber
	 */
    public Node(int bNoIn)
    {
    	left= null;
    	right = null;
    	bNumber= bNoIn;
    	courses = new ArrayList<String>();
    	observersList= new ArrayList<ObserverI>();
    }
	
    /**
	 * to get BNumber
	 *
	 */
	public int getbNumber() {
		return bNumber;
	}
	
	/**
	 * to set bNUmebr
	 *@param BNumber
	 */
	public void setbNumber(int bNumber) {
		this.bNumber = bNumber;
	}
	
	/**
	 *Sets the course
	 *@param course
	 */
	public void setCourses(String courseIn) 
	{
		if(!courses.contains(courseIn)){
		    courses.add(courseIn);
		}
	}
	
	/**
	 *to get all the course
	 */
	public ArrayList<String> getCourses()
	{
		return courses;
	}
	
	/**
	 *deletes the course
	 *@param course
	 */
	
	public void delCourses(String courseIn) {
		if(courses.contains(courseIn)){
		    courses.remove(courses.indexOf(courseIn));
	}
	}
	
	/**
	 *to get the list of observers
	 *
	 */
	public ArrayList<ObserverI> getObserversListr()
	{
		return observersList;
	}
	
	/**
	 *to get the left node of a parent node
	 *
	 */
	public Node getLeft() {
		return left;
	}
	
	/**
	 *to set the left node of a parent node
	 *
	 */
	public void setLeft(Node left) {
		this.left = left;
	}
	
	/**
	 *to get the right node of a parent node
	 *
	 */
	public Node getRight() {
		return right;
	}
	
	/**
	 *to set the right node of a parent node
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 *clones nodes
	 *sets bNumber, left, right child, courses and observers
	 */
	@Override
	public Node clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Node node= new Node(this.bNumber);
		node.left= this.left;
		node.right=this.right;
		node.courses=this.courses;
		node.observersList=this.observersList;
		return node;
	}
	

	/**
	 *to add observers to the original tree's node
	 *@param observer
	 */
	@Override
	public void register(ObserverI obsIn) 
	{
		observersList.add(obsIn);
		
	}

	/**
	 *to remove observers to the original tree's node
	 *@param Observer
	 */
	@Override
	public void unregister(ObserverI obsIn) 
	{
		if(observersList.contains(obsIn))
		{
			observersList.remove(obsIn);
		}
		
	}

	/**
	 *updates courses of a node
	 *@param course, type of operation(delete or insert)
	 */
	@Override
	public void update(String courseIn, op opIn) {
		switch(opIn)
		{
		case INSERT:
			if(!courses.contains(courseIn)){
			    courses.add(courseIn);
			    break;
			}
			break;
		case DELETE:
			if(courses.contains(courseIn)){
			    courses.remove(courses.indexOf(courseIn));
			    break;
			}
			break;
		}
		
	}

	/**
	 *notifies all the observers
	 *updates all the observers respective nodes
	 *@param course, observer
	 */
	@Override
	public void notifyAllObservers(String courseIn, op opIn) {
		if(observersList.isEmpty()==false)
		{
			for(int i =0; i<observersList.size();i++)
			{
				Node t = (Node) observersList.get(i);
				t.update(courseIn, opIn);
				//observersList.get(i).update(courseIn, opIn);
			}
		}

		
	}

	/** 
	 * hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bNumber;
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((observersList == null) ? 0 : observersList.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	/** 
	 * toString()
	 */
	@Override
	public String toString() {
		return "Node [bNumber=" + bNumber + ", courses=" + courses + ", left=" + left + ", right=" + right
				+ ", observersList=" + observersList + "]";
	}
	
	
	
	

}
