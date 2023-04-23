package com.example.corejava8.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
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
        Integer findFirstResult = findFirstStream.findFirst().get();
        System.out.println(findFirstResult);


        /**
         * findAny
         */
        Stream<Integer> findAnyStream = Stream.of(2, 3, 5, 6, 12, 34);
        Integer findAnyResult = findAnyStream.findAny().get();
        System.out.println(findAnyResult);


        /**
         * forEach
         */
        AtomicReference<String> name2 = new AtomicReference<>("Jack");
        List<String> forEachList = Arrays.asList("Jon", "David", "Jack", "Duke", "Jill", "Dany", "Julia", "Hary", "Divya");
        forEachList.stream().forEach(name -> {
            if (name.equals("Jack")) System.out.println(name);
        });

        forEachList.stream().forEach(name3 -> {
            if (name3.equals("Jack")) name2.set("Jackson");
        });


        /**
         * forEachOrdered
         */
        List<String> forEachOrdered = Arrays.asList("a", "b", "c", "d", "e");
        forEachOrdered.stream().forEach(System.out::print);
        System.out.println();
        forEachOrdered.stream().parallel().forEach(System.out::print);


        List<String> toArrayList = forEachOrdered;
        Object[] toArray = toArrayList.stream().toArray();
        String[] strings = toArrayList.stream().toArray(String[]::new);
        System.out.println();
        System.out.println("----------");


        /**
         * reduce
         */
        // 一个入参的情况
//        Optional<Integer> reduce = Stream.of(2, 3, 4, 5, 6).reduce((acc, item) -> {
//            System.out.println("acc=" + acc);
//            acc += item;
//            System.out.println("item=" + item);
//            System.out.println("acc=" + acc);
//            System.out.println("-----------");
//            return acc;
//        });
//        Integer result = reduce.get();
//        System.out.println(result);


        // 两个入参的情况
//        Integer result2 = Stream.of(2, 3, 4, 5, 6).reduce(0, (acc, item) -> {
//            System.out.println("acc=" + acc);
//            acc += item;
//            System.out.println("item=" + item);
//            System.out.println("acc=" + acc);
//            System.out.println("-----------");
//            return acc;
//        });
//        System.out.println(result2);


        // 三个参数的情况
        ArrayList<Integer> reduce = Stream.of(2, 3, 4, 5, 6).reduce(new ArrayList<>(), (acc, item) -> {
            acc.add(item);
            System.out.println("item: " + item);
            System.out.println("acc+ : " + acc);
            System.out.println("BiFunction");
            return acc;
        }, (acc, item) -> {
            System.out.println("BinaryOperator");
            acc.addAll(item);
            System.out.println("item: " + item);
            System.out.println("acc+ : " + acc);
            System.out.println("--------");
            return acc;
        });
        System.out.println(reduce);


        List<BigDecimal> integerList = Arrays.asList(BigDecimal.ZERO, BigDecimal.TEN);
        BigDecimal result = integerList.stream().map(i -> i.multiply(BigDecimal.TEN)).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(String.format("reduce result is %s", result));


    }
}
