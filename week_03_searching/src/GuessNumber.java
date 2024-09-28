import java.util.Random;

public class GuessNumber {
    public static int GUESS_NUM = 10;
    public static void main(String[] args) {
        int n = 200;
        System.out.println("Guess Number is: " + findGuessNumber(n));
    }

    static int guess(int n) {
        if (n < GUESS_NUM) {
            return -1;
        }
        else if (n > GUESS_NUM) {
            return 1;
        }
        else {
            return 0;
        }
    }

    static int findGuessNumber(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int guessed = guess(mid);

            if (guessed == -1) {
                start = mid + 1;
            }
            else if (guessed == 0) {
                return mid;
            }
            else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
