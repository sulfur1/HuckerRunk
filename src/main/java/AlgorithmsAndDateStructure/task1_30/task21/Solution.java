package AlgorithmsAndDateStructure.task1_30.task21;

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
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        boolean isOutOfBounds;
        int countValley = 0;
        int zero = 0;
        char uphill = 'U';
        int countUphill;


        label:
        for (int i = 0; i < steps; i++) {
            char tmp = path.charAt(i);

            if (tmp == uphill) {
                if (zero == 0) {
                    char innerTmp;
                    countUphill = 0;
                    isOutOfBounds = true;

                    while (isOutOfBounds && i < steps) {
                        innerTmp = path.charAt(i);

                        if (innerTmp == uphill) {
                            countUphill++;
                        } else {
                            countUphill--;
                        }

                        if (countUphill == 0) {
                            isOutOfBounds = false;
                        } else {
                            i++;
                        }

                    }

                    continue label;
                }
                zero--;
            } else {
                zero++;
            }

            if (zero == 0) countValley++;
        }

        return countValley;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        System.out.println(result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
