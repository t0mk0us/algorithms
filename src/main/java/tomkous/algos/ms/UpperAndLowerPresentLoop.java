package tomkous.algos.ms;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class UpperAndLowerPresentLoop {

    public static void main(String[] args) {
        String str = "AnmUTsyutNaM";
        
        Set<Character> lowerCaseSet = new HashSet<>();
        Set<Character> matchingUpper = new LinkedHashSet<>(); // Keeps insertion order

        // First pass: Store all lowercase characters
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowerCaseSet.add(c);
            }
        }

        // Second pass: Check uppercase characters
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c) && lowerCaseSet.contains(Character.toLowerCase(c))) {
                matchingUpper.add(c);
            }
        }

        // Format and print output
        System.out.println(matchingUpper.toString().replaceAll("[\\[\\] ]", ""));
    }
}
