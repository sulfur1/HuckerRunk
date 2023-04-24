package AlgorithmsAndDateStructure.task1_100.task1.task2;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int countPositive = 0;
        int countNegative = 0;
        int countZero = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                countPositive++;
            } else if (arr.get(i) < 0) {
                countNegative++;
            } else {
                countZero++;
            }
        }

        double pozitive = ((double) countPositive) / arr.size();
        double negative = ((double) countNegative) / arr.size();
        double zero = ((double) countZero) / arr.size();

        System.out.println(String.format("%.6f", pozitive));
        System.out.println(String.format("%.6f", negative));
        System.out.println(String.format("%.6f", zero));

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
