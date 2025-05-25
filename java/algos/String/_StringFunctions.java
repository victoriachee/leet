package algos.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _StringFunctions {
    public static void main(String[] args) {
        // Sample strings
        String s1 = "Hello, World!";
        String s2 = "Java programming is fun.";
        String s3 = "   Leading and trailing spaces   ";

        // length() - Get the length of the string
        System.out.println("Length of s1: " + s1.length());

        // substring() - Extract a substring
        System.out.println("Substring of s1 (7, 12): " + s1.substring(7, 12));

        // contains() - Check if a string contains a sequence of characters
        System.out.println("s2 contains 'programming': " + s2.contains("programming"));

        // indexOf() - Find the index of a character or substring
        System.out.println("Index of 'World' in s1: " + s1.indexOf("World"));

        // charAt() - Get the character at a specific index
        System.out.println("Character at index 4 in s1: " + s1.charAt(4));

        // toUpperCase() - Convert the string to uppercase
        System.out.println("s1 in uppercase: " + s1.toUpperCase());

        // toLowerCase() - Convert the string to lowercase
        System.out.println("s2 in lowercase: " + s2.toLowerCase());

        // trim() - Remove leading and trailing spaces
        System.out.println("s3 after trim: '" + s3.trim() + "'");

        // replace() - Replace all occurrences of a character or substring
        System.out.println("s2 after replacing 'fun' with 'awesome': " + s2.replace("fun", "awesome"));

        // split() - Split the string into an array based on a delimiter
        String[] words = s1.split(", ");
        System.out.println("Words in s1:");
        for (String word : words) {
            System.out.println(word);
        }

        // equals() - Check if two strings are equal
        String s4 = "Hello, World!";
        System.out.println("s1 equals s4: " + s1.equals(s4));

        // equalsIgnoreCase() - Check if two strings are equal, ignoring case
        String s5 = "hello, world!";
        System.out.println("s1 equalsIgnoreCase s5: " + s1.equalsIgnoreCase(s5));

        // startsWith() - Check if the string starts with a prefix
        System.out.println("s1 starts with 'Hello': " + s1.startsWith("Hello"));

        // endsWith() - Check if the string ends with a suffix
        System.out.println("s2 ends with 'fun.': " + s2.endsWith("fun."));

        // isEmpty() - Check if the string is empty
        String s6 = "";
        System.out.println("s6 is empty: " + s6.isEmpty());

        // format() - Format the string using placeholders
        String formattedString = String.format("Name: %s, Age: %d", "Alice", 30);
        System.out.println("Formatted string: " + formattedString);

        // join() - Join multiple strings with a delimiter
        String joinedString = String.join(", ", "Java", "Python", "C++");
        System.out.println("Joined string: " + joinedString);

        // toCharArray() - Convert the string to a char array
        char[] strArray = s1.toCharArray();
        System.out.println("Character array of s1:");
        for (char ch : strArray) {
            System.out.print(ch + " ");
        }
        System.out.println();

        // String.valueOf() - Convert various types to string
        int number = 123;
        double pi = 3.14159;
        boolean bool = true;

        String numberStr = String.valueOf(number); // Convert int to string
        String piStr = String.valueOf(pi); // Convert double to string
        String boolStr = String.valueOf(bool); // Convert boolean to string

        System.out.println("String value of int: " + numberStr);
        System.out.println("String value of double: " + piStr);
        System.out.println("String value of boolean: " + boolStr);

        // Arrays.toString() - Convert an array to a string
        int[] intArray = {1, 2, 3, 4, 5};
        String intArrayStr = Arrays.toString(intArray);
        System.out.println("String value of int array: " + intArrayStr);

        // List.toString() - Convert a list to a string
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        String listStr = list.toString();
        System.out.println("String value of list: " + listStr);

        // Stack.toString() - Convert a stack to a string
        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        String stackStr = stack.toString();
        System.out.println("String value of stack: " + stackStr);
    }
    
}
