package AlgorithmsAndDateStructure.algorithms.task1_30.task29;

import java.io.*;

class Result {

    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */

    public static int beautifulDays(int i, int j, int k) {
        // Write your code here
        int countBeautifulDays = 0;
        int days = (j - i) + 1;
        while (days > 0) {
            String rev = new StringBuilder(String.valueOf(i)).reverse().toString();
            int reverse = Integer.parseInt(rev);
            if ((Math.abs(i - reverse)) % k == 0) {
                countBeautifulDays++;
            }
            days--;
            i++;
        }
        return countBeautifulDays;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);
        System.out.println(result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
