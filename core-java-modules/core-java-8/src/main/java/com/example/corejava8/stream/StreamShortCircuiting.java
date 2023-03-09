package com.example.corejava8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class StreamShortCircuiting {


    public static void main(String[] args) {

        /**
         * anyMatch
         */
        Stream<Integer> anyMatchStream = Stream.of(2, 3, 5, 6, 12, 34);
        boolean anyMatchResult = anyMatchStream.anyMatch(e -> e == 3);
        System.out.println(anyMatchResult);


        /**
         * allMatch
         */
        Stream<Integer> allMatchStream = Stream.of(2, 3, 5, 6, 12, 34);
        boolean allMatchResult = allMatchStream.allMatch(e -> e > 2);
        System.out.println(allMatchResult);


        /**
         * noneMatch
         */
        Stream<Integer> noneMatchStream = Stream.of(2, 3, 5, 6, 12, 34);
        boolean noneMatchResult = noneMatchStream.noneMatch(e -> e == 4);
        System.out.println(noneMatchResult);


        /**
         * findFirst
         */
        Stream<Integer> findFirstStream = Stream.of(2, 3, 5, 6, 12, 34);
        Integer findFirstResult= findFirstStream.findFirst().get();
        System.out.println(findFirstResult);


        /**
         * findAny
         */
        Stream<Integer> findAnyStream = Stream.of(2, 3, 5, 6, 12, 34);
        Integer findAnyResult= findAnyStream.findAny().get();
        System.out.println(findAnyResult);


        /**
         * forEach
         */
        AtomicReference<String> name2 = new AtomicReference<>("Jack");
        List<String> forEachList = Arrays.asList( "Jon", "David", "Jack", "Duke", "Jill","Dany","Julia","Hary","Divya");
        forEachList.stream().forEach(name -> {
            if (name.equals("Jack")) System.out.println(name);
        });

        forEachList.stream().forEach(name3 -> {
            if (name3.equals("Jack")) name2.set("Jackson");
        });




    }
}
