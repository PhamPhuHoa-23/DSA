// 5. Take 2 numbers as input and print the largest number.

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        System.out.print("Rupees: ");
        Scanner sc = new Scanner(System.in);

        double dollars = sc.nextDouble() * 0.012;
        System.out.println("Dollars: " + dollars);
    }
}
