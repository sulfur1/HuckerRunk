package Java.task4;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        int h = scanner.nextInt();
        try {
            if (b <= 0 || h <= 0) {
                throw new Exception("Breadth and height must be positive");
            } else {
                System.out.println(b * h);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
