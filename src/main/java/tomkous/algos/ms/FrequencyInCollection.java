package tomkous.algos.ms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyInCollection {
	
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");

        // Stream, group by the item itself, and count occurrences
        Map<String, Long> frequencyMap = items.stream()
                .collect(Collectors.groupingBy(
                        item -> item, 
                        Collectors.counting()
                ));

        System.out.println(frequencyMap); 
        // Output: {banana=2, apple=3, cherry=1}
    }
}
