package jcr;
//its made  so so that this will work for every data type: be it string or 
//int. instead of doing it separately for int and string, generic
//will provide us with a template for that
//when int is passed the behavior is int etc
//importance of generic is that it handles type casting automatic


class Gen<T>{
	T ob;  //declaring
	
	Gen(T o){ 
		ob = o; //initializing our constructor
	}
	
	//meth
	T getob() {  //our meth of  a type T ie String, Int and whatever class
		return ob; 
	}
	
	//meth2
	void showType() { //class of the or T ob class
		System.out.println("Type of T is " + ob.getClass().getName());
	}
}
public class GenericDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gen<Integer> iOb = new Gen<Integer>(88); //from our constructor
		iOb.showType(); //method that works on generic class
		int v = iOb.getob();  //invoking our method on our created obj
		//int v = (Integer) iOb.getob(); type casting will have been used if it wasnt for the gene
		System.out.println("Value: " + v);
		
		System.out.println();
		
		Gen<String> sOb= new Gen<String>("Generate Test");
		sOb.showType();
		String str = sOb.getob();
		//String v = (String) iOb.getob(); type casting will have been used if it wasnt for the gene

		System.out.println("Value: " + str);
	}}
