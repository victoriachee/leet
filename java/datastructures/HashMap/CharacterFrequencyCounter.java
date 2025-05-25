package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Java program to count the frequency of each character in a string using a Map.
 */
public class CharacterFrequencyCounter {
    /**
     * Counts the frequency of each character in the given string.
     *
     * @param inputString The input string.
     * @return A Map containing characters as keys and their frequencies as values.
     */
    public static Map<Character, Integer> countCharacterFrequency(String inputString) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : inputString.toCharArray()) {
            // Ignore spaces
            if (c != ' ') {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
        }

        return freqMap;
    }

    public static void main(String[] args) {
        String inputString = "hello world";
        Map<Character, Integer> result = countCharacterFrequency(inputString);

        System.out.println("Character Frequencies:");
        for (Map.Entry<Character, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
