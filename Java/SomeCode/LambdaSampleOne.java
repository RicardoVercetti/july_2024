package Java.SomeCode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
// import java.util.stream.Stream;

public class LambdaSampleOne {
    
    public static void main(String[] args) {
         List<String> list = Arrays.asList("apple", null, "banana", null, "cherry");
        //  for (String item: list) {
        //     System.out.println(item);
        //  }

        // System.out.println("Hehe...");

        System.out.println( list.stream()
        .filter(Objects::nonNull)
        .map(String::toUpperCase)
        .sorted()
        .collect(Collectors.toList()));

        // System.out.println(iter.toArray());
    }
}
