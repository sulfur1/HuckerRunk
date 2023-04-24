package AlgorithmsAndDateStructure.task18;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        int countPairs = 0;
        int[] array = new int[101];

        for (int i = 0; i < ar.size(); i++) {
            array[ar.get(i)]++;
        }

        for (int i = 0; i < array.length; i++) {
            int temp = array[i];

            if (temp != 0 && temp != 1) {
                countPairs += temp / 2;
            }
        }
        return countPairs;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.sockMerchant(n, ar);
        System.out.println(result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

