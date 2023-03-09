package com.example.corejava8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 写得非常好的一篇关于Stream的文章
 * https://blog.csdn.net/yy339452689/article/details/110956119
 */
public class StreamCreationAndConstitution {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);

        Stream<Integer> stream = integerList.stream();
        Stream<Integer> integerStream = integerList.parallelStream();
        System.out.println("-----------串行Stream--start-------");
        stream.forEach(System.out::println);

        System.out.println("----------并行Stream---start-------");
        integerStream.forEach(System.out::println);

    }
}
