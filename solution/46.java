import java.util.*;

public class Solution {
    private static boolean[] prime = null;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in .nextInt();
        generatePrimes();

        for (int i = 0; i < numberOfTestCases; i++) {
            int res = 0;
            int n = in .nextInt();
            for (int j = 2; j <= n; j++) {
                if (prime[j]) {
                    int diff = n - j;
                    if (diff % 2 == 0 && isPerfectSquare(diff / 2))
                        res += 1;
                }
            }
            System.out.println(res);
        }
    }

    public static boolean isPerfectSquare(int input) {
        int root = (int) Math.sqrt(input);
        return input == root * root;
    }

    public static void generatePrimes() {
        int limit = 1000000;
        prime = new boolean[limit + 1];
        prime[2] = true;
        prime[3] = true;
        int root = (int) Math.ceil(Math.sqrt(limit));

        //Sieve of Atkin for prime number generation
        for (int x = 1; x < root; x++) {
            for (int y = 1; y < root; y++) {
                int n = 4 * x * x + y * y;
                if (n <= limit && (n % 12 == 1 || n % 12 == 5))
                    prime[n] = !prime[n];

                n = 3 * x * x + y * y;
                if (n <= limit && n % 12 == 7)
                    prime[n] = !prime[n];

                n = 3 * x * x - y * y;
                if ((x > y) && (n <= limit) && (n % 12 == 11))
                    prime[n] = !prime[n];
            }
        }

        for (int i = 5; i <= root; i++) {
            if (prime[i]) {
                for (int j = i * i; j < limit; j += i * i) {
                    prime[j] = false;
                }
            }
        }
    }
}