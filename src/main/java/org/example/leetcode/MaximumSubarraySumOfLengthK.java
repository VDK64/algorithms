package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarraySumOfLengthK {

    public long maximumSubarraySum(int[] nums, int k) {
        long maxCount = 0;
        long currentSum = 0;
        int begin = 0;
        int end = 0;

        Map<Integer, Integer> numToIndex = new HashMap<>();

        while (end < nums.length) {
            int currNum = nums[end];
            int lastOccurrence = numToIndex.getOrDefault(currNum, -1);
            while (begin <= lastOccurrence || end - begin + 1 > k) {
                currentSum -= nums[begin];
                begin++;
            }

            numToIndex.put(currNum, end);
            currentSum += nums[end];
            if (end - begin + 1 == k) {
                maxCount = Math.max(maxCount, currentSum);
            }

            end++;
        }

        return maxCount;
    }
}