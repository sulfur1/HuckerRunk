package AlgorithmsAndDateStructure.algorithms.task31_60.task33;

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
     * Complete the 'minimumAbsoluteDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    /* No complete test case 3
    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - 1; i++) {
            int currentI = arr.get(i);
            for (int j = i + 1; j < arr.size(); j++) {
                int currentJ = arr.get(j);
                int abs = Math.abs(currentI - currentJ);
                if (abs == 0) return abs;
                if (abs < min) min = abs;
            }
        }
        return min;
    }*/
    public static int minimumAbsoluteDifference(List<Integer> arr) {
        arr.sort(null);
        int minDiff = Math.abs(arr.get(0) - arr.get(1));
        for (int i = 2; i < arr.size(); i++) {
            minDiff = Math.min(minDiff, Math.abs(arr.get(i) - arr.get(i - 1)));
            if (minDiff == 0) return 0;
        }

        minDiff = Math.min(minDiff, Math.abs(arr.get(arr.size() - 1) - arr.get(0)));

        return minDiff;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.minimumAbsoluteDifference(arr);
        System.out.println(result);
       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
