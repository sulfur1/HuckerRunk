package Java.task1;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder builder = new StringBuilder();
            String result;
            while ((result = reader.readLine()) != null) {
                String[] arr = result.trim().split(" ");
                builder.append(arr[0]);
                if (arr[1].length() < 3) {
                    StringBuilder tmp = new StringBuilder(arr[1]);
                    for (int i = 0; i < 15 - arr[0].length(); i++) {
                        builder.append(" ");
                    }
                    for (int i = 0; i < 3 - arr[1].length(); i++) {
                        tmp.insert(i, '0');
                    }
                    builder.append(tmp.toString());
                } else {
                    for (int i = 0; i < 15 - arr[0].length(); i++) {
                        builder.append(" ");
                    }
                    builder.append(arr[1]);
                }

                builder.append("\n");
            }
            System.out.println("================================");
            System.out.print(builder.toString());
            System.out.print("================================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

