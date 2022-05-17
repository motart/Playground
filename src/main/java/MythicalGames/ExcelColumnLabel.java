package MythicalGames;


public class ExcelColumnLabel {
    public static void main(String [] args) {
        Solution solution = new Solution();
        System.out.println( solution.getColumnFromInt(53));
    }
}

// 1-26 : 1 letter
// 27-676 : 2 letters
// 677-17576 : 3 letters
// etc.
class Solution {
    public String getColumnFromInt(int number) {
        if (number >= 26) {
            int q = number/26;
            int r = number%26;
            if (r == 0) {
                if (q == 1) {
                    return getLetterFromInt(25);
                } else {
                    return getColumnFromInt(q - 1) + getLetterFromInt(25);
                }
            } else {
                return getColumnFromInt(q) + getLetterFromInt( r - 1);
            }
        }
        return getLetterFromInt(number - 1);
    }

    private String getLetterFromInt(int index) {
        String[] alphabet = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S",
                "T","U","V","W","X","Y","Z"};
        return alphabet[index];
    }
}
