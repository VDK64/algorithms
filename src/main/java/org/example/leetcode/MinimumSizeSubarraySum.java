package org.example.leetcode;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minimum = Integer.MAX_VALUE;
        int elements = 0;
        int current = 0;

        for (int num : nums) {
            elements++;
            current += num;
            while (current >= target) {
                minimum = Math.min(minimum, elements);
                current -= nums[left];
                left++;
                elements--;
            }
        }

        return minimum == Integer.MAX_VALUE ? 0 : minimum;
    }
}
