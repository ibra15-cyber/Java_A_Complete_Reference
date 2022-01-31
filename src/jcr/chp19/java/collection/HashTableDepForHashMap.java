package jcr.chp19.java.collection;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashTableDepForHashMap {

	public static void main(String[] args) {
		
		//hashtable deprecated constructor
		Hashtable<String, Double> balance = new Hashtable<String, Double>();
		
		
		String str;
		double bal;
		
		balance.put("John Doe", 3434.34);
		balance.put("Tom Smith", 123.22);
		balance.put("Tod Hall", 99.22);
		balance.put("Ralph Smith", -19.08);
		
		//show all balances in hastable
		//enum deperecated for iterator
		Enumeration<String> names = balance.keys();
		while(names.hasMoreElements()) {
			str = names.nextElement()	;
			System.out.println(str + ": " + balance.get(str));
		}
		
		///>>>>>>>>>>>>>>>>>>>>>>>this can be rewritten in hashmap to use set to iterate
		//instead enumerate
		//get the set view
		
		//set set on the our collection
//		Set<String> set = balance.keySet();
//		
//		Iterator<String> itr = set.iterator();
//		while(itr.hasNext())
//			System.out.println(itr.next());
//		
		
		
		
		
		System.out.println();
		
		//deposit 1000 in john does accoutn
		
		bal = balance.get("John Doe"); 	//gets the value and has int or double as return type
		balance.put("John Doe",  bal+1000);
		System.out.println("John Doe's new balance: " + balance.get("John Doe"));
		
		

	}

}
