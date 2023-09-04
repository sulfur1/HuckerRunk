package Java.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        int count = 1;
        String result;
        while (scanner.hasNext()) {
            result = scanner.nextLine();
            if ((result.lastIndexOf("end-of-file")) > 0) {
                builder.append(count).append(" ").append(result);
                break;
            } else {
                builder.append(count).append(" ").append(result).append("\n");
                count++;
            }
        }
        System.out.println(builder.toString());

    }
}