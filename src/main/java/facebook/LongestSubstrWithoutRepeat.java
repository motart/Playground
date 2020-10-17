package facebook;

import com.sun.tools.corba.se.idl.constExpr.And;
import org.apache.commons.math.stat.descriptive.rank.Max;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstrWithoutRepeat {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int i = 0;
        int j = 0;
        int ans = 0;
        Set<Character> memo = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (!memo.contains(s.charAt(j))) {
                memo.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            } else {
                memo.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("abccghijklcc"));
    }
}
