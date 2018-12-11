import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
 
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotation{
     
    String keyAman() default "site";
    String valueAman() default "amanbansal.com";
}
 
@MyAnnotation(keyAman="google", valueAman="www.google.com")
public class MyAnnotationTest {
 
}

class MainAnnotation{
	 public static void main(String a[]){
         
	        MyAnnotationTest mat = new MyAnnotationTest();
	        Class c = mat.getClass(); 
	        Annotation an = c.getAnnotation(MyAnnotation.class); 
	        
	        MyAnnotation myAnnotation = (MyAnnotation) an; 
	        System.out.println(myAnnotation.keyAman());
	        System.out.println(myAnnotation.valueAman());
	        
	        
	    }
}