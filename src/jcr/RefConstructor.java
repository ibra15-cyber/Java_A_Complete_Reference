package jcr;

interface MyFunc4{
	MyClass3 func(int n);
}

class MyClass3{
	private int val;
	
	//first constructor
	MyClass3(int val){
		this.val = val;
	}
	
	//another constructor
	MyClass3(){
		this.val = 0;
	}
	
	//instance method
	int getVal() {
		return val;
	}
	
}

public class RefConstructor {

	public static void main(String[] args) {
		
//		................................................mine.................................................
		//testing lambda expressions
		//MyClass3 clob = new MyClass3(3);
		//this wont run because getVal return int but the functional method returns MyClass3 type
		//MyFunc4  obj = (a) ->clob.getVal();
		
		
//		...........................................book's.........................................................................
		//obj ref the constructor 
		//will normally be 
		//MyClass3 obj = new MyClass3();
		//MyClass3 obj = new  MyClass3(1); parametized constructor
		//but here we are making a constructor that looks like our functional method
		//already our class or constructor has teh same return type as our func method
		//hence can use the reference, lambda and class implementation
		//so our obj as usual will be of a type our interface 
		//and new MyClass3() is turned as below
		//so instead of 
		//MyFunc4 obj = new MyClass3(1);
		//we got this
		
		//thus creating an reference of MyClass constructor 
		MyFunc4 objOfInterface= MyClass3::new;
		
		//and since func method takes parameter 
		//hence the invoking method is below
		//func method takes para hence our definition too
		//and of course the return type of our functional method is the same class
		
		//thus invoking the functional method on our reference constructor
		MyClass3 objOfClass =objOfInterface.func(100);
		
		System.out.println("val in mc is " + objOfClass.getVal());
		
		
		
		//obj referencing method using constructor 1
		MyClass3 cob = new MyClass3(34);
		
		//this wont work because the return type of getVal is int but our functional method return MyClass type
		// reference too wouldn't work for the same reason lambda isn't working
		//MyFunc obj = (n)  ->  cob.getVal();
		//MyFunc obj2 = cob::getVal();
		
		

	}

}
