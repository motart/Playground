package volvo;

import java.util.HashMap;
import java.util.Map;

public class AandBOccurences {
    public static void main(String[] args) {
        System.out.println(solution("aaaa"));
    }

    static boolean solution(String s) {
        // write your code in JavaScript (Node.js 8.9.4)
        if (!s.contains("a") && !s.contains("b")) {
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i<s.length(); i++) {
            Integer positionB = map.get('b');
            if (s.charAt(i) == 'a') {
                if (positionB != null) {
                    return false;
                }
            } else if (s.charAt(i) == 'b'){
                map.put('b',i);
            }
        }
        return true;
    }
}
