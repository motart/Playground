package shopify;

import ch.qos.logback.core.joran.conditional.IfAction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringValidator {
    public static void main (String[] args) {
        String[] input = new String[]{"practice","makes","perfect"};
        String sentence1 = "practice makes perfect.";
        String sentence2 = "practicemakesperfectx";
        // System.out.println("The sentence is conform " + isSpacedStringValid(sentence1, input));
        System.out.println("The sentence is conform " + isContiguousStringValidRaw(sentence2, input));
    }

    private static boolean isSpacedStringValid(String sentence, String[] input) {
        // Prep the hashset
        HashSet<String> dict = populateDict(input);

        // Cleanup the sentence
        sentence = sentence.replace(".","");

        // Compare each word in sentence to set in dict
        for (String word : sentence.split(" ")) {
            if (!dict.contains(word.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    private static HashSet<String> populateDict(String [] wordDict) {
        HashSet<String> dict = new HashSet<>();
        for (String dictWord : wordDict) {
            dict.add(dictWord.toLowerCase());
        }

        return dict;
    }

    private static boolean isContiguousStringValid(String sentence, String[] input) {
        // Prep the hashset
        HashSet<String> dict = populateDict(input);


        // Cleanup the sentence
        sentence = sentence.replace(".","");

        StringBuilder temp = new StringBuilder();
        for (char character : sentence.toCharArray()) {
            temp.append(character);
            if (dict.contains(temp.toString())) {
                temp = new StringBuilder();
            }
        }
        return temp.toString().isEmpty();
    }

    private static boolean isContiguousStringValidRaw(String sentence, String[] input) {
        // Prep the hashset
        HashSet<String> dict = populateDict(input);


        // Cleanup the sentence
        sentence = sentence.replace(".","");
        return evaluateString(dict, sentence);
    }

    private static boolean evaluateString(Set <String> dict, String sentence) {
        int i = 0;
        for (int j = 0; j <= sentence.length(); j++) {
            if (dict.contains(sentence.substring(i,j))) {
                i = j;
            }
        }
        return sentence.length() <= i ;
    }

}
