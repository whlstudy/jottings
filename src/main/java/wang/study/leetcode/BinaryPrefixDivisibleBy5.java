package wang.study.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    // there are to many digits, exceeded the limit of double.
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>(A.length);
        for (int i = 0; i < A.length; i++) {
            double tmp = 0;
            for (int j = 0; j <= i; j++) {
                if (A[j] == 1) {
                    int nu = i - j;
                    tmp += Math.pow(2, nu);
                }
            }
            if (tmp % 5 == 0) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    // simple method
    public List<Boolean> prefixesDivBy52(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int remainder = 0;
        for (int a : A) {
            remainder = ((remainder << 1) + a) % 5;
            res.add(remainder == 0);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(prefixesDivBy5(new int[]{0, 1, 1}));
    }
}
