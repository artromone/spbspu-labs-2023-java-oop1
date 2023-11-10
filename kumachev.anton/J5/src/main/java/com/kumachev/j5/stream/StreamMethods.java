package com.kumachev.j5.stream;

import org.javatuples.Pair;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethods {
    public static double avg(Stream<Integer> coll) {
        Pair<Integer, Integer> info = coll.reduce(
                new Pair<>(0, 0),
                (u, i) -> new Pair<>(u.getValue0() + i, u.getValue1() + 1),
                (a, b) -> a
        );

        return (double) info.getValue0() / info.getValue1();
    }

    public static Stream<String> toUpperCase(Stream<String> stream) {
        return stream.map(s -> "_new_" + s.toUpperCase());
    }

    public static Stream<Integer> sqrDistinct(Stream<Integer> stream) {
        Map<Integer, Integer> counts = stream.collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));

        return counts
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .map(i -> i * i);
    }

    public static Stream<String> filterSort(Stream<String> stream, char ch) {
        return stream
                .filter(s -> !s.isEmpty() && s.charAt(0) == ch)
                .sorted();
    }

    public static <T> T last(Stream<T> coll) {
        return coll.reduce((first, second) -> second).orElseThrow();
    }

    public static int evenSum(Stream<Integer> stream) {
        return stream
                .filter(i -> i % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Map<Character, String> stringsToMaps(Stream<String> stream) {
        return stream
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toMap(s -> s.charAt(0), s -> s.substring(1)));
    }
}
