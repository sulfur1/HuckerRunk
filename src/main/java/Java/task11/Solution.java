package Java.task11;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numb1 = scanner.nextInt();
        int numb2 = scanner.nextInt();

        int copy = numb1;
        while (true) {
            if ((numb2 - copy) < 0) break;

            numb2 -= copy;
            copy--;

            if (copy <= 0) {
                copy = numb1;
            }
        }
        System.out.println(numb2);
    }
}
