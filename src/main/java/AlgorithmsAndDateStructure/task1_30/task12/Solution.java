package AlgorithmsAndDateStructure.task12;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int countMax = 0;
        int countMin = 0;
        int currentMinimum = scores.get(0);
        int currentMaximum = scores.get(0);

        List<Integer> integers = new ArrayList<>();

        label:
        for (int i = 1; i < scores.size(); i++) {
            int temp = scores.get(i);
            if (temp > currentMaximum) {
                countMax++;
                currentMaximum = temp;
            } else if (temp < currentMinimum) {
                countMin++;
                currentMinimum = temp;
            } else if (temp == currentMaximum || temp == currentMinimum) {
                continue label;
            }
        }
        integers.add(countMax);
        integers.add(countMin);

        return integers;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);
        result.forEach(i -> System.out.print(i + " "));
        /*bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

