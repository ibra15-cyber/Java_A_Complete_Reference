package jcr.chp19.java.collection;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

	
	//trees sorts by key
	public static void main(String[] args) {
		
		TreeMap<String, Double> tm = new TreeMap<String, Double>();
		
		tm.put("John Doe", 3434.34);
		tm.put("Tom Smith", 123.22);
		tm.put("Jane Baker", 1289.00);
		tm.put("Tod Hall", 99.22);
		
		
		//get a set of the entries.
		Set<Map.Entry<String, Double>> set = tm.entrySet();
		
		for(Map.Entry<String, Double> me : set) {
			System.out.print(me.getKey() + ":  \t"	); 
			System.out.println(me.getValue());
		}
		
		//Deposit 1000 into john doe's account
		double balance = tm.get("John Doe");
		tm.put("John Doe", balance + 1000);
		
		System.out.println("John Doe's new balance: " + tm.get("John Doe" ));
		
		
		
		
		
		
		

	}

}
