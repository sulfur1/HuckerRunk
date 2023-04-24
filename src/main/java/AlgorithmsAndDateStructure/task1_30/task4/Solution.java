package AlgorithmsAndDateStructure.task1_30.task4;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        List<Long> sumList = new ArrayList<>();
        // Write your code here
        long tempSum;
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            tempSum = 0;
            for (int j = 0; j < arr.size(); j++) {
                if (i == j) {
                    continue;
                }
                tempSum += arr.get(j);
            }
            sumList.add(tempSum);

        }
        Optional<Long> max = sumList.stream().max(Long::compare);
        Optional<Long> min = sumList.stream().min(Long::compare);

        System.out.println(String.format("%d %d", min.get(), max.get()));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
