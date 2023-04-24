package AlgorithmsAndDateStructure.task13;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */

    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int count = 0;

        if (s.size() == 1) {
            return s.get(0) == d ? 1 : 0;
        }
        label:
        for (int i = 0; i < s.size();) {
            int temp = i + m - 1;
            if (temp < s.size()) {
                int sum1 = 0;
                while (temp >= i) {
                    sum1 += s.get(temp);
                    temp--;
                }
                if (sum1 == d) {
                    count++;
                } else {
                    i++;
                    continue label;
                }
                i++;
                /*i += m - 1;
                int temp1 = i + m - 1;
                if (temp1 < s.size()) {
                    int sum2 = 0;
                    while (temp1 >= i) {
                        sum2 += s.get(temp1);
                        temp1--;
                    }
                    if (sum2 == d) {
                        count++;
                        i += m;
                    } else {
                        i += m - 1;
                    }
                } else {
                    break label;
                }*/

            } else {
                break label;
            }
        }
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.birthday(s, d, m);

        System.out.println(result);

       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

