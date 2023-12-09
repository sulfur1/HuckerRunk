package AlgorithmsAndDateStructure.algorithms.task31_60.task32;

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
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */
    private static boolean[] visited;
    private static final List<List<Integer>> adj = new ArrayList<>();
    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        // Write your code here
        visited = new boolean[n];
        int sumSizeList = 0;
        List<List<Integer>> peopleShareCountry = new ArrayList<>();
        List<Integer> peopleNotShareCountry = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (List<Integer> pair : astronaut) {
            int astronautA = pair.get(0);
            int astronautB = pair.get(1);
            adj.get(astronautA).add(astronautB);
            adj.get(astronautB).add(astronautA);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> sameCountry = new ArrayList<>();
                sameCountry.add(i);
                dfs(i, sameCountry);
                if (sameCountry.size() > 1) {
                    peopleShareCountry.add(sameCountry);
                    sumSizeList += sameCountry.size();
                } else {
                    peopleNotShareCountry.add(i);
                }
            }
        }
        long ways = 0;
        long total = sumSizeList;
        for (int i = 0; i < peopleShareCountry.size(); i++) {
            total -= peopleShareCountry.get(i).size();
            ways += total * peopleShareCountry.get(i).size();
        }

        if (peopleNotShareCountry.size() == 1) {
            ways += sumSizeList;
        } else if (peopleNotShareCountry.size() == 2) {
            ways = (long) peopleNotShareCountry.size() * sumSizeList + 1;
        } else if (peopleNotShareCountry.size() == 3) {
            ways += (long) peopleNotShareCountry.size() * sumSizeList + 3;
        } else {
            long c_n_k = ((long) peopleNotShareCountry.size() * (peopleNotShareCountry.size() - 1)) / 2;
            ways += ((long) sumSizeList * peopleNotShareCountry.size()) + c_n_k;
        }

        return ways;
    }

    private static void dfs(int i, List<Integer> sameCountry) {
        visited[i] = true;
        for (Integer v : adj.get(i)) {
            if (!visited[v]) {
                sameCountry.add(v);
                dfs(v, sameCountry);
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.journeyToMoon(n, astronaut);
        System.out.println(result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

