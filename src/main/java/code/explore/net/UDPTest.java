package code.explore.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPTest {
	public void client() {
		try {
			DatagramSocket client = new DatagramSocket();
			String s = "你好啊";
			
			byte[] content = s.getBytes();
			DatagramPacket request = new DatagramPacket(content, 0, content.length, new InetSocketAddress("127.0.0.1", 80));
			
			client.send(request);
			
			client.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void server() {
		try {
			DatagramSocket server = new DatagramSocket(80);
			
			byte[] b = new byte[1024];
			DatagramPacket p = new DatagramPacket(b, b.length);
			server.receive(p);
			
			System.out.println(new String(p.getData(),0,p.getLength()));
			
			server.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
