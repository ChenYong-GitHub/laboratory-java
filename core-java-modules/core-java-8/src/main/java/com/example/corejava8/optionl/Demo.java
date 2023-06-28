package com.example.corejava8.optionl;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        String[] names = {"Tom", "Tony", "Jack"};
        Map<String, String> map = Arrays.stream(names).collect(Collectors.toMap(Objects::toString, name -> name + "Suffix"));
        Optional<String> sam = Optional.ofNullable(map.get("Sam"));
        String none = sam.orElse("None");
        System.out.println(none);

    }

}
