package AlgorithmsAndDateStructure.task1_30.task6;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        LocalTime timeOfPMDay = LocalTime.of(23, 59, 59);
        LocalTime timeOfNight = LocalTime.of(0, 0, 0);
        LocalTime timeOfMiddleDay = LocalTime.of(12, 0, 0);
        LocalTime timeOfAmDay = LocalTime.of(11, 59, 59);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String[] strings;
        if (s.endsWith("AM")) {
            int index = s.lastIndexOf("AM");
            strings = s.substring(0, index).split(":");
            int houre = Integer.parseInt(strings[0]);
            int minute = Integer.parseInt(strings[1]);
            int seconds = Integer.parseInt(strings[2]);

            LocalTime currentTime = LocalTime.of(houre, minute, seconds);

            if ((currentTime.isAfter(timeOfNight) || (currentTime.compareTo(timeOfNight) == 0)) && (currentTime.isBefore(timeOfAmDay) || (currentTime.compareTo(timeOfAmDay) == 0))) {
                return currentTime.format(formatter);
            } else {
                return currentTime.plusHours(12).format(formatter);
            }
        } else if (s.endsWith("PM")) {
            int index = s.lastIndexOf("PM");
            strings = s.substring(0, index).split(":");
            int houre = Integer.parseInt(strings[0]);
            int minute = Integer.parseInt(strings[1]);
            int seconds = Integer.parseInt(strings[2]);

            LocalTime currentTime = LocalTime.of(houre, minute, seconds);

            if ((currentTime.isAfter(timeOfMiddleDay) || (currentTime.compareTo(timeOfMiddleDay) == 0)) && (currentTime.isBefore(timeOfPMDay) || (currentTime.compareTo(timeOfPMDay) == 0))) {
                return currentTime.format(formatter);
            } else {
                return currentTime.plusHours(12).format(formatter);
            }
        } else {
            return null;
        }
        // Write your code here

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);
        System.out.println(result);
        //bufferedWriter.write(result);
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
