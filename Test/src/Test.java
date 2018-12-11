import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws NoSuchFieldException {
		Student s = new Student("S-111", "Aman", "Pune");
		s.getStudentDetails();
		//Now I want to access meta data of Student Object i.e. Course details
		Class c = s.getClass();
		
		//We need to get field for field level annotation
		Field field = c.getDeclaredField("sid");
		Annotation an = field.getAnnotation(Course.class);
		Course course = (Course)an; 
		System.out.println("Student Course Details :");
		System.out.println("-------------------------");
		System.out.println("Course ID : " + course.cid());
		System.out.println("Course Name :" + course.cname());
		System.out.println("Course Cost :" + course.ccost());
		
	}
}
