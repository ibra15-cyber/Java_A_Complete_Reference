package jcr.chp22.java.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class MappedChannelRead {

	public static void main(String[] args) throws IOException {
		
		try(FileChannel fchan = (FileChannel) Files.newByteChannel(Path.of("serial"))){
			
			long filesize = fchan.size();
			
			//now map the file int a buffer
			MappedByteBuffer mbb  =
					fchan.map(FileChannel.MapMode.READ_ONLY, 0, filesize);
			
			//read and display bytes from buffer
			for(int i = 0; i<filesize; i++)
				System.out.print((char) mbb.get());
			
			System.out.println();
		}catch(InvalidPathException e) {
			System.out.println("Path Error: "+e);
		}catch(IOException e) {
			System.out.println("I/O Error: "+e);
		}
	}

}
