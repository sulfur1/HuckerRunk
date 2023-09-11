package Java.task12;


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String password = scanner.nextLine().trim();
        String[] numbers = line1.trim().split(" ");
        //int lengthPassword = Integer.parseInt(numbers[0]);
        int lengthDeleted = Integer.parseInt(numbers[1]);

        System.out.println(delete(password, lengthDeleted));
    }

    private static int delete(String password, int lengthDeleted) {
        int count = 0;
        char[] chars = password.toCharArray();
        boolean[] deleted = new boolean[chars.length];

        for (int i = 0; i < chars.length; i++) {
            if (!deleted[i]) {
                count++;
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        deleted[j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (!deleted[i] && lengthDeleted > 0) {
                lengthDeleted--;
                deleted[i] = true;
                count--;
            }
        }
        return count;
    }
}
