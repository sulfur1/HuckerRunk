package AlgorithmsAndDateStructure.algorithms.task31_60.task31;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */
    private static List<List<Integer>> edges;
    private static boolean[] visited;
    private static long totalCostLib;
    private static long totalCostRoad;
    private static long resultCostWithOneLibAndRoads;
    private static void initialize(int n) {
        edges = new ArrayList<>(n + 1);
        visited = new boolean[n + 1];
        totalCostLib = 0L;
        totalCostRoad = 0L;
        resultCostWithOneLibAndRoads = 0L;
    }
    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        initialize(n);

        for (int i = 0; i <= n; i++) {
            edges.add(i, new ArrayList<>());
        }

        for (List<Integer> c : cities) {
            int cityA = c.get(0);
            int cityB = c.get(1);
            edges.get(cityA).add(cityB);
            edges.get(cityB).add(cityA);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, c_road);
                resultCostWithOneLibAndRoads += totalCostRoad + c_lib;
                totalCostRoad = 0;
            }
            totalCostLib += c_lib;
        }

        return Long.min(resultCostWithOneLibAndRoads, totalCostLib);
    }

    private static void dfs(int i, int c_road) {
        visited[i] = true;
        for (Integer adj : edges.get(i)) {
            if (!visited[adj]) {
                totalCostRoad += c_road;
                dfs(adj, c_road);
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);
                //System.out.println(result);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
