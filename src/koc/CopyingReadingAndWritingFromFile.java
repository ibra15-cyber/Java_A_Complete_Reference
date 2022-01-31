package koc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyingReadingAndWritingFromFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(
					new FileReader("C:\\Users\\dell\\Desktop\\dev\\java\\fileWriter\\trial2.txt"));
			
			BufferedWriter bw =  new BufferedWriter(
					new FileWriter("C:\\Users\\dell\\Desktop\\dev\\java\\fileWriter\\trialcopy.txt"));
					
			String s;
			while((s=br.readLine())!= null) {
				bw.write(s + " \n");
			}
			bw.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
