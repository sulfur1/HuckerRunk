package Java.task7;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        double payment = Double.parseDouble(number);
        scanner.close();

        // Write your code here.
        String india = NumberFormat.getCurrencyInstance(new Locale("en","IN")).format(payment).replaceAll("[^0-9\\p{Punct}]", "");

        System.out.println("US: " + NumberFormat.getCurrencyInstance(Locale.US).format(payment));
        System.out.println("India: Rs" + india);
        System.out.println("China: " + NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment));
        System.out.println("France: " + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment));
    }


}
