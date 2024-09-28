//  4. Take in two numbers and an operator (+, -, *, /) and calculate the value. (Use if conditions)

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.print("Enter your equation: ");
        Scanner sc = new Scanner(System.in);

        double num1 = sc.nextDouble();
        String operator = sc.next();
        double num2 = sc.nextDouble();

        double result;

        if (operator.equals("+")) {
            result = num1 + num2;
        } else if (operator.equals("-")) {
            result = num1 - num2;
        } else if (operator.equals("*")) {
            result = num1 * num2;
        } else if (operator.equals("/")){
            if (num2 == 0) {
                System.out.println("Cannot divided by zero");
                return;
            }
            else {
                result = num1 / num2;
            }
        } else {
            System.out.println("Invalid operator");
            return;
        }

        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
    }
}
