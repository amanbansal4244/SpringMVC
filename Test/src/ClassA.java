import java.util.ArrayList;

@FunctionalInterface
interface A{
	public void m1();
	//public void m2();
	
}
class ClassA {

	public void showDataFromOldDataBase(){
		System.out.println(" In Class A:");
	}
}

class ClassB extends ClassA{
	
	@Deprecated
	public void method1(){
		
	}
	
	@Override
	public void showDataFromOldDataBase(){
		
		@SuppressWarnings("rawtypes")
		ArrayList alObj = new ArrayList<>();
		
		System.out.println(" In Class B:");
	}
}

 class Main{
	public static void main(String[] args) {
		ClassB obj = new ClassB();
		obj.showDataFromOldDataBase();
		obj.method1();
	}
}
