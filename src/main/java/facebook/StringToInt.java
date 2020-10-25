package facebook;

public class StringToInt {
    public static void main(String[] args) {
        System.out.print(myAtoi("4193  with words"));
    }

    public static int myAtoi(String s) {
        s = s.trim();
        int i = 0;
        boolean signed = false;
        while ((i < s.length()) && (((s.charAt(i) == '+' || s.charAt(i) == '-') && !signed) || isDigit(s.charAt(i)))) {
            signed = true;
            i++;
        }
        if ( i > 0 ) {
            s = s.substring(0,i);
            if ("-".equals(s) || "+".equals(s)) {
                return 0;
            }
        } else {
            return 0;
        }
        return getInteger(s);
    }

    static int getInteger(String s) {
        double result = Double.parseDouble(s);
        if (result > Math.pow(2,31)-1) {
            return Integer.MAX_VALUE;
        }
        if (result < Math.pow(2,31) * -1) {
            return Integer.MIN_VALUE;
        }
        return Integer.parseInt(s);
    }

    private static boolean isDigit(char ch) {
        return ch > 47 && ch < 58;
    }
}
