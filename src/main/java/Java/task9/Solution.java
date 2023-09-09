package Java.task9;


import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest;
        String largest;
        //welcometojava
        //welcometojav
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        Set<String> set = new TreeSet<>((o1, o2) -> o1.compareTo(o2));
        int shift = k;
        for (int i = 0; i < (s.length() - k) + 1; i++) {
            int start = i;
            int end = i + shift;
            label:
            while (true) {
                if (end >= s.length()) {
                    String tmp = s.substring(start);
                    if (tmp.length() == k) set.add(tmp);
                    break label;
                }
                set.add(s.substring(start, end));
                start += shift;
                end += shift;
            }
        }
        smallest = set.stream().findFirst().get();
        largest = set.stream().skip(set.size() - 1).findFirst().get();

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}

