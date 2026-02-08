package org.example.leetcode;

public class NTribonacciNumber {

    public int tribonacci(int n) {
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        int result = 0;
        if (n == 0) return 0;
        if (n < 3) return 1;

        for (int i = 3; i <= n; i++) {
            result = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = result;
        }

        return result;
    }
}