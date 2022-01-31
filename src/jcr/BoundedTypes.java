package jcr;

class Stats<T extends Number>{
	
	T[] nums;  //array obj of type T ie any type that will be past
	
	Stats(T[]	nums){
		this.nums = nums;
	}
	
//	Stats(){
//		T nums[] = {1, 2, 3, 4, 5};
//		this.nums = nums;
//	}
	
	double average()	{
		double sum = 0.0;
		
		for(int i = 0; i<nums.length; i++) {
			sum += nums[i].doubleValue(); //without doubleValue() this code wont work
		}
		
		return sum/nums.length;
	}
}
public class BoundedTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//declaring arrays
		Integer[] inums= {1, 2, 3, 4, 5};
		Stats<Integer> iob = new Stats<Integer>(inums);
		System.out.println("iob average is " + iob.average());
		
		Double[] dnums= {1.0, 2.3, 3.3, 33.4, 33.5};
		Stats<Double> dob = new Stats<Double>(dnums);
		System.out.println("iob average is " + dob.average());
		
//		//this wont compile  bec string doesnt work in numb
//		String[] str= "air", "nitro", "oxygen"};
//		Stats<String> sob = new Stats<String>(str); //bounded mismatch error
//		System.out.println("iob average is " + sob.average());
//		

	}

}
