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
	ArrayList<ObserverI> observers = new ArrayList<ObserverI>();
	
	
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
    }
	
	
	public int getbNumber() {
		return bNumber;
	}
	public void setbNumber(int bNumber) {
		this.bNumber = bNumber;
	}
	
	public void setCourses(String courseIn) {
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
	
	
	
	
	
	

}
