package code.explore.net;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class URITest {
	public void test() {
		try {
			URL url = new URL("https://www.baidu.com");
			//InputStream input = url.openStream();
			HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
			openConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			openConnection.setRequestMethod("GET");
			InputStream input = openConnection.getInputStream();
			byte[] buf = new byte[1024];
			int len = 0 ;
			while((len=input.read(buf))!=-1) {
				System.out.println(new String(buf,0,len));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void test2() {
		InetAddress adderss;
		try {
			adderss = InetAddress.getByName("www.google.com");
			String canonicalHostName = adderss.getCanonicalHostName();
			System.out.println(canonicalHostName);
			System.out.println(adderss.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
