package code.explore.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

public class UDPTest {
	public void client() {
		try {
			DatagramChannel client = DatagramChannel.open();
			client.configureBlocking(false);
			
			String s = "你好啊";
			ByteBuffer buf = ByteBuffer.allocate(1024);
			buf.put(s.getBytes());
			buf.flip();

			client.send(buf, new InetSocketAddress("127.0.0.1", 7379));
			
			client.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void server() {
		try {
			DatagramChannel server = DatagramChannel.open();
			server.bind(new InetSocketAddress(7379));
			
			server.configureBlocking(false);
			
			Selector selector = Selector.open();
			
			server.register(selector, SelectionKey.OP_READ);
			
			if(selector.select()>0) {
				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				
				while(iterator.hasNext()) {
					SelectionKey selectionKey = iterator.next();
					if(selectionKey.isReadable()) {
						DatagramChannel channel = (DatagramChannel) selectionKey.channel();
						ByteBuffer buf = ByteBuffer.allocate(1024);
						channel.receive(buf);
						
						System.out.println(new String(buf.array(),0,buf.limit()));
					}
					iterator.remove();
				}
			}
			server.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
