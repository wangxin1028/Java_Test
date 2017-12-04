package system;

import org.junit.Test;

public class SystemTest {
    @Test
    public void test(){
        String property = System.getProperty("line.separator");
        System.out.print(property);
    }
}
