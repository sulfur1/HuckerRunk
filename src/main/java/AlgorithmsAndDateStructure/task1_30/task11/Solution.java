package AlgorithmsAndDateStructure.task1_30.task11;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        /*int NOD = b.get(0);
        for (int i = 1; i < b.size(); i++) {
            int y = b.get(i);
            while (NOD != 0 && y != 0) {
                if (NOD > y) {
                    NOD %= y;
                } else {
                    y %= NOD;
                }
            }
            NOD += y;
        }*/
        int n = b.stream().max((x1, x2) -> x1.compareTo(x2)).get();
        List<Integer> factorize = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if ((n % i) == 0) {
                factorize.add(i);
            }
        }
        int countNumbers = 0;

        //factorize.forEach(System.out::println);

        List<Integer> numbersOfFirstList = new ArrayList<>();

        h1: for (int i = 0; i < a.size(); i++) {
            int count = 0;
            for (int j = 0; j < a.size(); j++) {
                if (a.get(i) % a.get(j) == 0) {
                    count++;
                } else {
                    continue h1;
                }
            }
            if (count == a.size()) {
                numbersOfFirstList.add(a.get(i));
            }
        }

        List<Integer> numbersOfSecondList = new ArrayList<>();

        for (int i = 0; i < factorize.size(); i++) {
            int count = 0;
            for (int j = 0; j < b.size(); j++) {
                if (b.get(j) % factorize.get(i) == 0) {
                    count++;
                }
            }
            if (count == b.size()) {
                numbersOfSecondList.add(factorize.get(i));
            }
        }

        List<Integer> resultList = new ArrayList<>();

        h1: for (int i = 0; i < numbersOfFirstList.size(); i++) {
            int count = 0;
            for (int j = 0; j < b.size(); j++) {
                if (b.get(j) % numbersOfFirstList.get(i) == 0) {
                    count++;
                } else {
                    continue h1;
                }
            }
            if (count == b.size()) {
                resultList.add(numbersOfFirstList.get(i));
            }
        }

        h1: for (int i = 0; i < numbersOfSecondList.size(); i++) {
            int count = 0;
            for (int j = 0; j < a.size(); j++) {
                if (numbersOfSecondList.get(i) % a.get(j) == 0) {
                    count++;
                } else {
                    continue h1;
                }
            }
            if (count == a.size()) {
                if (!(resultList.contains(numbersOfSecondList.get(i)))) {
                    resultList.add(numbersOfSecondList.get(i));
                }
            }
        }

        return resultList.size();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);
        System.out.println(total);
        /*bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedWriter.close();*/
        bufferedReader.close();
    }
}

