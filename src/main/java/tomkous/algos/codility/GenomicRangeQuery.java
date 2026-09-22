package tomkous.algos.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenomicRangeQuery {
	
	public static int[] solution(String S, int[] P, int[] Q) {
		
	int[] minImpacts = new int[P.length];
	//String currPart = "";
	CharSequence impacts = "ACGT";
	
	System.out.println("DNA is " + S);
	
	for (int i = 0; i < P.length; i++) {
		
		String dnaPart = S.substring(P[i], Q[i]+1);
		//int min = 4;
		
		System.out.println("From " + P[i] + " to " + Q[i]);
		System.out.println("DNA part is " + dnaPart);
		
		for (int j = 0; j < impacts.length(); j++) {
			
			if(dnaPart.contains(impacts.subSequence(j, j+1))) {
				
				System.out.println("Found " + impacts.subSequence(j, j+1));
				minImpacts[i] = j+1;
				break;
				}
			}
		}
	return minImpacts;
	}

	public static void main(String[] args) {
		
		String dna = "CAGCCTA";
		int[] p = {2, 5, 0};
		int[] q = {4, 5, 6};
		
		System.out.println("The minimal impacts of nucleotides in the DNA sequences defined by from " + Arrays.toString(p) 
			+ " to " + Arrays.toString(q) + " of the DNA sequence " + dna + " are " + Arrays.toString(solution(dna, p, q)));
	}
}
