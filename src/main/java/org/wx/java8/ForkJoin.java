package org.wx.java8;

import java.util.concurrent.RecursiveTask;

/**
 * fork join 在1.7的时候已经有了，但是使用不方便，1.8使用更方便了
 */
public class ForkJoin extends RecursiveTask<Long> {
    private long start;
    private long end;

    public ForkJoin(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long mid = end-start;
        if(mid<100000){
            long sum = 0 ;
            for(long i = start; i <= end ; i++){
                sum+=i;
            }
            return sum;
        }else{
            mid = (start+end)/2;
            ForkJoin fj1 = new ForkJoin(start,mid);
            fj1.fork();

            ForkJoin fj2 = new ForkJoin(mid+1,end);
            fj2.fork();

            return fj1.join()+fj2.join();
        }
    }
}
