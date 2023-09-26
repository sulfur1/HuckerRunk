package Java.task21;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases-- > 0){
            String line = in.nextLine();
//"(<([\\w\\s.,!\"'`^{}/$)(~-]+)>)(\\1)*([\\w\\s.,!\"='`^{}/$)(~-]+)(</(\\2)>)(\\5)*"
            String regex = "<(.+)>(([^<>]+))</\\1>";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(line);

            if (!m.find()) {
                System.out.println("None");
                continue;
            }

            m.reset();
            while (m.find()) {
                System.out.println(m.group(2));
            }

        }
    }
}
