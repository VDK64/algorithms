package org.example.leetcode;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int climbStairs(int n, int[] costs) {
        if (n == 0) return 0;
        if (n == 1) return costs[0] + 1;
        int[] dp = new int[costs.length + 1];
        dp[0] = 0;
        dp[1] = costs[0] + 1;

        for (int i = 2; i <= costs.length; i++) {
            int index = i - 1;
            dp[i] = Integer.MAX_VALUE;
            if (i - 1 >= 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + costs[index] + ((int) Math.pow(i - (i - 1), 2)));
            }
            if (i - 2 >= 0) {
                dp[i] = Math.min(dp[i], dp[i - 2] + costs[index] + ((int) Math.pow(i - (i - 2), 2)));
            }
            if (i - 3 >= 0) {
                dp[i] = Math.min(dp[i], dp[i - 3] + costs[index] + ((int) Math.pow(i - (i - 3), 2)));
            }
        }

        return dp[dp.length - 1];
    }
}
