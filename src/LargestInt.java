// 5. Take 2 numbers as input and print the largest number.

import java.util.Scanner;

public class LargestInt {
    public static void main(String[] args) {
        System.out.print("Please enter two numbers: ");
        Scanner sc = new Scanner(System.in);

        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();

        if (num1 > num2) {
            System.out.println(num1 + " is the largest number");
        } else {
            System.out.println(num2 + " is the largest number");
        }
    }
}
