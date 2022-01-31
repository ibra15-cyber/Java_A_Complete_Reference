package jcr;

class Stats2<T extends Number>{
	
	T[] nums;  //array obj of type T ie any type that will be past
	
	Stats2(T[]	nums){ //passing an array into constructor
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
	
	//determine average 
	
	boolean sameAvg(Stats2<?> ob) {
		if(average() == ob.average()) {
			return true;
		}
		else {
			return false;
		}
	}
}
public class WildCardDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//declaring arrays
		Integer[] inums= {1, 2, 3, 4, 5};
		Stats2<Integer> iob = new Stats2<Integer>(inums);
		System.out.println("iob average is " + iob.average());
		
		Double[] dnums= {1.0, 2.3, 3.3, 33.4, 33.5};
		Stats2<Double> dob = new Stats2<Double>(dnums);
		System.out.println("iob average is " + dob.average());
		
		Float[] fnums= {1.0F, 2.0F, 3.0F, 4.0F, 5.0F};
		Stats2<Float> fob = new Stats2<Float>(fnums);
		System.out.println("iob average is " + fob.average());
				
//				//this wont compile  bec string doesnt work in numb
//				String[] str= "air", "nitro", "oxygen"};
//				Stats<String> sob = new Stats<String>(str); //bounded mismatch error
//				System.out.println("iob average is " + sob.average());
//				
				//printing averages
				System.out.println("Averages of iob and dob : " );
				if(iob.sameAvg(dob)) {
					System.out.println("aret the same");
				}
				else {
					System.out.println("differ");
				}

				if(iob.sameAvg(fob)) {
					System.out.println("are the same");
				}
				else {
					System.out.println("differ");
				}
		

}
}