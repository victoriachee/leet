/*
 * Java Exception Handling:
 * 
 * Problem: Write a Java program that reads an integer from the user.
 * Handle exceptions appropriately to ensure that if the input is not
 * an integer, the program doesn't crash, and the user is prompted to
 * enter a valid integer.
 */

package _Other;

import java.util.Scanner;

public class InputExceptionHandler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter an integer: ");
            int userInput = scanner.nextInt();
            System.out.println("You entered: " + userInput);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        } finally {
            scanner.close();
        }
    }
}
