package AlgorithmsAndDateStructure.task10;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        if ((x1 < x2 && v1 < v2) || (x2 < x1 && v2 < v1) || (v1 == v2)) {
            return "NO";
        }
        int V = Math.max(v1, v2) - Math.min(v1, v2);
        int distance = Math.max(x1, x2) - Math.min(x1, x2);

        if (distance % V == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = Result.kangaroo(x1, v1, x2, v2);
        System.out.println(result);
/*
        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();*/
        bufferedReader.close();
    }
}
