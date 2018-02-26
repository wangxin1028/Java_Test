package java.test.juc;


public class CASTest {
    public static void main(String[] args) {
        final CASDemo cas = new CASDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int expValue = cas.get();
                boolean result = cas.compareAndSet(expValue, (int) (Math.random() * 101));
                System.out.println(result);
            }).start();
        }
    }
}

/**
 * CAS是乐观锁的一种实现
 * 在操作一个数之前，先获取这个数的值，然后进行一系列操作，最终写入的时候再获取一次，看在操作的过程中
 * 这个数是否发生了改变，如果没有发生改变就写入，如果发生了改变就回滚
 */
class CASDemo {
    private int value;

    public synchronized int get() {
        return value;
    }

    /**
     * CAS
     *
     * @param expValue 期望值
     * @param newValue 新值
     * @return 旧值
     */
    public synchronized int compareAndSwap(int expValue, int newValue) {
        int oldValue = value;
        if (oldValue == expValue) {
            this.value = newValue;
        }
        return oldValue;
    }

    /**
     * 是否设置成功
     */
    public synchronized boolean compareAndSet(int expValue, int newValue) {
        return expValue == this.compareAndSwap(expValue, newValue);
    }
}
