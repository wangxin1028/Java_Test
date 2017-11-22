package org.wx.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileRW {
	public void testChannelIO() {
		
	}
	public void testMapRedirect() {
		try {
			FileChannel inchannel = FileChannel.open(Paths.get(System.getProperty("user.dir"), "/conf","Koala.jpg"),StandardOpenOption.READ);
			FileChannel outchannel = FileChannel.open(Paths.get(System.getProperty("user.dir"), "/conf","Koala.jpg"),StandardOpenOption.READ,StandardOpenOption.WRITE);
			
			inchannel.map(MapMode.READ_ONLY, 0, inchannel.size());
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
			in = new FileInputStream("conf/Koala.jpg");
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
