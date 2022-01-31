package jcr.chp19.java.collection;

import java.util.Properties;
import java.util.Set;

public class PropertiesLikeHashtable {

	public static void main(String[] args) {
		
		Properties capitals = new Properties(); //just like hashtable hashmap
		
		capitals.setProperty("Illinois", "Springfield");
		capitals.setProperty("Missouri", "Jefferson City");
		capitals.setProperty("Washington", "Olympia");
		capitals.setProperty("California", "Sacramento");
		capitals.setProperty("Indiana", "Indianapolis");
		
		//Get the set view
		Set<?> states =  capitals.keySet()	;			//setting our keys to be able to iterate
		
		for (Object name: states)
			System.out.println("The capital of " 
										+ name + " is " + capitals.getProperty((String)name) + ".");
		
		
		//look for a state no in the list --specify default
		String str = capitals.getProperty("Forida" , "not found");
		System.out.println("the capital of florida is " + str + " .");
		





	}

}
