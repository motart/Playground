package facebook;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

public class EqualStacks {
/*        public static void main(String[] args) {
            List<Integer> h1 = new ArrayList<>();
            h1.add(3);
            h1.add(2);
            h1.add(1);
            h1.add(1);

            List<Integer> h2 = new ArrayList<>();
            h2.add(4);
            h2.add(3);
            h2.add(2);

            List<Integer> h3 = new ArrayList<>();
            h3.add(1);
            h3.add(1);
            h3.add(4);
            h3.add(1);

            System.out.println(equalStacks(h1,h2,h3));
        }*/

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        String[] h1Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h1 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            int h1Item = Integer.parseInt(h1Temp[i]);
            h1.add(h1Item);
        }

        String[] h2Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h2 = new ArrayList<>();

        for (int i = 0; i < n2; i++) {
            int h2Item = Integer.parseInt(h2Temp[i]);
            h2.add(h2Item);
        }

        String[] h3Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n3; i++) {
            int h3Item = Integer.parseInt(h3Temp[i]);
            h3.add(h3Item);
        }

        int result = EqualStacks.equalStacks(h1, h2, h3);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }


        public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
            // Write your code here
            int n1 = getHeight(h1) , n2 = getHeight(h2), n3 = getHeight(h3);
            if (n1 == 0 || n2 == 0 || n3 == 0) {
                return 0;
            }

            int i=0, j=0, k=0;
            while (n1 != n2 || n2 != n3 || n1 != n3) {
                if (i == h1.size() || j == h2.size() || k == h3.size()) {
                    return 0;
                } else if (n1 >= n2 && n1 >= n3) {
                    n1 = n1 - h1.get(i++);
                } else if (n2 >= n1 && n2 >= n3) {
                    n2 = n2 - h2.get(j++);
                } else if (n3 >= n1 && n3 >= n2) {
                    n3 = n3 - h3.get(k++);
                }
            }
            return n1;
        }

        static int getHeight(List<Integer> h) {
            int result = 0;
            for (Integer element : h) {
                result = result + element;
            }
            return result;
        }
}
