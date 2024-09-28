import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.print("Enter n: ");
        int n = new Scanner(System.in).nextInt();

        if (n < 0) {
            System.out.println("Negative number");
        } else if (n == 0 || n == 1) {
            System.out.println("f(" + n + ") = 0");
        } else {
            int a = 1;
            int b = 1;
            for (int i = 2; i <= n; i++) {
                int c = a + b;
                a = b;
                b = c;
            }
            System.out.println("f(" + n + ") = " + b);
        }
    }
}
