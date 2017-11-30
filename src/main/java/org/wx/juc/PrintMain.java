package org.wx.juc;

public class PrintMain {
    public static void main(String[] args) {
        Print p = new Print();
        new Thread(
                () -> {
                    for (int i = 0 ; i < 10 ; i++){
                        p.printA();
                    }
                }
        ).start();
        new Thread(
                () -> {
                    for (int i = 0 ; i < 10 ; i++){
                        p.printB();
                    }
                }
        ).start();
        new Thread(
                () -> {
                    for (int i = 0 ; i < 10 ; i++){
                        p.printC();
                    }
                }
        ).start();
    }
}
