package facebook;

import com.playground.JimOrders;

import javax.xml.transform.Templates;
import java.sql.Savepoint;

public class AddBinary {

    public static void main(String [] args) {
        System.out.print(addBinary("11","1"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int m = a.length() - 1;
        int n = b.length() - 1;
        int carry = 0;
        // Ensure a.length is always longer than b
        if (m < n) {
            return addBinary(b,a);
        }
        for (int i = m; i > -1; i--) {
            if (a.charAt(i) == '1') {
                carry++;
            }
            if (n > -1 && b.charAt(n--) == '1') {
                carry ++;
            }
            if (carry % 2 == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }
            carry = carry / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
     }
}
