package AlgorithmsAndDateStructure.task1_100.task1.task3;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result {
    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    //static int countSpace;
    public static void staircase(int n) {
        int countSpace = n - 1;
        int countBracket = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < countSpace; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < countBracket; j++) {
                System.out.print("#");
            }
            System.out.println();
            countSpace--;
            countBracket++;
        }
        /*countSpace = n - 1;
        // Write your code here
        if (n == 1) {
            for (int i = 0; i < countSpace; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < n; i++) {
                System.out.print("#");
            }
            System.out.println();
            return;
        }
        staircase(n - 1);
        --countSpace;
        for (int i = 0; i < countSpace; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < n; i++) {
            System.out.print("#");
        }
        System.out.println();*/
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
