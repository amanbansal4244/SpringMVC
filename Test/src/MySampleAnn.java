
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
 
@Retention(RetentionPolicy.CLASS)
public @interface MySampleAnn {
 
    String name();
    String desc();
}
 
class MyAnnTest{
     
    @MySampleAnn(desc = "", name = "")
    public void myTestMethod(){
        //method implementation
    }
}