public class MyDeprecatedExmp {
     
    @Deprecated
    public void showDeprecatedMessage(){
        System.out.println("This method is marked as deprecated");
    }
     
    public static void main(String a[]){
         
        MyDeprecatedExmp mde = new MyDeprecatedExmp();
        mde.showDeprecatedMessage();
    }
}