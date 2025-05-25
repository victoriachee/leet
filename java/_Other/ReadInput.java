package _Other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadInput {

   private static void scanLine(Scanner scanner) throws IOException {
      StringBuilder sBuilder = new StringBuilder();

    //   Scanner scanner = new Scanner(System.in);
      System.out.print("Enter an integer and a string separated by a space: ");
      int num2 = scanner.nextInt();
      String text2 = scanner.next();

      sBuilder.append(num2);
      System.out.println(sBuilder);

      sBuilder.append(text2);
      System.out.println(sBuilder);

    //   scanner.close();
   }

   private static void readLine(BufferedReader reader) throws IOException {
      StringBuilder sBuilder = new StringBuilder();

    //   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

      System.out.print("Enter an integer and a string separated by a space: ");
      String inputLine = reader.readLine();

      // Split the line by space
      String[] parts = inputLine.split(" ");

      // Parse the integer and string from the array
      int intValue = Integer.parseInt(parts[0]);
      String stringValue = parts[1];

      sBuilder.append(intValue);
      System.out.println(sBuilder);
      sBuilder.append(stringValue);
      System.out.println(sBuilder);

    //   reader.close();
   }

   public static void main(String[] args) throws Exception {
      Scanner scanner = new Scanner(System.in);
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

      scanLine(scanner);
      readLine(reader);

      scanner.close();
      reader.close();
   }
}
