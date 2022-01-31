package jcr.chp19.java.collection;

import java.util.LinkedList;

class Address{
	private String name;
	private String street;
	private String city;
	private String state;
	private String code;
	
	Address(String name, String street, String city, String state, String code){
		this.name = name;
		this.street = street;
		this.city  = city;
		this.state = state;
		this.code = code;
	}
	
	public String toString() {
		return name + "\n" + street + "\n "+ city + " " + state + " " + code;
	}
}

public class MailListToImplementCollectionWithUserDefineClasses {

	public static void main(String[] args) {
		
		LinkedList<Address> ml = new LinkedList<Address>();
		
		ml.add(new Address("J.W. West ", "lll oak ave", "urabana", "IL", "y1801"));
		ml.add(new Address("Ralph Banker ", "1142 Maple Lane", "Mahomet", "IL", "61853"));
		ml.add(new Address("Tom Carlton ", "867", "urabana", "IL", "y1801"));
		
		//we could also populate the list by first creating the obj of class Address
		//then calling it in the add method
		
		//printing our list sysout and the name should do
		//System.out.println("sysout should print arraylist " + ml);
		
		for (Address addr: ml)
			System.out.println(addr + "\n");
		
		System.out.println();
		
		
		
		
		

	}

}
