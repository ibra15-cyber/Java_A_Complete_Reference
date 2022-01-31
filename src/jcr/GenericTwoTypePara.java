package jcr;
//could be both of the same type of diff Gen<V, T> 
class TwoGen<T, V>{
	T ob1;
	V ob2;
	
	TwoGen(T ob1, V ob2){
		this.ob1 = ob1;
		this.ob2 = ob2;
	}
	
	//meth1
	void showType() {
		System.out.println("Type of T is " + 
				ob1.getClass().getName());
		System.out.println("Type of V is " + 
				ob2.getClass().getName());
	}
	
	//meth2
	T getob1() {
		return ob1;
	}
	V getob2() {
		return ob2;
	}
}

public class GenericTwoTypePara {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TwoGen<Integer, String> Ob = new TwoGen<Integer, String>(88, "test series");
		
		Ob.showType();
		
		int i = Ob.getob1();
		String s = Ob.getob2();
		System.out.println("obj1 is : " + i + " , obj2 is  " + s);
	}

}
