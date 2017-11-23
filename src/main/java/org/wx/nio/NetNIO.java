package org.wx.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import org.junit.Test;

public class NetNIO {
	@Test
	public void testBlockClient() {
		try {
			SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 7379));
			String s = "我是客户端";
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			buffer.put(s.getBytes());
			buffer.flip();
			channel.write(buffer);
			
			buffer.clear();
			channel.read(buffer);
			buffer.flip();
			System.out.println(new String(buffer.array(),0,buffer.limit()));
			channel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testBlockServer() {
		try {
			ServerSocketChannel server = ServerSocketChannel.open();
			server.bind(new InetSocketAddress(7379));
			
			SocketChannel accept = server.accept();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			accept.read(buffer);
			
			buffer.flip();
			System.out.println(new String(buffer.array(),0,buffer.limit()));
			
			buffer.clear();
			buffer.put("我是服务端".getBytes());
			buffer.flip();
			accept.write(buffer);
			
			accept.close();
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
