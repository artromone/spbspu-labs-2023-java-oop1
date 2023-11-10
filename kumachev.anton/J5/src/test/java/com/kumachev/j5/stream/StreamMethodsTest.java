package com.kumachev.j5.stream;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StreamMethodsTest {

    @Test
    void avg() {
        Integer[] ints = {2, 3, 4, 5};
        double avg = StreamMethods.avg(Arrays.stream(ints));
        assertEquals(3.5, avg, 0);
    }

    @Test
    void toUpperCase() {
        String[] strings = {"string", "", "_new_string"};
        strings = StreamMethods.toUpperCase(Arrays.stream(strings)).toArray(String[]::new);

        assertArrayEquals(new String[]{"_new_STRING", "_new_", "_new__NEW_STRING"}, strings);
    }

    @Test
    void sqrDistinct() {
        Integer[] ints = {1, 2, 3, 4, 5, 3, 2, 3};
        ints = StreamMethods.sqrDistinct(Arrays.stream(ints)).toArray(Integer[]::new);
        assertArrayEquals(new Integer[]{1, 16, 25}, ints);
    }

    @Test
    void filterSort() {
        String[] strings = {"phone", "school", "glass", "bed", "bottle", "window", "shoes", "shirt"};
        strings = StreamMethods.filterSort(Arrays.stream(strings), 's').toArray(String[]::new);
        assertArrayEquals(new String[]{"school", "shirt", "shoes"}, strings);
    }

    @Test
    void last() {
        Object[] objects = {1, "d", 1.4};
        Object last = StreamMethods.last(Arrays.stream(objects));
        assertEquals(objects[objects.length - 1], last);

        assertThrows(NoSuchElementException.class, () -> StreamMethods.last(Stream.empty()));
    }

    @Test
    void evenSum() {
        Integer[] ints = {1, 2, 3, 4, 5, 3, 2, 3};
        int sum = StreamMethods.evenSum(Arrays.stream(ints));
        assertEquals(8, sum);
    }

    @Test
    void stringsToMaps() {
        String[] strings = {"phone", "school", "glass", "bed", "window", "l", ""};
        Map<Character, String> map = StreamMethods.stringsToMaps(Arrays.stream(strings));

        assertEquals("hone", map.get('p'));
        assertEquals("chool", map.get('s'));
        assertEquals("lass", map.get('g'));
        assertEquals("ed", map.get('b'));
        assertEquals("indow", map.get('w'));
        assertEquals("", map.get('l'));
    }
}
