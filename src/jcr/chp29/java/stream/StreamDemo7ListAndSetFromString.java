package jcr.chp29.java.stream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NamePhoneEmail2{
	String name;
	String phonenum;
	String email;
	
	NamePhoneEmail2(String name,	String phonenum, String email){
		this.name = name;
		this.phonenum = phonenum;
		this.email = email;
	}
}


class NamePhone2{
	String name;
	String phonenum;
	
	NamePhone2(String name,	String phonenum){
		this.name = name;
		this.phonenum = phonenum;
	}
}


public class StreamDemo7ListAndSetFromString {

	public static void main(String[] args) {
	ArrayList<NamePhoneEmail> myList = new ArrayList<>();
		
		//arraylist of the first class
		//we could have done the obj of that class separately 
		//before finally passing those names here
		myList.add(new NamePhoneEmail("larry", "555-5555", "larry@herbSchidt.com"));
		myList.add(new NamePhoneEmail("James", "555-4444", "James@herbSchidt.com"));
		myList.add(new NamePhoneEmail("Marry", "555-5555", "Marry@herbSchidt.com"));
		
		//mapping names and numbers to a new stream
		Stream<NamePhone2> nameAndPhone = myList.stream().map(
													(a) -> new NamePhone2(a.name, a.phonenum));
		
		//use collect to create list of the name and phone numbers
		List<NamePhone2> npList = nameAndPhone.collect(Collectors.toList());
		
		System.out.println("Names and phone numbers in a list: ");
		for(NamePhone2 e : npList)
			System.out.println(e.name + ": " + e.phonenum);
		
		nameAndPhone  = myList.stream().map(
										(a) -> new NamePhone2(a.name, a.phonenum)	);
		
		//now create a set of use of collect()
		Set<NamePhone2> npSet = nameAndPhone.collect(Collectors.toSet());
		
		System.out.println("Names and phone numbers in a set: " );
		for(NamePhone2 e : npSet)
			System.out.println(e.name + " : " + e.phonenum);
		
		
//		<R> R collect(Supplier<R> target, BiConsumer<R, ? super T > 
//												accumulator, BiConsumer<R,R>combiner)
		
		LinkedList<NamePhone2> npLl = nameAndPhone.collect(
															() -> new LinkedList<>(),
															(list, element) -> list.add(element),
															(listA, listB) -> listA.addAll(listB));
		
		System.out.println(npLl);
											
	}
	

}