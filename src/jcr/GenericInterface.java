package jcr;

//interface and method define the generic before
//class after

interface MinMax<T extends Comparable<T>>{
	T min();
	T max();
}

//implement the interface
class MyClass2<T extends Comparable<T>> implements MinMax<T>{
	T[] vals;
	
	MyClass2(T[] o ){
		vals = o;
	}
	
	//Return the minimum val in vals.
	public T min() {
		T v = vals[0];
		
		for (int i = 1; i< vals.length; i++ ) {
			if (vals [i].compareTo(v) < 0) {
				v = vals[i];
			}	
		}	
		return v;
	}
	
	//Return the maximum val in vals.
		public T max() {
			T v = vals[0];
			
			for (int i = 1; i< vals.length; i++ ) {
				if (vals [i].compareTo(v) > 0) {
					v = vals[i];
				}
			}	
			return v;
		}
	
	
}

public class GenericInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer inums[]	= {3, 6,2, 8, 6};
		Character chs[] = {'b', 'r', 'p', 'w'};
		
		MyClass2<Integer> iob = new MyClass2<Integer>(inums);
		MyClass2<Character> cob = new MyClass2<Character>(chs);
		
		System.out.println("Max value in chs:  " + cob.max());
		System.out.println("Min value in chs: " + cob.min());
		
		System.out.println("Max value in Int:  " + iob.max());
		System.out.println("Min value in Int: " + iob.min());
	}

}
