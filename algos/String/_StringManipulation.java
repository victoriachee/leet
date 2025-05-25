package algos.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _StringManipulation {

    /**
     * Reverses a string.
     *
     * @param s The input string.
     * @return The reversed string.
     */
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;

        // Swap characters from both ends towards the center
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return new String(chars);
    }

    // -----------------------------------------------------------
    /**
     * Checks if a string is a palindrome.
     *
     * @param s The input string.
     * @return True if the string is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;

        // Move two pointers towards the center, ignoring non-alphanumeric characters
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Check if characters at both pointers are equal
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    // -----------------------------------------------------------
    /**
     * Finds the longest common prefix among an array of strings.
     *
     * @param strs The array of strings.
     * @return The longest common prefix.
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Sort the array to bring the strings with common prefixes closer
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        int len = Math.min(first.length(), last.length());
        int i = 0;

        // Compare characters at the same position in the first and last strings
        while (i < len && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        // Return the common prefix
        return first.substring(0, i);
    }

    // -----------------------------------------------------------
    /**
     * Removes all leading and trailing whitespaces from a string.
     *
     * @param s The input string.
     * @return The string with leading and trailing whitespaces removed.
     */
    public static String trimWhitespace(String s) {
        return s.trim();
    }

    // -----------------------------------------------------------
    /**
     * Converts a string to lowercase.
     *
     * @param s The input string.
     * @return The string in lowercase.
     */
    public static String toLowerCase(String s) {
        return s.toLowerCase();
    }

    // -----------------------------------------------------------
    /**
     * Counts the occurrences of each character in a string.
     *
     * @param s The input string.
     * @return A map where keys are characters, and values are their counts.
     */
    public static Map<Character, Integer> countCharacters(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        return charCountMap;
    }

    // -----------------------------------------------------------
    /**
     * Checks if two strings are anagrams.
     *
     * @param s1 The first input string.
     * @param s2 The second input string.
     * @return True if the strings are anagrams, false otherwise.
     */
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : s1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            int count = charCountMap.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            }
            charCountMap.put(c, count - 1);
        }

        return true;
    }

    // -----------------------------------------------------------
    /**
     * Replaces spaces in a string with a specified replacement.
     *
     * @param s          The input string.
     * @param replacement The string to replace spaces with.
     * @return The modified string.
     */
    public static String replaceSpacesUsingRegex(String s, String replacement) {
        return s.replaceAll("\\s+", replacement);
        //   String original = "Hello, World!";
        //   String replaced = original.replaceAll("[aeiou]", "*");
        //   // Result: H*ll*, W*rld!
    }

    // -----------------------------------------------------------
    /**
     * Checks if a string has all unique characters.
     *
     * @param s The input string.
     * @return True if all characters are unique, false otherwise.
     */
    public static boolean hasUniqueCharacters(String s) {
        boolean[] charSet = new boolean[256];

        for (char c : s.toCharArray()) {
            int index = (int) c;
            if (charSet[index]) {
                return false;
            }
            charSet[index] = true;
        }

        return true;
    }

    // -----------------------------------------------------------
    /**
     * Finds the first non-repeating character in a string.
     *
     * @param s The input string.
     * @return The first non-repeating character or '\0' if none found.
     */
    public static char firstNonRepeatingChar(String s) {
        int[] charCount = new int[256];

        for (char c : s.toCharArray()) {
            charCount[c]++;
        }

        for (char c : s.toCharArray()) {
            if (charCount[c] == 1) {
                return c;
            }
        }

        return '\0';
    }

    // -----------------------------------------------------------
    /**
     * Checks if two strings are rotations of each other.
     *
     * @param s1 The first input string.
     * @param s2 The second input string.
     * @return True if the strings are rotations, false otherwise.
     */
    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String concatenated = s1 + s1;
        return concatenated.contains(s2);
    }

    // -----------------------------------------------------------
    /**
     * Removes duplicate characters from a string.
     *
     * @param s The input string.
     * @return The string with duplicate characters removed.
     */
    public static String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256]; // Assuming ASCII characters

        for (char c : s.toCharArray()) {
            if (!seen[c]) {
                result.append(c);
                seen[c] = true;
            }
        }

        return result.toString();
    }

    // -----------------------------------------------------------
    /**
     * Replaces spaces in a string with '%20'.
     *
     * @param s The input string with spaces.
     * @return The string with spaces replaced by '%20'.
     */
    public static String urlify(String s) {
        return s.trim().replaceAll("\\s+", "%20");
    }

    // -----------------------------------------------------------
    /**
     * Counts the number of vowels in a string.
     *
     * @param s The input string.
     * @return The number of vowels in the string.
     */
    public static int countVowels(String s) {
        int count = 0;
        String lowerCaseString = s.toLowerCase();
        for (char c : lowerCaseString.toCharArray()) {
            if ("aeiou".contains(String.valueOf(c))) {
                count++;
            }
        }
        return count;
    }

    // -----------------------------------------------------------
    /**
     * Capitalizes the first letter of each word in a sentence.
     *
     * @param s The input sentence.
     * @return The sentence with capitalized words.
     */
    public static String capitalizeWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) {
                result
                    .append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
            }
        }
        return result.toString().trim();
    }

    // -----------------------------------------------------------
    /**
     * Replaces spaces with a specified character in a string.
     *
     * @param s          The input string.
     * @param replacement The character to replace spaces with.
     * @return The string with spaces replaced.
     */
    public static String replaceSpaces(String s, char replacement) {
        return s.replace(' ', replacement);
    }

    public static void main(String[] args) {
        // Example usage
        String inputString = "hello";
        System.out.println("Reversed String: " + reverseString(inputString));

        String palindromeString = "A man, a plan, a canal, Panama";
        System.out.println("Is Palindrome: " + isPalindrome(palindromeString));

        String[] stringsArray = { "flower", "flow", "flight" };
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(stringsArray));
        // Example usage
        String sampleString = "hello world";
        System.out.println("Character Counts: " + countCharacters(sampleString));

        String anagram1 = "listen";
        String anagram2 = "silent";
        System.out.println("Are Anagrams: " + areAnagrams(anagram1, anagram2));

        String stringWithSpaces = "This is a sample sentence.";
        System.out.println("Replace Spaces: " + replaceSpacesUsingRegex(stringWithSpaces, "_"));

        String uniqueCharsString = "abcde";
        System.out.println("Has Unique Characters: " + hasUniqueCharacters(uniqueCharsString));

        String nonRepeatingString = "leetcode";
        System.out.println(
            "First Non-Repeating Char: " + firstNonRepeatingChar(nonRepeatingString)
        );

        String rotation1 = "waterbottle";
        String rotation2 = "erbottlewat";
        System.out.println("Are Rotations: " + areRotations(rotation1, rotation2));

        String stringWithDuplicates = "programming";
        System.out.println("Remove Duplicates: " + removeDuplicates(stringWithDuplicates));

        String stringWithSpacesURLify = "Hello World Java Programming   ";
        System.out.println("URLify: " + urlify(stringWithSpacesURLify));

        String vowelsString = "Hello World";
        System.out.println("Count Vowels: " + countVowels(vowelsString));

        String sentenceToCapitalize = "this is a sample sentence.";
        System.out.println("Capitalized Words: " + capitalizeWords(sentenceToCapitalize));

        String stringWithSpaces2 = "Replace spaces with character";
        System.out.println("Replace Spaces: " + replaceSpaces(stringWithSpaces2, '_'));
    }
}
