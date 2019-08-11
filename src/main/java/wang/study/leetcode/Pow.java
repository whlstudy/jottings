package wang.study.leetcode;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        return myPow(x * x, n / 2) * (n % 2 == 0 ? 1 : (n > 0 ? x : 1 / x));
    }
}
