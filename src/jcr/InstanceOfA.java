package jcr;

//instance of shows if an object can be cast to another

class A{
	int i, j;
}
	
class B{
		int i, j;
}
	
class C extends A  {
		int k;
}

class D extends A{
	int k;
}

public class InstanceOfA {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		
		if (a instanceof A)
			System.out.println("a is instance of A");
		
		if (b instanceof B)
			System.out.println("b is instance of B");
		
		if (c instanceof C)
			System.out.println("c is instance of C");
		
		if( c instanceof A)
			System.out.println("c can be cast to A");
			
		if(a instanceof C)
			System.out.println("a can be cast to C");
		
		System.out.println("");
		
		A ob;
		ob = d; // but d extends A so ob = i, j, k
		System.out.println("ob now referes to d");
		
		System.out.println("");
		
		if(ob instanceof D)
			System.out.println("ob is instance of D");
		
		System.out.println("");
		
		ob = c;
		System.out.println("ob now refers to c");
		
		System.out.println("");
		
		//this wont work. because c can't be instanceof D
		if(ob instanceof D)
			System.out.println("ob can be cast to D");
		
		//this should print because c is an instance of A
		if (ob instanceof A)
			System.out.println("ob can be cast to A");
		
		System.out.println("");
		
		//all objects can be cast to Object
		if(a instanceof Object)
			System.out.println("a may be cast to Object");
		
		if (b instanceof Object)
			System.out.println("b may be cast to Object");
		
		if(c instanceof Object)
			System.out.println("c may be cast to Object");
		
		if(d instanceof Object)
			System.out.println("d may be cast to Object");
		
		
		
		
		
		
		
	}

}
