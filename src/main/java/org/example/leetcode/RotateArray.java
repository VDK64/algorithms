package org.example.leetcode;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int safeK = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, safeK - 1);
        reverse(nums, safeK, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        int shift = 0;
        for (int i = start; i < end; i++) {
            int temp = nums[i];
            nums[i] = nums[end - shift];
            nums[end - shift] = temp;
            if (i - start == (end - start - 1) / 2) {
                break;
            }

            shift++;
        }
    }
}