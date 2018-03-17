package code.explore.java8;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinTest {
    public static void main(String[] args) {
        Instant begin = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoin fj = new ForkJoin(0,100000000000L);
        Long sum = pool.invoke(fj);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(begin,end).toMillis());

        begin = Instant.now();
        long count = 0 ;
        for(long i = 1 ; i <= 100000000000L ; i++){
            count+=i;
        }
        System.out.println(count);
        end = Instant.now();
        System.out.println(Duration.between(begin,end).toMillis());
    }
}
