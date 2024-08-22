// 1. Write a program to print whether a number is even or odd, also take input from the user.

import java.util.Scanner;

public class Inputs
{
    public static void main(String[] args)
    {
        System.out.print("Please enter your number: ");

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        if (num % 2 == 0)
        {
            System.out.println("Your number is a even number!");
        }
        else
        {
            System.out.println("Your number is a odd number!");
        }
    }
}
