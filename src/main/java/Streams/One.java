package Streams;

import java.util.Arrays;
import java.util.List;

public class One {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,4,7,8,9);
        List<Integer> list2 = Arrays.asList(6,8,7,8,9);

        list1.stream().filter(list2::contains).forEach(System.out::println);
    }
}
