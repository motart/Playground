package facebook;

import java.util.TreeMap;

public class ValidNumber {
    public static boolean isValidNumber(String s) {
        if (s == null || s.isEmpty() || s.trim().isEmpty()) {
            return false;
        }
        s = s.trim();
        if (s.length() == 1 && (s.charAt(0) == '.' || s.charAt(0) == '-' || s.charAt(0) == '+' || s.charAt(0) == 'e')) {
            return false;
        }

        boolean isDec = false;
        boolean isExp = false;
        boolean isSigned = false;
        boolean hasNum = false;

        for (int i = 0; i<s.length(); i++) {
            if (!isValid(s.charAt(i))) {
                return false;
            }
            if (i == 0) {
                if (s.charAt(i) == 'e') {
                    return false;
                }
            }

            if (s.charAt(i) == 'e') {
                if (i == 1 && s.charAt(0) == '.') {
                    hasNum = false;
                }
                if (isExp || !hasNum || i == s.length() - 1) {
                    return false;
                }
                isExp = true;
                isSigned = false;
                isDec = true;
            }
            if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (isSigned || i == s.length() - 1) {
                    return false;
                }
                isSigned = true;
            } else if (s.charAt(i) == '.') {
                if (isDec || (i == s.length() - 1 && !hasNum)) {
                    return false;
                }
                isDec = true;
                hasNum = true;
                isSigned = true;
            } else if (isDigit(s.charAt(i))) {
                hasNum = true;
                isSigned = true;
            }
        }
        return true;
    }

    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
    public static boolean isValid(char ch) {
        return isDigit(ch) || ch == '-' || ch == '+' || ch == '.' || ch == 'e';
    }
    public static void main (String [] args) {
        System.out.println(isValidNumber(".e1"));
    }
}
