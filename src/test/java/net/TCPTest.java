package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

public class TCPTest {
    @Test
    public void client() {
        try {
            Socket client = new Socket("localhost", 7379);
            OutputStream outputStream = client.getOutputStream();
            OutputStreamWriter write = new OutputStreamWriter(outputStream);
            write.write("红黄蓝");
            write.flush();
            client.shutdownOutput();

            InputStream inputStream = client.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            char[] buf = new char[1024];
            int l = 0;
            while ((l = reader.read(buf)) != -1) {
                System.out.println(new String(buf, 0, l));
            }

            client.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void server() {
        try {
            ServerSocket server = new ServerSocket();
            server.bind(new InetSocketAddress(7379));
            Socket accept = server.accept();

            InputStream inputStream = accept.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            char[] buf = new char[1024];
            int l = reader.read(buf);
            System.out.println(new String(buf, 0, l));

            OutputStream outputStream = accept.getOutputStream();
            PrintWriter print = new PrintWriter(outputStream);
            print.println("HTTP/1.1 200 OK");
            print.println("Server: nginx/1.10.1");
            print.println("Date: Wed, 29 Nov 2017 09:04:06 GMT");
            print.println("Content-Type: text/html;charset=UTF-8");
            print.println();
            print.println("大坏蛋");
            print.flush();

            accept.close();
            server.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
