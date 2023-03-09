package com.example.corejava8.stream;

import com.example.corejava8.stream.bean.People;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStateless {

    public static void main(String[] args) {

        /*
         * filter
         */
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        integerList.stream().filter(i -> i > 4).forEach(System.out::println);


        /*
         *  map
         */
        Stream.of("张三:18", "李四:20").map(s -> {
            String[] peopleInfo = s.split(":");
            People people = new People(peopleInfo[0], Integer.valueOf(peopleInfo[1]));
            return people;
        }).forEach(people -> System.out.println("people: " + people));


        /*
         * flatMap
         */
        List<String> flatMapPreList = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> flatMapPostList =  flatMapPreList.stream().flatMap(s -> {
            String[] split = s.split(",");
            Stream<String> stream = Arrays.stream(split);
            return stream;
        }).collect(Collectors.toList());

        System.out.println("flatMap前：" + flatMapPreList);
        System.out.println("flatMap后：" + flatMapPostList);


        /*
         * peek
         */
        Stream<String> hello = Stream.of("hello", "world");
        hello.peek(System.out::println).collect(Collectors.toList());


        /*
         * unordered
         */
        Stream.of(1,2,3,6,5,4).unordered().forEach(System.out::println);

    }
}
