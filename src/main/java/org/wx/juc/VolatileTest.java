package org.wx.juc;

public class VolatileTest {
    public static void main(String[] args) {
        ThreadDemo t = new ThreadDemo();
        new Thread(t).start();

        while(true){
            if(t.isFlag()){
                break;
            }

        }
    }
}
class ThreadDemo implements Runnable{
    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag=true;
        System.out.println("flag is ture");
    }
}
