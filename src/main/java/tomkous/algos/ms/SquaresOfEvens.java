package tomkous.algos.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SquaresOfEvens {
	
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,5,6,3,8,4);
        
        List<Integer> evens = numbers.stream()
        		.filter(n -> n%2==0)
                .map(n -> n * n)              // Map: Square each remaining number
                .toList(); 

        System.out.println(evens);
    }
}
