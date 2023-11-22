package org.amalitech.Streams;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static int sumList(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static List<String> uppercaseStrings(List<List<String>> list) {
        return list.stream()
                .flatMap(List::stream)
                .filter(s -> s.length() > 4)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static List<Double> cubeOfNumbers(List<Double> list) {
        return list.stream()
                .mapToDouble(d -> d * d * d)
                .boxed()
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {

        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        Integer sum = sumList(integerList);
        System.out.println("Sum of integers: " + sum);

        List<String> stringElements = List.of("Anna", "Drake", "Anita", "Jude");
        String uppercaseString = String.valueOf(uppercaseStrings(Collections.singletonList(stringElements)));
        System.out.println("Uppercase of some strings: " + uppercaseString);

        List<Double> cubeNumbers = List.of(6.98, 6.08, 3.11, 5.54, 3.0, 2.0);
        List<Double> cubedNumber = cubeOfNumbers(cubeNumbers);
        System.out.println(cubedNumber);
    }
}

