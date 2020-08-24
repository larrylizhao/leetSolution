package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 *  展示如何操作Optional的stream
 */
public class OptionalStream {
    public static void main(String[] args) {
        List<Optional<String>> listOfOptionals = Arrays.asList(
                Optional.empty(),
                Optional.of("foo"),
                Optional.empty(),
                Optional.of("bar"));

        //方法一: 使用filter
        List<String> filteredList = listOfOptionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        //方法二: 使用flatMap
        List<String> filteredList_fm = listOfOptionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        List<String> filteredList_fm2 = listOfOptionals.stream()
                .flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty))
                .collect(Collectors.toList());

        //方法三: 使用Java 9中的Optional::stream
        List<String> filteredList_os = listOfOptionals.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
    }
}
