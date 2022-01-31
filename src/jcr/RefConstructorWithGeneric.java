package jcr;

interface MyFunc5<T>{
	MyClass4<T> func(T n);
}

class MyClass4<T>{
	private T val;
	
	MyClass4(T val){
		this.val = val;
	}
	
	MyClass4(){
		this.val = null;
	}
	
	T getVal() { //should be of return type T so that every data type can be inferred
		return val;
	}
}

public class RefConstructorWithGeneric {

	public static void main(String[] args) {
		
		//creating a reference of the constructor 
		//dont forget its generic ie we can pass String, Integer, Character, and user defined Classes
		MyFunc5<Integer> funcObjRef = MyClass4::new;
		
		//invoking the functional method
		//assigning it to the return type with generic
		MyClass4<Integer> invkob = funcObjRef.func(100);
		
		System.out.println("val in the parametized constructor " + invkob.getVal());
		
//		...............................MINE..........................................	
		//referencing constructor without parameter 
		
		//wont work because the functional method will require an arguement
		//MyFunc<Integer	> construcRef = MyClass4::new;
		//MyClass4<Integer> invkob2 = construcRef.func
		
		//using diff return type in the generic 
		MyFunc5<String> funcObjRef2 = MyClass4::new;
		MyClass4<String> invkob2 = funcObjRef2.func("\"this will print\"");
		System.out.println("using string " + invkob2.getVal());
		
		
		
		

	}

}
