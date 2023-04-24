package AlgorithmsAndDateStructure.task1_100.task1;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int sumRightDiagonal = 0;
        int sumLeftDiagonal = 0;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(0).size(); j++) {
                if (i == j)
                    sumRightDiagonal += arr.get(i).get(j);
            }
        }
        int x = arr.size();
        int y = arr.get(0).size() - 1;
        for (int i = 0; i < x; i++) {
            for (int j = y; j >= 0; j--) {
                if (i == Math.abs(j - y))
                    sumLeftDiagonal += arr.get(i).get(j);
            }
        }

        int result = sumRightDiagonal - sumLeftDiagonal;
        return Math.abs(result);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
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

        int result = Result.diagonalDifference(arr);
        System.out.println(result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
