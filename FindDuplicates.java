package tomkous.algos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FindDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter a string ");
		
		String s = sc.nextLine();
		
		sc.close();
		
		findDuplicates(s);
		
		System.out.println(hasDuplicates(s));
	}

	public static void findDuplicates(String s){
		
		Map<Character, Integer> map = new HashMap<>();
		
		char[] characters = s.toCharArray();
		
		for(char c:characters){
			
			if (!map.containsKey(c)){
				map.put(c, 1);
			}else{
				map.put(c, map.get(c)+1);
			}
		}
		
		Set<Map.Entry<Character, Integer>> entrySet=map.entrySet();
		for(Map.Entry<Character, Integer> e:entrySet){
			if(e.getValue()>1)
			 System.out.println(e);
		}		
	}
	
	public static boolean hasDuplicates(String s){
		
		Map<Character, Integer> map = new HashMap<>();
		
		char[] characters = s.toCharArray();
		
		for(char c:characters){
			
			if (!map.containsKey(c)){
				map.put(c, 1);
			}else{
				map.put(c, map.get(c)+1);
				return true;
			}
		}
		return false;
	}
}
