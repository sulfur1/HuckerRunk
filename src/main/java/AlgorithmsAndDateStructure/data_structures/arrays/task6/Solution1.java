package AlgorithmsAndDateStructure.data_structures.arrays.task6;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */
    // Rework solution with help
    // https://brokensandals.net/technical/programming-challenges/hackerrank-array-manipulation/
    // and
    // https://programs.programmingoneonone.com/2021/03/hackerrank-array-manipulation-solution.htm
    public static long arrayManipulation(int n, List<List<Integer>> queries) {

        Map<Long, Long> map = new HashMap<>();

        for (long i = 0; i < queries.size(); i++) {
            List<Integer> current = queries.get((int) i);
            long start = current.get(0);
            long end = current.get(1);
            long value = current.get(2);

            map.put(start, (map.containsKey(start) ? map.get(start) : 0) + value);
            map.put(end + 1, (map.containsKey(end + 1) ? map.get(end + 1) : 0) - value);
        }

        long max = 0;
        long value = 0;
        for (long i = 0; i < n; i++) {
            value += (map.containsKey(i + 1) ? map.get(i + 1) : 0);
            max = Math.max(max, value);
        }

        return max;
    }

}

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result1.arrayManipulation(n, queries);
        System.out.println(result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}


