package AlgorithmsAndDateStructure.task1_30.task23;

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
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        int answer = 2;
        a.sort(Integer::compare);

        List<Integer> tempList = new ArrayList<>();

        for (int i = 0; i < a.size() - 1; i++) {
            int current = a.get(i);
            int next = a.get(i + 1);

            tempList.add(current);
            if (Math.abs(current - next) <= 1) {

                if (i == a.size() - 2 && isAllNumberCondition(tempList)) {
                    tempList.add(next);
                }

                if (tempList.size() > 2) {
                    boolean flag = isAllNumberCondition(tempList);

                    if (!flag) {
                        int lastElement = tempList.get(tempList.size() - 1);

                        answer = Math.max(answer, tempList.size() - 1);

                        tempList = new ArrayList<>();
                        tempList.add(lastElement);
                    }
                }
            } else {
                boolean flag = isAllNumberCondition(tempList);

                if (!flag) {
                    int lastElement = tempList.get(tempList.size() - 1);

                    answer = Math.max(answer, tempList.size() - 1);

                    tempList = new ArrayList<>();
                    tempList.add(lastElement);
                } else {
                    answer = Math.max(answer, tempList.size());

                    tempList = new ArrayList<>();
                }
            }
        }
        return Math.max(answer, tempList.size());
    }

    private static boolean isAllNumberCondition(List<Integer> tempList) {
        for (int i = 0; i < tempList.size(); i++) {
            int currentI = tempList.get(i);
            for (int j = 0; j < tempList.size(); j++) {
                int currentJ = tempList.get(j);
                if (i == j) continue;

                if (Math.abs(currentI - currentJ) > 1) {
                    return false;
                }
            }
        }
        return true;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pickingNumbers(a);

        System.out.println(result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

