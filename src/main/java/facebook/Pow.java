package facebook;

import javax.xml.transform.Result;

public class Pow {
    public static double pow(double root, int power) {
        if (power == 0) {
            return 1;
        }
        if (power < 0) {
            return 1/pow(root,-power);
        }
        double half = pow(root,power/2);
        if (power % 2 == 0) {
            return half * half;
        } else {
            return root * half * half;
        }
    }

    public static void main(String [] args) {
        System.out.print(pow(2,-2147483648));
    }
}
