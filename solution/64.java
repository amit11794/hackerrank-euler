import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int upper = in .nextInt();
    int result = 0;

    for (int n = 1; n <= upper; n++) {
      int limit = (int) Math.sqrt(n);
      if (limit * limit == n) continue;

      int period = 0;
      int d = 1;
      int m = 0;
      int a = limit;

      do {
        m = d * a - m;
        d = (n - m * m) / d;
        a = (limit + m) / d;
        period++;
      } while (a != 2 * limit);

      if (period % 2 == 1) result++;
    }
    System.out.println(result);
  }
}