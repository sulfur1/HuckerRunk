package AlgorithmsAndDateStructure.data_structures.arrays.task2;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        List<Integer> sums = new ArrayList<>();

        int head_1_h = 0;
        int head_2_h = 1;
        int head_3_h = 2;
        int head_w = 0;
        int foot_w = 2;
        int middle_h = 1;
        int middle_w = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = arr.get(head_w).get(head_1_h)
                        + arr.get(head_w).get(head_2_h)
                        + arr.get(head_w).get(head_3_h)
                        + arr.get(middle_w).get(middle_h)
                        + arr.get(foot_w).get(head_1_h)
                        + arr.get(foot_w).get(head_2_h)
                        + arr.get(foot_w).get(head_3_h);

                sums.add(sum);
                head_1_h++;
                head_2_h++;
                head_3_h++;
                middle_h++;
            }
            head_1_h = 0;
            head_2_h = 1;
            head_3_h = 2;
            head_w++;
            foot_w++;
            middle_h = 1;
            middle_w++;
        }
        return sums.stream().max(Integer::compareTo).orElse(-1);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));*/

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);
        System.out.println(result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/

        bufferedReader.close();
        /*bufferedWriter.close();*/
    }
}

