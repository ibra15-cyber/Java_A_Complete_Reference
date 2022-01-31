package jcr.chp19.java.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		
		HashMap<String, Double> hm = new HashMap<String, Double>();
		
		hm.put("me" , 343.0)	;
		hm.put("jjl", 343.343)	;
		hm.put("lkj", 343.43)	;
		hm.put("kofi", 33.043)	;
		hm.put("kwame" , 66.43)	;
		
		System.out.println("sysout for map" + hm);  //and it work
		
		//Get a set of the entries
		Set<Map.Entry<String, Double>>	set = hm.entrySet();
		
		//display the set
		for(Map.Entry<String, Double> me : set) {
			System.out.print(me.getKey() + ": \t");
			System.out.println(me.getValue());
		}
		
		System.out.println();
		
		//deposit 1000 into John Doe's account
		double balance = hm.get("me");
		hm.put("me", balance+ 1000);
		
		System.out.println("Updated List");
		for(Map.Entry<String, Double> me : set) {
			System.out.print(me.getKey() + ": \t");
			System.out.println(me.getValue());
		}
		
		
		
		
		
		
		
		
	}

}
