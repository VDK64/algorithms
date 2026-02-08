package org.example.leetcode;

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        if (nums.length < 3) {
            return Math.max(nums[0], nums[1]);
        }

        int first = nums[0];
        int second = Math.max(nums[1], first);
        int result = 0;

        for (int i = 2; i < nums.length; i++) {
            result = Math.max(second, nums[i] + first);
            first = second;
            second = result;
        }

        return result;
    }
}
