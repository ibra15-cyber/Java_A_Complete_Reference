package jcr.chp17.string;


public class BubbleSort {
	
	//static String arr[]	 = { "Now", "is", "the", "time", "to", "the", "aid", "of", "their"	, "country"};
	public static void main(String[] args) {
	
		
		//iterate through a list
		//if the first is less than the second
		//swap:
		//take the value of greater and save it in temp
		//assign the value of the less to the the initial pos
		//assign temp value to the next
		//return value of the lower now in the initial index
		String arr[]	 = { "Now", "is", "the", "time", "to", "the", "aid", "of", "their"	, "country"};

		for(int j = 0; j <arr.length; j++) {  
			for(int i = j+1; i<arr.length; i++) {	
				if(arr[i].compareTo(arr[j])< 0) {   //if elements in our array compared to the next
//				if(arr[i].compareTo(arr[j])< 0) 
					//the greater or next index is saved as t
					String t = arr[j];						//if the first is less, store in arr[j	] in t
					//the next index becomes the first index
					arr[j]	= arr[i];							//assingn the arr[j] to the initial ele
					//the first index becomes t which is the the next 
					arr[i] = t;									//then finally assign value of the greater arr j is finally assing to t
				}
			}
			System.out.println(arr[j]);				//print the arr j which will be 
		}
	}

}
