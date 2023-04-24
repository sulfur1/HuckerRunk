package AlgorithmsAndDateStructure.task15;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        int[] array = new int[6];

        for (int i = 0; i < arr.size(); i++) {
            array[arr.get(i)]++;
        }

        int max = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == max)
                return i;
        }
        return 0;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.migratoryBirds(arr);

        System.out.println(result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
