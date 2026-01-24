package org.example.leetcode;

import java.util.Arrays;

public class SortEvenAndOddIndicesIndependently {

    public int[] sortEvenOdd(int[] nums) {
        Integer[] even = new Integer[nums.length];
        Integer[] odd = new Integer[nums.length];
        int evenIndex = 0;
        int oddIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even[evenIndex] = nums[i];
                evenIndex++;
            } else {
                odd[oddIndex] = nums[i];
                oddIndex++;
            }
        }

        Arrays.sort(even, (o1, o2) -> {
            if (o1 != null && o2 != null) {
                return o1 - o2;
            } else {
                return 0;
            }
        });
        Arrays.sort(odd, (o1, o2) -> {
            if (o1 != null && o2 != null) {
                return o2 - o1;
            } else {
                return 0;
            }
        });

        int[] result = new int[nums.length];
        evenIndex = 0;
        oddIndex = 0;

        for (int i = 0; i < result.length; i++) {
            if (i % 2 == 0) {
                result[i] = even[evenIndex];
                evenIndex++;
            } else {
                result[i] = odd[oddIndex];
                oddIndex++;
            }
        }

        return result;
    }
}
