import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        String str = (new Scanner(System.in)).next();

        int length = str.length();
        int middle = length / 2;
        for (int i = 0;  i < middle; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                System.out.println("This string is not a Palindrome string");
            }
        }
        System.out.println("This string is a Palindrome string");
    }
}
