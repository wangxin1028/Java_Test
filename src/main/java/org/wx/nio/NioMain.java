package org.wx.nio;

public class NioMain {
    public static void main(String[] args) {
//        BufferAPI bufferAPI = new BufferAPI();
//        bufferAPI.test();
    	FileRW filerw = new FileRW();
    	filerw.testMapRedirect();
    }
}
