/**
 * were attempted in the generic version of the program, the compiler would catch
it and report an error, thus preventing a serious bug that results in a run-time
exception. The ability to create type-safe code in which type-mismatch errors
are caught at compile time is a key advantage of generics. Although using
Object references to create “generic” code has always been possible, that code
was not type safe, and its misuse could result in run-time exceptions. Generics
prevent this from occurring. In essence, through generics, run-time errors are
converted into compile-time errors. This is a major advantage.
 */


package jcr;
//its made  so so that this will work for every data type: be it string or 
//int. instead of doing it separately for int and string, generic
//will provide us with a template for that
//when int is passed the behavior is int etc
//importance of generic is that it handles type casting automatic


class NGen {
	Object ob;  //declaring
	
	NGen(Object o){ 
		ob = o; //initializing our constructor
	}
	
	//meth
	Object getob() {  //our meth of  a type T ie String, Int and whatever class
		return ob; 
	}
	
	//meth2
	void showType() { //class of the or T ob class
		System.out.println("Type of T is " + ob.getClass().getName());
	}
}
public class GenericNon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NGen iOb = new NGen(88); //from our constructor
		iOb.showType(); //method that works on generic class
		int v = (int) iOb.getob();  //invoking our method on our created obj
		System.out.println("Value: " + v);
		
		System.out.println();
		
		NGen sOb= new NGen("Generate Test");
		sOb.showType();
		String str = (String) sOb.getob();
		//String v = (String) iOb.getob(); type casting will have been used if it wasnt for the gene

		System.out.println("Value: " + str);
	}}
