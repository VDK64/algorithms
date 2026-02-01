package org.example.leetcode;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length + 1];
        int[] right = new int[nums.length + 1];
        left[0] = 1;
        right[right.length - 1] = 1;

        for (int i = 0; i < nums.length; i++) {
            int leftElement = nums[i];
            int rightElement = nums[nums.length - 1 - i];

            left[i + 1] = leftElement * left[i];
            right[right.length - 2 - i] = rightElement * right[right.length - 1 - i];
        }

        int[] output = new int[nums.length];

        for (int i = 0; i < output.length; i++) {
            output[i] = left[i] * right[i + 1];
        }

        return output;
    }
}
