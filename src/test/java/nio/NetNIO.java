package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

import org.junit.Test;

public class NetNIO {
	@Test
	public void testNoBlockClient() {
		try {
			SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
			channel.configureBlocking(false);

			String s = "a";
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			buffer.put(s.getBytes());
			buffer.flip();
			channel.write(buffer);
			channel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testNoBlockServer() {
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress(8888));

			serverSocketChannel.configureBlocking(false);

			Selector selector = Selector.open();

			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

			while(selector.select()>0) {
				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				while(iterator.hasNext()) {
					SelectionKey selectionKey = iterator.next();
					if(selectionKey.isAcceptable()) {
						//接收准备就绪
						SocketChannel socketChannel = serverSocketChannel.accept();
						socketChannel.configureBlocking(false);
						socketChannel.register(selector, SelectionKey.OP_READ);
					}else if(selectionKey.isReadable()) {
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);

                        while(channel.read(buffer)>0){
                            buffer.flip();
                            System.out.println(new String(buffer.array(),0,buffer.limit()));
                        }
                    }
					iterator.remove();
				}
			}
			serverSocketChannel.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
