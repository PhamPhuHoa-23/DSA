// 3. Write a program to input principal, time, and rate (P, T, R) from the user and find Simple Interest.

import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        System.out.print("Please fill out your Principal: ");
        double p = new Scanner(System.in).nextDouble();

        System.out.print("Please fill out your Time: ");
        double t = new Scanner(System.in).nextDouble();

        System.out.print("Please fill out your Rate: ");
        double r = new Scanner(System.in).nextDouble();

        System.out.println("Your Simple Interest Rate: " + p * t * r);
    }
}
