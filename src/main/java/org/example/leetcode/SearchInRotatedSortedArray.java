package org.example.leetcode;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int index = searchRotationIndex(nums);

        if (index == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        int firstResult = binarySearch(nums, target, 0, index - 1);

        if (firstResult != -1) {
            return firstResult;
        } else {
            return binarySearch(nums, target, index, nums.length - 1);
        }
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }

    private int searchRotationIndex(int[] nums) {
        if (nums.length == 1) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] < nums[0] && nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[mid] < nums[0] && nums[mid] > nums[mid - 1]) {
                right = mid - 1;
            } else if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                break;
            }
        }

        return -1;
    }
}