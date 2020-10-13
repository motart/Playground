package com.playground;

import java.util.*;

public class NikeAssessment {

    public static String removeCharacter(String S) {
        // write your code in Java SE 8
        List<String> orderedList = new ArrayList<>();
        for (int i=0; i<S.length(); i++) {
            orderedList.add(S.substring(0,i) + S.substring(i+1));
        }
        Collections.sort(orderedList);
        return orderedList.get(0);
    }

    public static int numberOperation (String S) {
        int result = 0;
        // remove leading zeroes
        StringBuilder temp = new StringBuilder(S.substring(S.indexOf("1")));

        while (!"0".equals(temp.toString())) {
            result++;
            if (temp.length()>0 && temp.charAt(temp.length()-1) == '1') {
                // minus 1
                if (temp.charAt(temp.length()-1) == '0') {
                    temp.setCharAt(temp.length()-1,'1');
                } else {
                    temp.setCharAt(temp.length()-1,'0');
                }
            } else if (temp.length()>0){
                // divide by 2
                temp.setLength(temp.length() - 1);
            }
            if (temp.indexOf("1") == -1 || temp.length() == 0) {
                temp = new StringBuilder("0");
            }
        }

        return result;
    }

    public static List<String> getMostFrequent(List<String> input,int k) {
        Map<String, Integer> myList = new HashMap<>();
        // Create a frequency map
        for (String element : input) {
            Integer freq = myList.get(element);
            if (freq == null) {
                myList.put(element,1);
            } else {
                myList.put(element,freq + 1);
            }
        }

        // myList = [{code,1},{coding,1},{love:2},{i,2}]


        // Get the elements that have that max frequency

        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(myList.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        List<String> temp = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list) {
            temp.add(entry.getKey());
        }
        return temp;
    }

    public static void main(String[] args) {
        // System.out.println(removeCharacter("codility"));
        System.out.println(numberOperation("1111010101111"));
    }
}
