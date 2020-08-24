package Stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 使用stream在Integer List中寻找最小值
 */
public class IntegerStream {
    /**
     * 1. 使用mapToInt转换成IntStream
     */
    public static Integer findMin(List<Integer> list) {
        return list.stream()                    // Stream<Integer>
                .mapToInt(v -> v)               // IntStream
                .min()                          // OptionalInt
                .orElse(Integer.MAX_VALUE);     // Integer
    }

    /**
     * 2. 使用stream.min()
     */
    public static Integer findMin_comparator(List<Integer> list) {
        return list.stream()                        // Stream<Integer>
                .min(Comparator.naturalOrder())     // Optional<Integer>
                .get();                             // Integer
    }

    public static Integer findMin_integer(List<Integer> list) {
        return list.stream()                // Stream<Integer>
                .min(Integer::compare)      // Optional<Integer>
                .get();                     // Integer
    }

    /**
     * 3. 使用reduce
     */
    public static Integer findMin_reduce(List<Integer> list) {
        return list.stream()                // Stream<Integer>
                .reduce(Integer::min)       // Optional<Integer>
                .get();                     // Integer
    }

    /**
     * 4. 使用collectors
     */
    //Collectors::minBy
    public static Integer findMin_minBy(List<Integer> list) {
        return list.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()))
                .get();
    }

    //Collectors::summarizingInt
    public static Integer findMin_summarizingInt(List<Integer> list) {
        return list.stream()
                .collect(Collectors.summarizingInt(Integer::intValue))
                .getMin();
    }

    /**
     * 5. 使用sorting
     */
    public static Integer findMin_sort(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return Integer.MAX_VALUE;
        }

        return list.stream()
                .sorted()
                .findFirst()
                .get();
    }
}

