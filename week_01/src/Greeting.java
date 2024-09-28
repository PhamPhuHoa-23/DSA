// 2. Take name as input and print a greeting message for that particular name.

import java.util.Scanner;

public class Greeting
{
    public static void main(String[] args)
    {
        System.out.print("Please enter your name: ");

        Scanner sc = new Scanner(System.in);

        String name = sc.next();

        System.out.println("Hello, " + name + "!");
    }
}
