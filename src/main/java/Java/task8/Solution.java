package Java.task8;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        StringBuilder builder = new StringBuilder();
        char one = Character.toUpperCase(A.charAt(0));
        char two = Character.toUpperCase(B.charAt(0));
        String tmp1 = A.substring(1);
        String tmp2 = B.substring(1);
        builder.append(one).append(tmp1).append(" ").append(two).append(tmp2);
        System.out.print(builder);
    }


}
