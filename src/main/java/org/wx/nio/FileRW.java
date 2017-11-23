package org.wx.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileRW {
	public void testCharset() {
		
	}
	public void testFensanJuji() {
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile("conf/text.txt", "rw");
			FileChannel channel = raf.getChannel();
			
			ByteBuffer[] bbs = {ByteBuffer.allocate(7),ByteBuffer.allocate(9)};
			
			channel.read(bbs);
			 
			for(ByteBuffer bb : bbs) {
				bb.flip();
				System.out.println(new String(bb.array(),0,bb.limit()));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	public void testChannelIO() {
		try {
			FileChannel inchannel = FileChannel.open(Paths.get(System.getProperty("user.dir"), "/conf","Koala1.jpg"),StandardOpenOption.READ);
			FileChannel outchannel = FileChannel.open(Paths.get(System.getProperty("user.dir"), "/conf","Koala3.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
		
			inchannel.transferTo(0, inchannel.size(), outchannel);
			
			inchannel.close();
			outchannel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void testMapRedirect() {
		try {
			FileChannel inchannel = FileChannel.open(Paths.get(System.getProperty("user.dir"), "/conf","Koala1.jpg"),StandardOpenOption.READ);
			FileChannel outchannel = FileChannel.open(Paths.get(System.getProperty("user.dir"), "/conf","Koala2.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
			
			MappedByteBuffer inmap = inchannel.map(MapMode.READ_ONLY, 0, inchannel.size());
			MappedByteBuffer outmap = outchannel.map(MapMode.READ_WRITE, 0, inchannel.size());
			
			byte[] buf = new byte[inmap.capacity()];
			inmap.get(buf);
			outmap.put(buf);
			
			inchannel.close();
			outchannel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void testFileRW() {
		FileInputStream in = null;
		FileOutputStream out = null;
		FileChannel inchannel = null;
		FileChannel outchannel = null;
		try {
			in = new FileInputStream("conf/Koala1.jpg");
			out = new FileOutputStream("Koala2.jpg");
			inchannel = in.getChannel();
			outchannel = out.getChannel();
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			while(inchannel.read(buf)!=-1) {
				buf.flip();
				outchannel.write(buf);
				buf.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(out!=null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(inchannel!=null) {
				try {
					inchannel.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(outchannel!=null) {
				try {
					outchannel.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
