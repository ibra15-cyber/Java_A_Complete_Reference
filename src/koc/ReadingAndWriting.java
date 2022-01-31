package koc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ReadingAndWriting {

	public static void main(String[] args) {
		
		
		//writing file
		try {
			BufferedWriter bw = new BufferedWriter(
					new	FileWriter("trial1.txt"));
			
			bw.write("my first\n");
			bw.write("my second\n");
			bw.write("my third\n");
			bw.write("another");
			bw.close();
		
		} catch (Exception e) {
		return ;
	}
		
		//reading file
		try {
			BufferedReader br = new BufferedReader(
					new FileReader("trial.txt" ));
			
			String s;
			while((s = br.readLine()) != null) {
				System.out.println(s);		
			}
			br.close();
		}catch(Exception e) {
			return;
		}
}		
}
