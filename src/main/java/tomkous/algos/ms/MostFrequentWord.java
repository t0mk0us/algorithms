package tomkous.algos.ms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentWord {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\tomko\\Desktop\\word_frequency_test.txt"; // Replace with your file path
        findMostFrequentWord(filePath);
    }

    public static void findMostFrequentWord(String filePath) {
        // Map to store word frequencies
        Map<String, Long> wordCounts = new HashMap<>();

        // 1. Stream through the file line-by-line to save memory
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
            	System.out.println(line);
                // Split lines by non-alphanumeric characters and lowercase them
                String[] words = line.toLowerCase().split("[^a-zA-Z0-9]+");
                //System.out.println(words);
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        // Increment count in map
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0L) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // 2. Find the entry with the highest frequency
        String mostFrequentWord = null;
        long maxCount = 0;

        for (Map.Entry<String, Long> entry : wordCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }

        // Print results
        if (mostFrequentWord != null) {
            System.out.println("Most frequent word: '" + mostFrequentWord + "'");
            System.out.println("Appearance count: " + maxCount);
        } else {
            System.out.println("No valid words found in the file.");
        }
    }
}

