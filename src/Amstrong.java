import java.util.Scanner;

public class Amstrong {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ams = 0;
        int m = n;

        while (m > 0) {
            int remain = m % 10;
            ams = ams + remain * remain * remain;
            m = m / 10;
        }

        if (ams == n) {
            System.out.println("The number is amstrong");
        } else {
            System.out.println("The number is not amstrong");
        }
    }
}
