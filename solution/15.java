import java.util.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in .nextInt();
        while (t-- > 0) {
            int m = in .nextInt();
            int n = in .nextInt();

            BigInteger Required = factorial(BigInteger.valueOf(n + m)).divide(factorial(BigInteger.valueOf(n))).divide(factorial(BigInteger.valueOf(m))).mod((BigInteger.valueOf(1000000007)));
            System.out.println(Required.toString());


        }
    }

    static BigInteger factorial(BigInteger n) {
        if (n == BigInteger.ZERO)
            return BigInteger.ONE;

        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}