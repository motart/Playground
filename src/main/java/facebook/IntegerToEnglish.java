package facebook;

import com.sun.org.apache.xpath.internal.operations.Gte;

import java.util.*;

public class IntegerToEnglish {
    private static String intToEnglish(int num) {
        StringBuilder result = new StringBuilder();
        double temp = num;
        for (int i = 9; i >= 0; i = i - 3) {
            double quotient = temp/Math.pow(10,i);
            if ((int)quotient > 0) {
                result.append( processThousand((int)quotient));
                // This adds Billion, Million, Thousand to result
                if (i > 0) {
                    result.append(getNumbers().get(i).get(1));
                }
            }
            // update number to be processed with remainder
            temp = temp%Math.pow(10,i);
        }
        if (result.length() == 0) {
            return "Zero";
        }
        return result.toString();
    }

    static String processThousand(int num) {
        StringBuilder result = new StringBuilder();
        double temp = num;
        if (num > 99) {
            result.append(getNumbers().get((int)num/100).get(0)).append(getNumbers().get(2).get(1));
            num = num%100;
        }
        if (num > 0) {
            result.append(processHundred(num));
        }
        return result.toString();
    }
    static String processHundred(int num) {
        StringBuilder result = new StringBuilder();
        double temp = num;
        if (num <= 20 || num == 30 || num == 40 || num == 50 || num == 60 || num == 70 || num == 80 || num == 90) {
            result.append(getNumbers().get(num).get(0));
        } else {
            result.append(getNumbers().get((num/10)*10).get(0));
            result.append(getNumbers().get(num%10).get(0));
        }
        return result.toString();
    }


    static Map<Integer,List<String>> getNumbers() {
        Map<Integer,List<String>> numbers = new HashMap<>();
        numbers.put(1,Arrays.asList("One ","Ten "));
        numbers.put(2,Arrays.asList("Two ","Hundred "));
        numbers.put(3,Arrays.asList("Three ","Thousand "));
        numbers.put(4,Arrays.asList("Four ",""));
        numbers.put(5,Arrays.asList("Five ","Hundred Thousand "));
        numbers.put(6,Arrays.asList("Six ","Million "));
        numbers.put(7,Arrays.asList("Seven ","Ten Million "));
        numbers.put(8,Arrays.asList("Eight ","Hundred Million "));
        numbers.put(9,Arrays.asList("Nine ","Billion "));
        numbers.put(10,Arrays.asList("Ten ",""));
        numbers.put(11,Arrays.asList("Eleven ",""));
        numbers.put(12,Arrays.asList("Twelve ",""));
        numbers.put(13,Arrays.asList("Thirteen ",""));
        numbers.put(14,Arrays.asList("Fourteen ",""));
        numbers.put(15,Arrays.asList("Fifteen ",""));
        numbers.put(16,Arrays.asList("Sixteen ",""));
        numbers.put(17,Arrays.asList("Seventeen ",""));
        numbers.put(18,Arrays.asList("Eighteen ",""));
        numbers.put(19,Arrays.asList("Nineteen ",""));
        numbers.put(20,Arrays.asList("Twenty ",""));
        numbers.put(30,Arrays.asList("Thirty ",""));
        numbers.put(40,Arrays.asList("Forty ",""));
        numbers.put(50,Arrays.asList("Fifty ",""));
        numbers.put(60,Arrays.asList("Sixty ",""));
        numbers.put(70,Arrays.asList("Seventy ",""));
        numbers.put(80,Arrays.asList("Eight ",""));
        numbers.put(90,Arrays.asList("Ninety ",""));

        return numbers;
    }
    public static void main(String[] args) {
        System.out.println(intToEnglish(100000));
    }
}
