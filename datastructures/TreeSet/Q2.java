package TreeSet;
import java.util.*;

public class Q2 {


    public static List<Integer> toRelativeAlert(List<Integer> alerts) {
        // Use TreeSet to get distinct & ordered set of og severities
        TreeSet<Integer> distSevs = new TreeSet<>(alerts);
        
        // Map sorted distinct severities to minimal values
        HashMap<Integer, Integer> distMinMap = new HashMap<>();
        int minVal = 1;
        for (int sev: distSevs) {
          distMinMap.put(sev, minVal++);
        }
        
        // Create list with og sevs replaced with min sevs
        List<Integer> res = new ArrayList<>();
        for (int sev: alerts) {
          res.add(distMinMap.get(sev));
        }
        return res;
    }

    public static void main(String[] args) {
        // Example
        List<Integer> input = Arrays.asList(7, 18, 60, 92, 35, 5, 97, 65);
        List<Integer> output = toRelativeAlert(input);
        System.out.println(output);
    }
}
