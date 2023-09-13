package Java.task17;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] tokens = s.split("[ !,?._'@]+");
        List<String> strings = Arrays.asList(tokens).stream().filter(s1 -> !(s1.isBlank())).toList();
        System.out.println(strings.size());
        strings.forEach(System.out::println);
        scan.close();
    }
}
