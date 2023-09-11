package Java.task14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Вступительное испытание Tincoff Task_4
 * Необходимо доработать
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        List<Integer> result = new ArrayList<>();
        String[] numbs = line1.trim().split(" ");
        int n = Integer.parseInt(numbs[0]);
        int c = Integer.parseInt(numbs[1]);
        int d = Integer.parseInt(numbs[2]);
        String[] length = line2.trim().split(" ");
        int[] ints = new int[length.length];
        int[] sortedInts = Arrays.copyOfRange(ints, 0, ints.length);
        Arrays.sort(sortedInts);
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(length[i]);
        }
        int minMin = sortedInts[0];
        int maxMin = sortedInts[sortedInts.length - 1];

        if ((minMin - d) < 0) {
            int count = 0;
            boolean flag = false;
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] <= maxMin && count < c) {
                    if (ints[i] == minMin && (!flag)) {
                        result.add(ints[i] - d);
                        flag = true;
                        count++;
                    }
                } else {
                    result.add(ints[i]);
                }
            }
        } else if ((minMin - d) == 0) {
            boolean zero = false;
            for (int i = 0; i < ints.length; i++) {
                if ((ints[i] == minMin) && (!zero)) {
                    result.add(minMin - d);
                    zero = true;
                } else {
                    result.add(ints[i]);
                }
            }
        } else {
            int count = 0;
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] <= maxMin && count < c) {
                    result.add(ints[i] - d);
                    count++;
                } else {
                    result.add(ints[i]);
                }
            }
        }
        result.forEach(integer -> System.out.print(integer + " "));
    }
}
