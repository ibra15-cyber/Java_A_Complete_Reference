package jcr.chp22.java.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ExplicitChannelWrite {

	public static void main(String[] args) {
	
		//obtain a channel to a file within a try with resources block
	try(FileChannel fchan = (FileChannel) Files.newByteChannel(Path.of("writingToFileUsingChannel.txt"), 
																													StandardOpenOption.WRITE, 
																													StandardOpenOption.CREATE)	{
			
			//create a buffer
			ByteBuffer bb = ByteBuffer.allocate(26);
			
			//write some bytes to the buffer.
			for(int i =0; i<26; i++)
				bb.put((byte) ('A' + i));
			
			//reset the buffer so that it can be written
			bb.rewind();
			
			//write buffer to the output file
			fchan.write(bb);
			
		}catch(InvalidPathException e) {
			System.out.println("Path Error: "+e);
		}catch(IOException e) {
			System.out.println("I/O Error: "+e);
		}

	}

}
