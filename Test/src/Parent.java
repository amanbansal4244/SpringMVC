import java.io.IOException;

public class Parent {
	
	void msg() {
		System.out.println(" In super class msg");
	}
}

class Derived extends Parent{
	
	void msg() throws ArithmeticException{
		System.out.println(" In derived class msg");
	}
	
	public static void main(String[] args) {
		Parent parent = new Derived();
		try{
			parent.msg();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
