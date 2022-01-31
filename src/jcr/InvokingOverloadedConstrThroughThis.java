package jcr;
class MyClass{
	int a;
	int b;
	
	MyClass(int i, int j){
		 a = i;
		 b = j;
	}
	
	MyClass(int i){
		a = i;
		b = i;
	}
	
	MyClass(){
		a = 0;
		b = 0;
	}
}

public class InvokingOverloadedConstrThroughThis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testing my objects
		MyClass cons1 = new MyClass(2, 4);
		System.out.println("value of a is " + cons1.a + " value of b is " + cons1.b);
		
		MyClass cons2= new MyClass(3);
		System.out.println("value of a is " + cons2.a+ " value of b is " + cons2.b);
		
		MyClass cons3 = new MyClass();
		System.out.println("value of a is " + cons3.a + " value of b is " + cons3.b);
	}

}
