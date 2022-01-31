package jcr.chp21.java.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIODemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//create file output stream and wrap it inside a data outputstream
		try (DataOutputStream dout = 
				new DataOutputStream(new FileOutputStream("Test.dat"))){
			//adding numbers to our obj
			dout.writeDouble(98.6);
			dout.writeDouble(1000);
			dout.writeBoolean(true);
		}catch(FileNotFoundException e) {
			System.out.println("Cannot open output file");
			return;
		}catch (IOException e) {
			System.out.println("I/O Error: " + e);
		}
		
		//we are trying to read uisng file input stream 
		//wrapping it with data input stream
		try(DataInputStream din =
				new DataInputStream(new FileInputStream("Test.dat"))){
			//we are going to read 
			double d = din.readDouble();
			int i = din.readInt();
			boolean b = din.readBoolean();
			
			//d is our double number, i is our int adn b is our boolean
			//which we derived from invoking datainputstream
			System.out.println("Here are the values: " + d + " " + i + " " + b);
			
			//read every thing
			System.out.println(din.readAllBytes().toString());
		} catch(FileNotFoundException e) {
			System.out.println("Cannot open Input file");
			return;
		} catch(IOException e) {
			System.out.println("I/O error: " +e );
		}
		
	}

}
