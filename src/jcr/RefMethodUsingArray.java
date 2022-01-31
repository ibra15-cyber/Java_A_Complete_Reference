package jcr;

import java.util.ArrayList;
import java.util.Collections;

//a class MyClass with a constructor
// a method to return val
class MyClass1{
	private int val;
	
	MyClass1(int val){
		this.val = val;
	}
	
	int getVal() {
		return val;
	}
}

public class RefMethodUsingArray {
	
	//static method in main
	//can be called without any obj definition
	//compareMC takes a obj a and b of type MyClass
	
	static int compareMC(MyClass1 a, MyClass1 b) {
		
		//returns outcome of the values passed into the objs during creation
		return a.getVal() - b.getVal();
	}

	public static void main(String[] args) {
//		................................................mine......................................................................
		MyClass1 a = new MyClass1(2);
		MyClass1 b = new MyClass1(5);
		
		int compare = compareMC(a, b);
		System.out.println("The result of  subrating " + a.getVal() + " and " + b.getVal() + " is " + compare);
		
		
//		...............................book's....................................................
		//arraylist taking a return type myclass
		ArrayList<MyClass1> al = new ArrayList<>();
		
		//we add to our list class type
		al.add(new MyClass1(1));
		al.add(new MyClass1(4));
		al.add(new MyClass1(2));
		al.add(new MyClass1(9));
		al.add(new MyClass1(3));
		al.add(new MyClass1(7));
		
		//collections.max takes an array and method
		//here we are using our list al and referencing compareMC method 
		//using the class Name instead of object because compareMc is static method
		//collections.max return the max of the list al but referenced compareMC which i dont about
		//get the value of that maximum
		MyClass1 maxValObj = Collections.max(al, RefMethodUsingArray::compareMC);
		
		System.out.println("Maximun value is: " + maxValObj.getVal());
		
		

	}

}
