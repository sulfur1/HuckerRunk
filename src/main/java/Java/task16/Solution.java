package Java.task16;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        String A = a.toLowerCase();
        String B = b.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        char[] charsA = A.toCharArray();
        for (int i = 0; i < a.length(); i++) {
            map.merge(charsA[i], 1, Integer::sum);
        }
        char[] charsB = B.toCharArray();
        for (int i = 0; i < b.length(); i++) {
            map.merge(charsB[i], 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if ((entry.getValue() % 2) != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

