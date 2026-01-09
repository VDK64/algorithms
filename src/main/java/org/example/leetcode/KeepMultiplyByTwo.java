package org.example.leetcode;

import java.util.Arrays;

public class KeepMultiplyByTwo {

    public static int findFinalValueWithSorting(int[] nums, int original) {
        int[] sortedNums = Arrays.stream(nums)
                .sorted()
                .toArray();

        for (int current : sortedNums) {
            if (current == original) {
                original *= 2;
            }
        }

        return original;
    }

    public static int findFinalValue(int[] nums, int original) {
        boolean isFoundInArray = true;

        while (isFoundInArray) {
            isFoundInArray = isFound(nums, original);

            if (isFoundInArray) {
                original *= 2;
            }
        }

        return original;
    }

    public static boolean isFound(int[] nums, int var) {
        for (int current : nums) {
            if (current == var) {
                return true;
            }
        }

        return false;
    }
}