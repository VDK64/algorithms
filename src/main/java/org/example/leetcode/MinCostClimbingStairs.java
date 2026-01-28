package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {
    private final Map<Integer, Integer> cache = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        return Math.min(count(cost, n - 1), count(cost, n - 2));
    }

    private int count(int[] cost, int n) {
        if (n < 2) {
            return cost[n];
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int result = cost[n] + Math.min(count(cost, n - 1), count(cost, n - 2));

        cache.put(n, result);
        return result;
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int firstOption = dp[i - 1] + cost[i - 1];
            int secondOption = dp[i - 2] + cost[i - 2];

            dp[i] = Math.min(firstOption, secondOption);
        }

        return dp[n];
    }

    public int minCostClimbingStairs3(int[] cost) {
        int length = cost.length;
        int first = cost[0];
        int second = cost[1];
        if (length <= 2) return Math.min(first, second);

        for (int i = 2; i < length; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }

        return Math.min(first, second);
    }
}