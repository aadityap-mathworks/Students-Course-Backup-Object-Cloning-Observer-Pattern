package studentCoursesBackup.myTree;

/**
 * @author Aaditya Sakharam Patil
 *
 */
public interface SubjectI {
	void notifyAllObservers(String courseIn, op opIn);
	void register(ObserverI obsIn);
	void unregister(ObserverI obsIn);	
}
