package tomkous.algos.ms;

import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyInString {
	
	    public static void main(String[] args) {
	        String input = "hello world";

	        // 1. Get IntStream of character codes
	        Map<Character, Long> charFrequencyMap = input.chars()
	                // 2. Map primitive int to Character object
	                .mapToObj(c -> (char) c)
	                // 3. Group by character and count
	                .collect(Collectors.groupingBy(
	                        ch -> ch, 
	                        Collectors.counting()
	                ));

	        System.out.println(charFrequencyMap); 
	        // Output: { =1, r=1, d=1, e=1, w=1, h=1, l=3, o=2}
	    }
}
