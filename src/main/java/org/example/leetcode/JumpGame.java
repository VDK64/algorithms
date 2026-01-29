package org.example.leetcode;

public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int goal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }

    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int jump = 0;

        while (right < nums.length - 1) {
            int max = 0;
            for (int i = left; i <= right; i++) {
                max = Math.max(max, i + nums[i]);
            }

            left = right + 1;
            right = max;
            jump++;
        }

        return jump;
    }

}