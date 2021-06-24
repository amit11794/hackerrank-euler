#include <iostream>
#include <cmath>

//#define ORIGINAL

int main()
{
  unsigned int tests;
  std::cin >> tests;

  while (tests--)
  {
    unsigned long long minimum = 1000000000000ULL;

    unsigned long long p = 1;
    unsigned long long q = 2;
    std::cin >> p >> q >> minimum;

    unsigned long long blue = 0;
    unsigned long long red  = 0;

    // special code for p/q = 1/2
    if (p == 1 && q == 2)
    {
      blue = 15;
      red  =  6;

      // keep going until limit is reached
      while (blue + red < minimum)
      {
        // at first I brute-forced the first solutions and wrote them down
        // then I saw the following relationship for p/q = 1/2:
        //  red(i+1) = 2 * blue(i) + red(i) - 1;
        // blue(i+1) = 2 * red(i+1)
        red   = 2 * blue + red - 1; // seems to be true for most p/q
        blue += 2 * red;            // but this line is not correct for p/q != 1/2
      }

      std::cout << blue << " " << (red + blue) << std::endl;

      continue;
    }

    // brute-force smallest solution
    bool found = false;
    for (blue = 2; blue < 100000; blue++)
    {
      // sum = red + blue
      // blue * (blue - 1) / (sum * (sum - 1)) = p / q
      // blue * (blue - 1) * q / p = sum * (sum - 1)
      unsigned long long b2 = blue * (blue - 1);
      b2 *= q;
      // right side must be an integer
      if (b2 % p != 0)
        continue;
      unsigned long long sum2 = b2 / p; // sum2 = sum * (sum - 1)

      // (sum-1)^2 < sum2 < sum^2
      unsigned long long sum  = std::sqrt(sum2) + 1;
      // sqrt may have returned a floating-point number
      if (sum * (sum - 1) != sum2)
        continue;

      // now we have the correct solution if minimum is small (< 100000)
      red = sum - blue;
      if (blue + red >= minimum)
      {
        found = true;
        break;
      }
    }

    // failed ? TODO: this means just that my simple search aborted
    if (!found)
    {
      std::cout << "No solution" << std::endl;
      continue;
    }

    // show solution
    std::cout << blue << " " << (red + blue) << std::endl;
  }

  return 0;
}
