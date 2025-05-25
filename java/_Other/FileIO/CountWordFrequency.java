/*
 * Java File I/O:
 * 
 * Problem: Create a Java program that reads data from a text file
 * and counts the occurrences of each word. Display the word frequency
 * in descending order. Handle file I/O operations and exceptions properly.
 */
package _Other.FileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountWordFrequency {

    public static void main(String[] args) {
        String fileName = "sample.txt";
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display word frequency in descending order
        wordFrequencyMap
            .entrySet()
            .stream()
            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
            .forEach(entry ->
                System.out.println(entry.getKey() + ": " + entry.getValue() + " times")
            );
    }
}
