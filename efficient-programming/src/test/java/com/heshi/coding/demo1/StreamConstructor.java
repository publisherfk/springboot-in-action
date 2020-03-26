package com.heshi.coding.demo1;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamConstructor {

    @Test
    public void streamFromValue() {
        Stream stream = Stream.of(1, 2, 3, 4);
        stream.forEach(System.out::println);
    }

    @Test
    public void streamFromArray() {
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(numbers);
        stream.forEach(System.out::println);
    }

    @Test
    public void streamFromFile() throws IOException {
        Stream<String> stream = Files.lines(Paths.get("F:\\supFusion架构讨论-message.md"));
        stream.forEach(System.out::println);
    }

    @Test
    public void streamFromFunction() throws IOException {
        Stream stream = Stream.iterate(0, n -> n + 2);
        stream.forEach(System.out::println);
    }
}
