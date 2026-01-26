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
}