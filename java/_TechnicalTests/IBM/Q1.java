package _TechnicalTests.IBM;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'sortItems' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY items as parameter.
     */

    public static List<Integer> sortItems(List<Integer> items) {
      HashMap<Integer, Integer> frequency = new HashMap<>();
      for (int num : items) {
        frequency.put(num, frequency.getOrDefault(num, 0) + 1);
      }
      
      items.sort((a, b) -> {
        int freqCompared = Integer.compare(frequency.get(a), frequency.get(b));
        
        // If freq is different return result of freqCompared else compare val
        return freqCompared != 0 ? freqCompared : Integer.compare(a, b);
      });
      
      return items;
    }

}

public class Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int itemsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> items = IntStream.range(0, itemsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.sortItems(items);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
