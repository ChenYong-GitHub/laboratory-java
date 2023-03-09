package com.example.corejava8.stream;

import java.util.stream.Stream;

public class StreamStateful {

    public static void main(String[] args) {

        /**
         * distinct
         */
        Stream<String> distinctStream = Stream.of("1", "2", "5", "7", "10", "2", "5", "7");
        distinctStream.distinct().forEach(System.out::println);
        System.out.println("---------distinct end-------");


        /**
         * sorted
         */
        Stream<Integer> sortedStream = Stream.of(1, 5, 3, 8, 10, 23);
        sortedStream.sorted().forEach(System.out::println);
        System.out.println("---------sorted end-------");


        /**
         * limit
         */
        Stream<Integer> limitStream = Stream.of(1, 5, 3, 8, 10, 23);
        limitStream.limit(3).forEach(System.out::println);
        System.out.println("---------limit end-------");


        /**
         * skip
         */
        Stream<Integer> skipStream = Stream.of(1, 5, 3, 8, 10, 23);
        skipStream.skip(3).forEach(System.out::println);
        System.out.println("---------skip end-------");




    }
}
