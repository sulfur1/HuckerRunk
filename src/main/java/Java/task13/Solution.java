package Java.task13;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String length = scanner.nextLine();
        int[] ints = new int[Integer.parseInt(length)];
        String line = scanner.nextLine();
        String[] numbers = line.trim().split(" ");
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(numbers[i]);
        }
        String lengthPeriod = scanner.nextLine();
        int lenPeriod = Integer.parseInt(lengthPeriod);
        cont:
        for (int i = 0; i < lenPeriod; i++){
            String period = scanner.nextLine();
            String[] periods = period.trim().split(" ");

            int start = Integer.parseInt(periods[0]);
            int end = Integer.parseInt(periods[1]);
            if (start == end) {
                System.out.println("Yes");
                continue cont;
            }
            boolean flag = false;
            int[] tmp = Arrays.copyOfRange(ints, start - 1, end);
            if (tmp[0] < tmp[1]) {
                flag = true;
                label:
                for (int j = 1; j < tmp.length - 1; j++) {
                    if (tmp[j] >= tmp[j + 1]) {
                        flag = true;
                    } else {
                        flag = false;
                        break label;
                    }
                }
            } else {
                label:
                for (int j = 0; j < tmp.length - 1; j++) {
                    if (tmp[j] >= tmp[j + 1]) {
                        flag = true;
                    } else {
                        flag = false;
                        break label;
                    }
                }
            }
            System.out.println(flag ? "Yes" : "No");
        }
    }
}
