package AlgorithmsAndDateStructure.task20;

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
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
        // Write your code here
        if (p == 1) return 0;
        //if even
        boolean chet = (n & 1) == 0;
        if (chet && n == p) {
            return 0;
        }
        // if odd
        boolean nechet = (n & 1) != 0;
        if (nechet && (p == n || p == n - 1)) return 0;

        int selectSide = n / 2;

        if (p <= selectSide) {
            int countStartPage = 1;

            for (int i = 1; i <= n; i = i + 2) {
                if (p == i + 1 || p == i + 2) break;
                else countStartPage++;
            }

            return countStartPage;

        } else {

            int countLastPage = 1;

            if (chet) {
                for (int i = n; i >= 1; i = i - 2) {
                    if (p == i - 1 || p == i - 2) break;
                    else countLastPage++;
                }
            } else {
                for (int i = n - 1; i >= 0; i = i - 2) {
                    if (p == i - 1 || p == i - 2) break;
                    else countLastPage++;
                }
            }

            return countLastPage;
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        /*int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());*/

        int result = Result.pageCount(12, 11);

        System.out.println(result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/

        //bufferedReader.close();
        //bufferedWriter.close();
    }
}
