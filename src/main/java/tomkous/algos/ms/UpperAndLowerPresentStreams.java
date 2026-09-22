package tomkous.algos.ms;

import java.util.Set;
import java.util.stream.Collectors;

public class UpperAndLowerPresentStreams {
	
    public static void main(String[] args) {
        String str = "AnTMNNNmUTsyAUutNaM";
        
        // 1. Collect all lowercase characters into a Set for O(1) lookups
        Set<Character> lowerCaseSet = str.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLowerCase)
                .collect(Collectors.toSet());

        // 2. Filter uppercase characters that have their lowercase form in the set
        String result = str.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isUpperCase)
                .filter(c -> lowerCaseSet.contains(Character.toLowerCase(c)))
                .distinct() // Remove duplicates if the same uppercase letter appears twice
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        // Output: A,U,Y
        System.out.println(result); 
    }
}
