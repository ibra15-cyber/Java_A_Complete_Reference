package jcr;

//interface to be implemented by either another class or lambda and obj::meth ref
//with a return type T which means during obj of the interface creation, 
//we can pass String, Integer, Character and another class
interface MyFunc3<T>{
	
	//func method will take an array of type T and obj of a type T
	//it returns int
	int func(T[] vals, T v);
}

//a class MyArray is created without a constructor
class MyArrayOps{
	
	//it has a static generic method
	//<String>countMatching, or <Integer>countMatching. 
	//it takes an array of return type T and an obj v of a type T
	static <T> int countMatching(T[] vals, T v) {
		int count = 0;
		
		//method <T>countMatching is iterating the passed array
		//if any index of the list == the passed 
		//increment count
		for(int i = 0; i < vals.length; i ++)
			if (vals[i] == v)
				count++;
		
		return count;
	}
}
public class ReferenceMethodWithGenerics {
	
	//static method of the main class
	//it takes and obj of interface, an array or list of the same return type
	//and an the passed obj
	//it returns MyFunc3<T> f = MyArrayOps::<Integer>countMatching 
	//thats is referencing to the method in the MyArrayOps class
	//we could use lambda here too 
	
	static <T> int myOp(MyFunc3<T>  f, T[] vals, T v) {
		return f.func(vals, v);
	}

	public static void main(String[] args) {
		
		int count;
		
//		......................................................mine.............................................................
		
		//lambda 
		//f of obj of our MyFunc3 interface uses a lambda
		//our static <T>countMatching method returns T as our functional meth to be implemented
		//hence countMatching can implement the interface
		//so our lambda takes 2 parameters just like the functional method and 
		//returns static method of class MyArrayOps
		//we use the class name and not create an obj because the method countMatching is static
		//countMatching also takes two parameters
		MyFunc3<Integer> f = (a, b) -> MyArrayOps.<Integer>countMatching(a, b);
		
		//our obj f can now invoke the functional method func();
		//define an array and val to pass
		Integer[]	intArr = {1, 2, 3, 4, 5, 6, 7, 8, 2, 2, 9};
		Integer intVal = 2;
		
		//we can assigned the invoking to int count because the invoking will return int
		count = f.func(intArr, intVal);
		System.out.println(intVal + " can be found " + count + " times");
		
		
		
//		...................................................book's..............................................................
		Integer[] vals = {	1, 2, 3, 4, 2, 3, 4, 4, 5};
		String[] strs = {	"one", "two", "three", "two"	};
		
		
		count = myOp(MyArrayOps::<Integer>countMatching, vals, 4);
		System.out.println("Vals contians " + count + " 4s");
		
		count = myOp(MyArrayOps::<String>countMatching, strs, "two");
		System.out.println("Strs contians " + count + " Twos");

	}

}
