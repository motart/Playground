package MGM;

import java.util.*;

public class MGM {
    public MGM() {
    }
    // Find out the products that are not used.
    // Keys: product, Values: frequency

    // The most used products


    // The least used products.
    public static List<Integer> findTheUnusedProducts(int [] products, HashMap<Integer, Integer> map) {
        List<Integer> result = new ArrayList<>();
        for (int product : products) {
            if (map.get(product) == null) {
                result.add(product);
            }
        }
        return result;
    }


    // input : product -> Frequency
    // result : frequency, list of products
    // Keys: product, Values: frequency
    public static List<Integer> getFrequencies(HashMap<Integer, Integer> input, boolean isHighest) {
        TreeMap<Integer, List<Integer>> result;
        if (isHighest) result = new TreeMap<>(Collections.reverseOrder());
        else result = new TreeMap<>();
        for (Map.Entry entry : input.entrySet()) {
            List<Integer> productsByFrequency = result.get(entry.getValue());
            if (productsByFrequency == null) {
                productsByFrequency = new ArrayList<>();
            }
            productsByFrequency.add((Integer) entry.getKey());
            result.put((Integer) entry.getValue(), productsByFrequency);
        }
        return result.firstEntry().getValue();
    }


    public static void main (String[] args) {
        int [] products = new int [] {5,1,3,2,4,6}; // List f products in caraloq
        int [] usage1 = new int [] {3,2,1,5,5,2}; // The products that are used.
        int [] usage2 = new int [] {3,2,1,5,5,5,2}; // The products that are used.
        HashMap<Integer, Integer> map = parseArray(usage2);
        // System.out.println(findTheUnusedProducts( products, map));
        System.out.println(getFrequencies( map, true));
    }

    public static HashMap<Integer, Integer> parseArray(int[] input) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int product : input) {
            Integer usage = map.get(product);
            if (usage == null) {
                map.put(product, 1);
            } else {
                map.put(product, usage + 1);
            }
        }
        return map;
    }
}
