package org.wx.exception;

import java.io.IOException;

public class Test {
	  private void fun1() throws IOException {
	    throw new IOException("level 1 exception");
	  }
	  private void fun2() {
	    try {
	      fun1();
	    } catch (IOException e) {
	        throw new RuntimeException("level 2 exception", e);
	    }
	  }
	  public static void main(String[] args) {
	    try {
	      new Test().fun2();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	}
