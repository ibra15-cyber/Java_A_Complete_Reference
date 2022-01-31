package jcr.chp30.java.reflect;

import java.lang.reflect.*;


class A{
	
	public void a1()	{
	}
	public void a2()	{
	}
	protected void a3() {
	}
	private void a4()	{
	}
	
}

public class ReflectionDemo2 {

	public static void main(String[] args) {
	
		A a = new A(); //making an obj of a class A to be created

		try {
			Class<?> c  = a.getClass(); //get class of class a
			System.out.println("Public Methods");
			//get declared methods
			//which will be more than one hence list
			Method[] methods  = c.getDeclaredMethods(); 
			
			for(int i = 0; i< methods.length; i++) {
				int modifiers = methods[i].getModifiers(); //get modifiers on our methods
				if(Modifier.isPublic(modifiers)) {
					System.out.println(" " + methods[i].getName());
				}
				else if(Modifier.isProtected(modifiers))
					System.out.println("Protected methods:  " + methods[i].getName());
				else {
					System.out.println("private: " + methods[i].getName());
				}
				}
		} catch(Exception e) {
			System.out.println("Exception: " + e);
		}

	}

}
