package jcr.chp19.java.collection;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		
		Stack<Integer> st = new Stack<Integer>();
		
		System.out.println("stack: " + st);
		
		//call showpush to add to the stack
		showpush(st, 42);
		showpush(st, 66);
		showpush(st, 99);
		
		//call pop to remove from the stack
		showpop(st);
		showpop(st);
		showpop(st);
		
		//we know this will be underflow so we catch the erro
		try {
			showpop(st);
		}catch(EmptyStackException e)	{
			System.out.println("empty stack");
		}
		
		
		

	}
	//our stack is taking integer
	static void showpush(Stack<Integer> st, int a ) {
		//add our int in our stack
		st.push(a); 
		System.out.println("push(" + a + ")");
		//print our stack
		System.out.println("stack: " + st);
	}
	
	//method 2: 
	static void showpop(Stack<Integer> st) {
		System.out.println("pop -> ");
		st.pop(); //removes top item
		System.out.println("Stack: " + st); //print back the stack
		
	}

}
