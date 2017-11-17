package org.wx.java8;

import org.wx.entity.Persion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {
    private static List<Persion> persions = null;
    static{
        persions = new ArrayList<>();
        persions.add(new Persion("p1",10));
        persions.add(new Persion("p2",11));
        persions.add(new Persion("p3",12));
        persions.add(new Persion("p4",13));
        persions.add(new Persion("p5",14));
        persions.add(new Persion("p6",15));
        persions.add(new Persion("p7",16));
        persions.add(new Persion("p8",17));

    }
    public static void main(String[] args) {


    }
    public void createStream(){
        Persion p1 = new Persion("p1",12);
        Persion p2 = new Persion("p2",13);
        Persion p3 = new Persion("p3",14);
        Persion p4 = new Persion("p4",15);
        Persion p5 = new Persion("p5",16);

        boolean b = Stream.of(p1, p2, p3, p4, p5).anyMatch(t -> t.getAge() == 16);
        System.out.println(b);
    }
}
