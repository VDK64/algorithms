package org.example.leetcode;

public class SortAnArray {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int pivot = nums[low + (high - low) / 2];
        int i = low;
        int j = high;

        while (i <= j) {
            while (nums[i] < pivot) i++;
            while (nums[j] > pivot) j--;

            if (i <= j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j--;
            }
        }

        if (low < j) quickSort(nums, low, j);
        if (high > i) quickSort(nums, i, high);
    }
}