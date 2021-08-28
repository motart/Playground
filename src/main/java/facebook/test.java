package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    private static void test () {
        Map<Character, List<Character>> adjList = new HashMap<>();
        adjList.put('a', new ArrayList<Character>());
        adjList.get('a').add('b');
        adjList.get('a').add('d');
        adjList.get('a').add('e');
        System.out.println(adjList.get('a'));
    }

    public static void main(String[] args) {
        test();
    }

}
