package HashMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _HashMapOperations {

   public static void main(String[] args) {
      // [ BASIC ]

      //* 1. Make Unique List
      HashMap<Integer, String> uniqueMap = new HashMap<>();
      uniqueMap.put(1, "apple");
      uniqueMap.put(2, "banana");
      uniqueMap.put(1, "grape"); // Duplicate key, will overwrite the previous value

      //* 2. Check if Key Exists
      HashMap<String, Integer> populationMap = new HashMap<>();
      populationMap.put("USA", 331000000);
      populationMap.put("China", 1444216107);
      populationMap.put("India", 1393409038);
      String keyToCheck = "USA";
      Boolean exists = populationMap.containsKey("USA");

      //* 3. Remove Entry by Key
      populationMap.remove("China");

      //* 4. Clear Map
      uniqueMap.clear();

      // [ ITERATION ]

      //* 5. Iterate Over Entries
      for (Map.Entry<String, Integer> entry : populationMap.entrySet()) {
         System.out.println("Country: " + entry.getKey() + ", Population: " + entry.getValue());
      }
      for (String key : populationMap.keySet()) {
         System.out.println("Country: " + key);
      }
      for (Integer value : populationMap.values()) {
         System.out.println("Population: " + value);
      }

      // [ SIZE & DEFAULT VALUES ]

      //* 6. Get Size
      int size = populationMap.size();

      //* 7. Get Value or Default Value
      int usaPopulation = populationMap.getOrDefault("USA", 0);
      int brazilPopulation = populationMap.getOrDefault("Brazil", 0);

      // [ SET & LIST OPERATIONS ]

      //* 8. Get New Set / HashSet of Keys
      Set<String> countries = populationMap.keySet();
      HashSet<String> countriesSet = new HashSet<>(populationMap.keySet());

      //* 9. Get New Collection / List of Values
      Collection<Integer> populations = populationMap.values();
      List<Integer> populationsList = new ArrayList<>(populationMap.values());

      // [ ADVANCED OPERATIONS ]

      //* 10. Compute Updated Values
      populationMap.compute("USA", (key, value) -> value * 2);

      //* 11. Merge Maps (Will overwrite value)
      HashMap<String, Integer> additionalMap = new HashMap<>();
      additionalMap.put("Russia", 145912025);
      populationMap.putAll(additionalMap);

      //* 12. Sum Values of Same Key Using Merge Function (No overwrite)
      HashMap<String, Integer> destinationMap = new HashMap<>();
      HashMap<String, Integer> sourceMap = new HashMap<>();

      // Populating the destination map
      destinationMap.put("A", 1);
      destinationMap.put("B", 2);
      destinationMap.put("C", 3);

      // Populating the source map
      sourceMap.put("B", 20);
      sourceMap.put("C", 30);
      sourceMap.put("D", 40);

      // Merging the source map into the destination map using the merge function
      // For each key-value pair in the source map, check if the key exists in the destination map
      // If it exists, sum the values. If it doesn't, add the key-value pair to the destination map.
      sourceMap.forEach((key, value) ->
         destinationMap.merge(key, value, (oldValue, newValue) -> oldValue + newValue)
      );

      // The final state of destinationMap will be:
      // {"A": 1, "B": 22, "C": 33, "D": 40}
      // Explanation:
      // - "A" remains unchanged as it only exists in destinationMap
      // - "B" is updated to 22 (2 + 20)
      // - "C" is updated to 33 (3 + 30)
      // - "D" is added with value 40 as it only exists in sourceMap
      

      // [ DISPLAY ]

      System.out.println("Key '" + keyToCheck + "' exists in the HashMap: " + exists);
      System.out.println("Number of entries: " + size);
      System.out.println("USA population: " + usaPopulation);
      System.out.println("Brazil population: " + brazilPopulation);

      System.out.println("Get a Set of Keys:");
      System.out.println(countries);
      System.out.println(countriesSet);

      System.out.println("Get a Collection of Values:");
      System.out.println(populations);
      System.out.println(populationsList);

      System.out.println("Destination Map after merge:");
      System.out.println(destinationMap);
   }
}
