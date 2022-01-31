package jcr.chp30.java.reflect;

import java.lang.reflect.Constructor;

import java.lang.reflect.*;

public class ReflectionDemo1 {

	public static void main(String[] args) {
		
		try {
			//first get get name of class passed as an argument 
			//save as c with Class return type
			Class<?> c = Class.forName("java.awt.Dimension");

			// get the constructor of our obj/variabe c
			//its a list hence anticipate and make an array of a return type constructor
			System.out.println("Constructors:");
			Constructor<?>[] constructors = c.getConstructors();
			for(int i = 0; i< constructors.length; i++) {
				System.out.println(" " + constructors[i]);
			}
			
			//invoking getFields on our obj/variabe of class dimension
			//its gonna be a list hence put in an array with return type fields
			System.out.println("Fields");
			Field[] fields = c.getFields();
			for(int i = 0; i<fields.length; i++	) {
				System.out.println(" " + fields[i] );
			}
			
			//invoke the get method on our obj or variable of a class type called dimension
			//its returning an array hence our variable will be an array 
			//with a return type method
			System.out.println("Methods");
			Method[] methods = c.getMethods();
			for(int i = 0; i < methods.length; i++) {
				System.out.println(" " + methods[i]);
			}
			
		} catch(Exception e) {
			System.out.println("Exception: " + e);
		}
	}

}
