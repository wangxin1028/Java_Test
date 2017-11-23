package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Test;
import org.wx.entity.Country;
import org.wx.entity.Persion;

/**
 * Stream api 测试
 */
public class StreamAPI {
    private static List<Persion> persions = null;
    static{
        Country chian = new Country("中国");
        Country jepan = new Country("日本");

        persions = new ArrayList<>();
        persions.add(new Persion("p1",10,chian));
        persions.add(new Persion("p2",11,jepan));
        persions.add(new Persion("p3",12,jepan));
        persions.add(new Persion("p4",13,chian));
        persions.add(new Persion("p5",14,jepan));
        persions.add(new Persion("p6",15,chian));
        persions.add(new Persion("p7",16,jepan));
        persions.add(new Persion("p8",17,chian));
        persions.add(new Persion("p8",17,jepan));


    }

    /**
     * 中间操作
     */
    @Test
    public void testZhongjian(){
        persions.stream().filter(p -> p.getAge()>15).forEach(System.out::println);

        System.out.println("-------------------------");

        persions.stream().distinct().forEach(System.out::println);

        System.out.println("-------------------------");

        persions.stream().limit(2).skip(1).forEach(System.out::println);

        System.out.println("-------------------------");

        Optional<Persion> persion = persions.parallelStream().findAny();
        System.out.println(persion);

        System.out.println("-------------------------");

    }

    /**
     * 终止操作
     */
    @Test
    public void testZhonzhi(){
        DoubleSummaryStatistics statistics = persions.stream().collect(Collectors.summarizingDouble(t -> t.getAge()));
        System.out.println(statistics.getSum());

        Map<Country, List<Persion>> listMap = persions.stream().collect(Collectors.groupingBy(t -> t.getCountry()));
        System.out.println(listMap);
    }

    /**
     * 获取stream的几种方式
     */
    @Test
    public void createStream(){
        //stream.of
        Persion p1 = new Persion("p1",12);
        Persion p2 = new Persion("p2",13);
        Persion p3 = new Persion("p3",14);
        Persion p4 = new Persion("p4",15);
        Persion p5 = new Persion("p5",16);
        Stream<Persion> stream1 = Stream.of(p1, p2, p3, p4, p5);
        System.out.println(stream1);

        //Arrays.stream
        Persion[] parray = new Persion[]{p1,p2,p3,p4,p5};
        Stream<Persion> stream = Arrays.stream(parray);
        System.out.println(stream);

        //Collection.stream()
        List<Persion> plist = new ArrayList<>();
        plist.add(p1);
        plist.add(p2);
        plist.add(p3);
        plist.add(p4);
        plist.add(p5);
        Stream<Persion> stream2 = plist.stream();
        System.out.println(stream2);
    }
    @Test
    public void testParallel(){
        long sumary = LongStream.rangeClosed(0, 100000000000L).parallel().parallel().reduce(0, Long::sum);
        System.out.println(sumary);
    }
}
