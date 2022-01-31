package jcr;
//implementing a simple class factory using  a constructor reference

//an interface that takes two generic types
interface MyFunc6<R, T>{
	//a func method that the generic type of one type and return type of another
	R func(T n);
}

class MyClass5<T>{
	private T val;
	
	MyClass5(T val){
		this.val = val;
	}
	
	MyClass5()	{
		this.val = null;
	}
	
	T getVal() {
		return val;
	}
}
//........................................................end of our first generic class.......................................

class MyClass6{
	String str;
	
	MyClass6(String str)	{
		this.str = str;
	}
	
	//default constructor
	MyClass6(){
		this.str = null;
	}
	
	String getVal()	{
		return str;
	}	
}
//.......................................................................	end of another class

public class RefConstructorRealImplementation {
	 
	//a static generic method 
	//takes a functional interface obj which is used during lambda and reference creation
	//and an obj of a return type to passed in our functional method
	//normally a lambda for this functional interface might look this
	//MyFunc6<String, Integer> anonyobj = 
	//(str) -> <String, Integer>myClassFactory(cons, v);
	//the return type of the above is R, defined as String same as our functional method hence will work
	//f.func(str);
	
	
	//to use reference method: 
	//MyFunc6<String, Integer> obj = ClassName::<String, Integer>myClassFactory(cons, v
	//but we can't have class name  because its static method to the main class
	//f.func(str);
	
	
	//to pass generic type into a method pass it infront of teh method
	

	static <R, T> R myClassFactory(MyFunc6<R, T> f, T v) {
		return f.func(v);
	}

	public static void main(String[] args) {
		
		//f is a reference assignment to the constructor
		//of return type our interface 
		//but our interface takes 2 return types:
			//1. MyClass5<>	generic type 
			//2. and Double. As defined by our functional method
		
		MyFunc6<MyClass5<Double>, Double> f = MyClass5<Double>::new;
		
		//Question: at what time will our constructor know which is referenced?
		//Answer that has been encapsulated in our method below
		//return f.func(v)
		//taking an argument points to the constructor 
		
		//invoking our method myClassFactory. which takes our interface type obj and a double
		MyClass5<Double> mc = myClassFactory(f, 100.1);
		
		//then the added step when we reference a constructor as opposed to method reference
		//we invoke getVal()
		System.out.println("val in mc is : " + mc.getVal());
		
		
		//for the non generic class
		MyFunc6<MyClass6, String> myClassCons2 = MyClass6::new;
		MyClass6 mc2 = myClassFactory (myClassCons2, "Lambda");
		System.out.println("str in mc2 is " + mc2.getVal());

	}

}
