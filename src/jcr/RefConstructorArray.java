package jcr;

interface MyArrayCreator<T>{
	T func(int n);
}

class MyClass8{
	private int val;
	
	//first constructor
	MyClass8(int val){
		this.val = val;
	}
	
	//another constructor
	MyClass8(){
		this.val = 0;
	}
	
	//instance method
	int getVal() {
		return val;
	}
	
}

public class RefConstructorArray {

	public static void main(String[] args) {
		
////		................................................mine.................................................
//		//testing lambda expressions
//		//MyClass8 clob = new MyClass8(3);
//		//this wont run because getVal return int but the functional method returns MyClass8 type
//		//MyFunc8  obj = (a) ->clob.getVal();
//		
//		
////		...........................................book's.........................................................................
//		//obj ref the constructor 
//		//will normally be 
//		//MyClass8 obj = new MyClass8();
//		//MyClass8 obj = new  MyClass8(1); parametized constructor
//		//but here we are making a constructor that looks like our functional method
//		//already our class or constructor has teh same return type as our func method
//		//hence can use the reference, lambda and class implementation
//		//so our obj as usual will be of a type our interface 
//		//and new MyClass8() is turned as below
//		//so instead of 
//		//MyFunc8 obj = new MyClass8(1);
//		//we got this
//		
//		//thus creating an reference of MyClass constructor 
//		MyFunc8 objOfInterface= MyClass8::new;
//		
//		//and since func method takes parameter 
//		//hence the invoking method is below
//		//func method takes para hence our definition too
//		//and of course the return type of our functional method is the same class
//		
//		//thus invoking the functional method on our reference constructor
//		MyClass8 objOfClass =objOfInterface.func(100);
//		
//		System.out.println("val in mc is " + objOfClass.getVal());
//		
//		
//		
//		//obj referencing method using constructor 1
//		MyClass8 cob = new MyClass8(34);
//		
//		//this wont work because the return type of getVal is int but our functional method return MyClass type
//		// reference too wouldn't work for the same reason lambda isn't working
//		//MyFunc obj = (n)  ->  cob.getVal();
//		//MyFunc obj2 = cob::getVal();
//		
//		
		//we are trying to make a constructor of our array of a class just like array of int, string or character:
		//our functional type take takes a generic type which we are passing as an array of our class
		//MyClass8[	] just like int[]	 is making an array of class
		
		//obj mcArrayCons of a type our interface is referenced as our constructor
		//smart: our generic type is MyClass[] so we passed that as our generic type
		
		MyArrayCreator<MyClass8[]> mcArrayCons = MyClass8[]::new;
		
		//we invoke functional method on the constructor as the 2nd step
		//not forgetting our return type 
		MyClass8[]	a = mcArrayCons.func(2);
		
		//third step to get our values is to invoke a method of the class
//		a[0] = new MyClass8(1);
//		a[1] = new MyClass8(2);
//		for (MyClass8 b : a){
//			for(int c : b)
//			System.out.println(c.valueOf());
//	
//		the above will not run; error: cant iterate over an array
		System.out.println("The content of our class array  are : " + a.length);
		
		
		//question why is it returning only the length and not the values?
		
		

	}

}
