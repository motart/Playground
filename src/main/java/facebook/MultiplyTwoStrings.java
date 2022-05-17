package facebook;

import com.sun.source.tree.ReturnTree;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public class MultiplyTwoStrings {
    public static void main(String[] args) {
        HackerRank hackerRank = new HackerRank();
        List<Integer> listA = new ArrayList<>();
        listA.add(3);
        listA.add(1);
        listA.add(5);
        List<Integer> listB = new ArrayList<>();
        listB.add(5);
        listB.add(6);
        listB.add(7);


        System.out.println(hackerRank.comparatorValue(listA, listB, 2));
    }
}

class HackerRank {
    public static int restock(List<Integer> itemCount, int target) {
        // Write your code here
        Integer sum = 0;
        for (Integer item : itemCount) {
            sum = sum + item;
            if (sum >= target) return sum - target;
        }
        return target - sum;
    }

    public static int comparatorValue(List<Integer> a, List<Integer> b, int d) {
        // Write your code here
        int solution = 0;
        for (Integer aItem : a) {
            for  (Integer bItem : b) {
                if (Math.abs(aItem - bItem) <= d) {
                    solution--;
                    break;
                }
            }
            solution++;
        }

        return solution;
    }
}


class Solution {
    public String multiply(String num1, String num2) {
        int[] val1 = new int[num1.length()];
        int[] val2 = new int[num2.length()];
        parseArray(num1, val1);
        parseArray(num2, val2);
        return multiply(val1, val2);
    }

    int[] parseArray(String numString, int[] numArray) {
        char[] initial = numString.toCharArray();
        for (int i = initial.length - 1; i >= 0; i--) {
            numArray[i + (numArray.length - numString.length())] = Character.getNumericValue(initial[i]);
        }
        return numArray;
    }


    String multiply(int[] arr1, int[] arr2) {
        if (arr2.length < arr1.length) return multiply(arr2, arr1);
        if (arr1.length == 1 && arr1[0] == 0) return "0";
        int a = 0;
        int b = 0;
        int[] temp = new int[1];
        String tempSum = new String();
        for (int i = arr1.length - 1; i >= 0 ; i--) {
            int carry = 0;
            StringBuilder str = new StringBuilder();

            for (int k = arr1.length - 1 - i; k > 0; k--) {
                str.append("0");
            }
            a = arr1[i];
            for (int j = arr2.length - 1; j >= 0; j--) {
                b = arr2[j];
                int result = (a * b) + carry;
                carry = result / 10;
                str.insert(0, result % 10);
            }
            if (carry > 0) str.insert(0,carry);
            tempSum = add( parseArray( str.toString(), new int[str.length()]) ,temp);
            temp = parseArray(tempSum, new int[tempSum.length()]);
        }
        return tempSum;
    }


    /** Add together 2 equal sized arrays of integers
     */
    String add(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length)  return add(arr2, arr1);
        StringBuilder str = new StringBuilder();
        int a = 0;
        int b = 0;
        int carry = 0;
        // arr1 guaranteed to be the smallest size
        for (int i = arr1.length - 1; i >= 0 ; i--) {
            a = arr1[i];
            b = arr2[i + arr2.length - arr1.length];
            int result = (a + b) + carry;
            carry = result / 10;
            str.insert(0, result % 10);
        }
        for (int j = arr2.length - arr1.length -1 ; j >= 0; j--) {
            int result = arr2[j] + carry;
            carry = result / 10;
            str.insert(0, result % 10);
        }
        if (carry > 0) str.insert(0,carry);
        return str.toString();
    }
}
