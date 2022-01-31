package jcr.chp29.java.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

class NamePhoneEmail{
	String name;
	String phonenum;
	String email;
	
	NamePhoneEmail(String name,	String phonenum, String email){
		this.name = name;
		this.phonenum = phonenum;
		this.email = email;
	}
}


class NamePhone{
	String name;
	String phonenum;
	
	NamePhone(String name,	String phonenum){
		this.name = name;
		this.phonenum = phonenum;
	}
}


public class StreamDemo5Map {

	public static void main(String[] args) {
		ArrayList<NamePhoneEmail> myList = new ArrayList<>();
		
		//arraylist of the first class
		//we could have done the obj of that class separately 
		//before finally passing those names here
		myList.add(new NamePhoneEmail("larry", "555-5555", "larry@herbSchidt.com"));
		myList.add(new NamePhoneEmail("James", "555-4444", "James@herbSchidt.com"));
		myList.add(new NamePhoneEmail("Marry", "555-5555", "Marry@herbSchidt.com"));
		
		//printing the original list above
		System.out.println("Original values in myList: " );
		myList.stream().forEach( (a) -> {
			System.out.println(a.name + " " + a.phonenum + " " + a.email);
		});
		
		System.out.println();
		
		//filtering using only mapping 
		Stream<NamePhone> nameAndPhone = myList.stream().map( 
																	(a) -> new NamePhone(a.name, a.phonenum));
				
		
		System.out.println("List of names and phone numbers: " );
		nameAndPhone.forEach( (a) -> {
			System.out.println(a.name + " " + a.phonenum);
		});
		
		System.out.println();
		
		//filtering james and then his name and phone num
		Stream<NamePhone> nameJames = myList.stream().filter( (a) -> a.name.equals("James")).map( (a) -> 
												new NamePhone(a.name, a.phonenum));
		
		System.out.println("name James: " );
		nameJames.forEach( (a) -> {
			System.out.println(a.name + " " + a.phonenum);;
		});
	}

}
