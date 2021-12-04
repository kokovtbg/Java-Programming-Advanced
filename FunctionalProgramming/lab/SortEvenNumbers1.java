package FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortEvenNumbers1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        Stream<String> stream = Arrays.stream(scan.nextLine().split(", "));
//        IntStream intStream = stream.mapToInt(Integer::parseInt);
//        int[] ints = intStream.toArray();
//        Stream<Integer> streamIntegers = stream.map(Integer::parseInt);
//        Integer[] integers = streamIntegers.toArray(Integer[]::new);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> evenNumber = numbers.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        Function<Stream<Integer>, String> mutator = x -> x.map(String::valueOf).collect(Collectors.joining(", "));
        String firstOutput = mutator.apply(evenNumber.stream());
        System.out.println(firstOutput);
        String secondOutput = mutator.apply(evenNumber.stream().sorted());
        System.out.println(secondOutput);
    }
}
