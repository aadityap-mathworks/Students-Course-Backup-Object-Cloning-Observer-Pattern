package studentCoursesBackup.myTree;

import java.util.ArrayList;

/**
 * @author Aaditya Sakharam Patil
 *
 */
public class Node implements SubjectI, ObserverI, Cloneable{
	
	int bNumber;
	ArrayList <String> courses;
	Node left, right;
	ArrayList<ObserverI> observersList;
	
    public Node()
    {
        left = null;
        right = null;
        bNumber = 0;
        courses =null;
        
    }
    
    public Node(int bNoIn)
    {
    	left= null;
    	right = null;
    	bNumber= bNoIn;
    	courses = new ArrayList<String>();
    	observersList= new ArrayList<ObserverI>();
    }
	
	
	public int getbNumber() {
		return bNumber;
	}
	public void setbNumber(int bNumber) {
		this.bNumber = bNumber;
	}
	
	public void setCourses(String courseIn) 
	{
		if(!courses.contains(courseIn)){
		    courses.add(courseIn);
		}
	}
	
	public ArrayList<String> getCourses()
	{
		return courses;
	}
	
	public void delCourses(String courseIn) {
		if(courses.contains(courseIn)){
		    courses.remove(courses.indexOf(courseIn));
	}
	}
	
	public ArrayList<ObserverI> getObserversListr()
	{
		return observersList;
	}
	
	
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}

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
	

	@Override
	public void register(ObserverI obsIn) 
	{
		observersList.add(obsIn);
		
	}

	@Override
	public void unregister(ObserverI obsIn) 
	{
		if(observersList.contains(obsIn))
		{
			observersList.remove(obsIn);
		}
		
	}

	@Override
	public void update(String courseIn, op opIn) {
		switch(opIn)
		{
		case INSERT:
			if(!courses.contains(courseIn)){
			    courses.add(courseIn);
			    break;
			}
		case DELETE:
			if(courses.contains(courseIn)){
			    courses.remove(courses.indexOf(courseIn));
			    break;
			}
		}
		
	}

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
	
	
	
	
	
	

}
