package facebook;

import java.util.*;

public class InvalidParantheses {


    /*
    BFS : O(n* 2^n)
    in the worst case, we only have par in str
    for each char, we delete it or not, so we can get 2^n combinations
    for each comb, we check if it is a valid one
    the advantage of BFS, will be we can gurantee the minimize the removal times

    -----------
    DFS :

    case 1: more )
         0  1   2   3   4   5   6
        "(  )   (   )   )   (   )"
    cnt. 1. 0.  1   0.  -1

    once the cnt < 0, it means we have more ‘)’ in the prefix, we revisit s[0, 4] and try to remove a ‘)’.
    So we ask the question, "which one?" Let's observe
        delete(s[1]) -> "(())()"
        delete(s[3]) -> "()()()"
        if we delete s[4]. we will generate duplicate results, (check if we include duplicates in res with interviewer)
        if no duplicate allowed, we just remove the first occurence in consecutive ')'

    case 2: with letter
        0  1   2   3   4   5   6
       "(   )   (   )   )   r   )"

    After the removal, the prefix is then valid. We then call the function recursively to solve the rest of the string. However, we need to keep another information: the last removal position. If we do not have this position, we will generate duplicate by removing two ‘)’ in two steps only with a different order.For this, we keep tracking the last removal position and only remove ‘)’ after that.

    case 3: need to delete both '(' and ')'
    ")()("

    Now one may ask. What about ‘(‘? What if s = ‘(()(()’ in which we need remove ‘(‘? The answer is: do the same from right to left.However a cleverer idea is: reverse the string and reuse the code!

    T: O(2^n)
    S: O(n)

    The program only generates valid answers. Every path in the search generates one valid answer. The whole search space is a tree with k leaves. The number of nodes in the tree is roughly O(k). But this is not always true, for example a degenerated tree.
    To generate one node it requires O(n) time from the string concatenation among other things. So roughly O(nk). Accurately O(nm) where m is the total "number of recursive calls" or "nodes in the search tree". Then you need to relate m to n in the worst case.
    I wouldn't worry too much about the accurate complexity analysis of this problem. It would require more mathematics than an interview cares.
    */


    public List<String> removeInvalidParenthesesBFS(String s) {
      List<String> res = new ArrayList<>();

      // sanity check
      if (s == null) return res;

      Set<String> visited = new HashSet<>();
      Queue<String> queue = new LinkedList<>();

      // initialize
      queue.add(s);
      visited.add(s);

      boolean found = false;

      while (!queue.isEmpty()) {
        s = queue.poll();

        if (isValid(s)) {
         // found an answer, add to the result
          res.add(s);
         // once we found an answer, it means we know the minimum number of parentheses we can remove
         // we will not move more parentheses
          found = true;
        }

        if (found) continue;

        // generate all possible states
        for (int i = 0; i < s.length(); i++) {
          // we only try to remove left or right paren
          if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

          String t = s.substring(0, i) + s.substring(i + 1);

          if (!visited.contains(t)) {
            // for each state, if it's not visited, add it to the queue
            queue.add(t);
            visited.add(t);
          }
        }
      }

      return res;
    }

    // helper function checks if string s contains valid parantheses
    boolean isValid(String s) {
      int count = 0;

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') count++;
        if (c == ')' && count-- == 0) return false;
      }

      return count == 0;
    }


    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, s, 0, 0, '(', ')');
        return res;
    }

    void dfs(List<String> res, String s, int startI, int startJ, char cToKeep, char cToRemove) {
        int cnt = 0;
        int n = s.length();
        int i = startI;
        // check the remaining str start from startI
        while (i < n && cnt >= 0) {
            if (s.charAt(i) == cToKeep) {
                cnt++;
            } else if (s.charAt(i) == cToRemove) {
                cnt--;
            }
            i++;
        }

        if (cnt < 0) {
            i--;
            for (int j = startJ; j <= i; j++) {
                if (s.charAt(j) == cToRemove && (j == startJ || s.charAt(j - 1) != cToRemove)) {
                    String sAfterRemoval = s.substring(0, j) + s.substring(j + 1, n);
                    dfs(res, sAfterRemoval, i, j, cToKeep, cToRemove);
                }
            }
            // no extra ')' is detected. We now have to detect extra '(' by reversing the string.
        } else {
            String reverse = new StringBuilder(s).reverse().toString();
            if (cToKeep == '(') { // finished first round traversal
                dfs(res, reverse, 0, 0, cToRemove, cToKeep);
            } else { // finishe two round traversal, is already valid;
                res.add(reverse);
            }
        }
    }
}
