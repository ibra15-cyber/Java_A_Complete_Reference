package jcr;

//generic ensues type mismatch

class GenCons{
	private double val;
	
	<T extends Number> GenCons(T arg){
		val = arg.doubleValue();			
	}

	 void showval() {
		System.out.println("val: " + val);
		
	}

}
public class GenericConstructor {

	public static void main(String[] args) {
		
		GenCons test = new GenCons(100);
		GenCons test2 = new GenCons(123.5F); //float
		GenCons test3 = new GenCons(234.3); 
		
		test.showval()	;
		test2.showval()	;
		test3.showval();
		
		
		
		
	}

}
