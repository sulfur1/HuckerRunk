package AlgorithmsAndDateStructure.algorithms.task1_30.task24;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
// Write your code here
        List<Integer> playerRank = new ArrayList<>();

        label:
        for (int i = 0; i < player.size(); i++) {
            int currentRankPlayer = player.get(i);
            int rank = 1;
            for (int j = 0; j < ranked.size(); ) {
                int currentPlayersRank = ranked.get(j);
                if (currentRankPlayer >= currentPlayersRank) {
                    playerRank.add(rank);
                    continue label;
                } else {
                    rank++;
                    j++;
                    while (j < ranked.size() && currentPlayersRank == ranked.get(j)) {
                        j++;
                    }

                }
            }
            playerRank.add(rank);
        }
        return playerRank;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

