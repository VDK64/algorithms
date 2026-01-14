package org.example.leetcode;

public class FirstAndLastPositionInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftIndex;
        int rightIndex;
        int[] result = new int[2];

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                leftIndex = mid;
                rightIndex = mid;

                int leftTarget = getPosition(nums, 0, mid - 1, target, false);
                int rightTarget = getPosition(nums, mid + 1, nums.length - 1, target, true);

                if (leftTarget != -1 && leftIndex > leftTarget) {
                    leftIndex = leftTarget;
                }

                if (rightTarget != -1 && rightIndex < rightTarget) {
                    rightIndex = rightTarget;
                }

                result[0] = leftIndex;
                result[1] = rightIndex;

                return result;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }

    private int getPosition(int[] nums, int left, int right, int target, boolean end) {
        int tempIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                tempIndex = mid;
                if (end) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (nums[mid] < target) {
                left = mid + 1;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return tempIndex;
    }
}