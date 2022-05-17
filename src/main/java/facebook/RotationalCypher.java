package facebook;


/*
Rotational Cipher
One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
Given a string and a rotation factor, return an encrypted string.

Signature
string rotationalCipher(string input, int rotationFactor)
Input
1 <= |input| <= 1,000,000
0 <= rotationFactor <= 1,000,000
Output
Return the result of rotating input a number of times equal to rotationFactor.

Example 1
input = Zebra-493?
rotationFactor = 3
output = Cheud-726?

Example 2
input = abcdefghijklmNOPQRSTUVWXYZ0123456789
rotationFactor = 39
output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
 */

import javax.swing.text.Position;

public class RotationalCypher {
// Add any helper functions you may need here

    public static final int NUMBER_LOWER_END = 48;
    public static final int NUMBER_UPPER_END = 57;

    public static final int UPPER_LETTER_LOWER_END = 65;
    public static final int UPPER_LETTER_UPPER_END = 90;

    public static final int LOWER_LETTER_LOWER_END = 97;
    public static final int LOWER_LETTER_UPPER_END = 122;

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        // Outpu will necessarily have the same length as the input string
        char [] inputArray = input.toCharArray(); // O(n)
        for (int i = 0; i < inputArray.length; i++) {

            // Lower case alpha
            if ((int)inputArray[i] >= LOWER_LETTER_LOWER_END && (int)inputArray[i] <= LOWER_LETTER_UPPER_END) {
                inputArray[i] = (char) newChar(inputArray[i], rotationFactor, LOWER_LETTER_LOWER_END, LOWER_LETTER_UPPER_END);
            }

            // Upper case alpha
            if ((int)inputArray[i] >= UPPER_LETTER_LOWER_END && (int)inputArray[i] <= UPPER_LETTER_UPPER_END) {
                inputArray[i] = (char) newChar(inputArray[i], rotationFactor, UPPER_LETTER_LOWER_END,
                        UPPER_LETTER_UPPER_END);
            }

            // Number
            if ((int)inputArray[i] >= NUMBER_LOWER_END && (int)inputArray[i] <= NUMBER_UPPER_END) {
                inputArray[i] = (char) newChar(inputArray[i], rotationFactor, NUMBER_LOWER_END, NUMBER_UPPER_END);
            }
        }

        return new String(inputArray);
    }

    private int newChar(int letter, int rotationFactor, int lowerEnd, int upperEnd) {
        int result;
        int trueOffset = rotationFactor%(upperEnd - lowerEnd + 1);
        // Wrap around
        if (trueOffset + letter > upperEnd ) {
            result = (char) (trueOffset + letter - upperEnd + lowerEnd - 1);
        } else
            result = letter + rotationFactor%(upperEnd - lowerEnd + 1);
        return result;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new RotationalCypher().run();
    }
}
