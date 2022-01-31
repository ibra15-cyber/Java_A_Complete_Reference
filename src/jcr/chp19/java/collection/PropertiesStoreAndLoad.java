/**
 * 
 */
package jcr.chp19.java.collection;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class PropertiesStoreAndLoad {

	public static void main(String[] args) throws IOException {
		
		Properties ht = new Properties(); //a collection like hashtable replaced by hashmap
		
		//always remember to put FileReader and InputStreamReader in BufferedReader
		//FileWriter and OutStreamWriter in BufferedStreamWriter
		
		//how about FileInputStream
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//.....................................................equivalent to the below code........
		
//		InputStreamReader isr = new InputStreamReader(System.in);
//		BufferedReader br2 = new BufferedReader(isr);
//		
		//.............................................................................................................
		
		String name, number;
		FileInputStream fin = null;
		boolean changed = false;
		
		try {
			fin = new FileInputStream("phonebook.dat");
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		//if phonebook file already exists, load existing telephone numbers
		if(fin !=null) {
			try {
				ht.load(fin); //if file exit, load!
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		//let user enter new names and numbers
		do {
			System.out.println("Enter new name " + "('quit' to stop): " );
			name = br.readLine();
			if(name.equals("quit"))
				continue;
			
			System.out.println("enter number: " );
			number = br.readLine();
			
			ht.setProperty(name, number);
			changed = true;
		} while(!name.equals("quit"));
		
		//if phone book data has changed save it.
		if(changed) {
			FileOutputStream fout = new FileOutputStream("phonebook.dat");
			
			ht.store(fout, "Telephone Book");
			fout.close();
		}
		
		//look up numbers given a name
		
		do {
			System.out.println("Enter name to fine " + " ('quit' to quit): ");
			name = br.readLine();
			if(name.equals("quit"))
					continue;
			
			number = (String) ht.get(name);
			System.out.println(number);
		}while(!name.equals("quit"));
		
		
		
	}

}
