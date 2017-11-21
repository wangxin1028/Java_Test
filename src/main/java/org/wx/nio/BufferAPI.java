package org.wx.nio;

import java.nio.ByteBuffer;

public class BufferAPI {
    public void test(){
        String s = "abc";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.put(s.getBytes());

        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.flip();

        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes,0,bytes.length));

        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.rewind();

        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.clear();

        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        byte b = buffer.get();
        System.out.println(b);


    }
}
