package AlgorithmsAndDateStructure.algorithms.task1_30.task16;



import java.io.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
        // Write your code here
        String leapYear = "12.09.";
        String notLeapYear = "13.09.";

        String result;

        if (year < 1918) {
            if (year % 4 == 0) {
                result = leapYear.concat(String.valueOf(year));
            } else {
                result = notLeapYear.concat(String.valueOf(year));
            }
        } else if (year > 1918) {
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                result = leapYear.concat(String.valueOf(year));
            } else {
                result = notLeapYear.concat(String.valueOf(year));
            }
        } else  {
            result = "26.09.1918";
        }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        System.out.println(result);
        /*bufferedWriter.write(result);
        bufferedWriter.newLine();*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

