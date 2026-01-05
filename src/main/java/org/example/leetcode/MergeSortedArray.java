package org.example.leetcode;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int right = m + n - 1;
        int last = m-1;
        int current = n - 1;

        while (current > -1) {
            if (last < 0) {
                nums1[right] = nums2[current];
                current--;
            } else {
                if (nums1[last] < nums2[current]) {
                    nums1[right] = nums2[current];
                    current--;
                } else {
                    nums1[right] = nums1[last];
                    last--;
                }
            }
            right--;
        }
    }
}
