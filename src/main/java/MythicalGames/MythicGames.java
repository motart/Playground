package MythicalGames;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class MythicGames {

    /*
     * Complete the 'countMax' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts STRING_ARRAY upRight as parameter.
     */

    public static long countMax(List<String> upRight) {
        // Write your code here
        int minRow = 0, minColumn = 0;
        for (String element : upRight) {
            String[] values = element.split(" ");
        }
        return Math.abs(minRow - minColumn + 1);
    }

}

class SolutionMG {
    public static void main(String[] args) throws IOException {


        int upRightCount = 3;

        List<String> upRight = new ArrayList<>();

        upRight.add("2 3");
        upRight.add("3 7");
        upRight.add("4 1");

        long result = MythicGames.countMax(upRight);
    }
}
