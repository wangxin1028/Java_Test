package code.explore.juc;

public class ShutDownHookTest {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutDownAction());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
class ShutDownAction extends Thread{
    @Override
    public void run() {
        System.out.println("程序退出");
    }
}
