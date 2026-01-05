package org.example.leetcode;

public class RemoveArrayElement {

    public int removeElement(int[] nums, int val) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                counter++;
            }
            if (nums[i] == val && i < nums.length - 1) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        counter++;
                        break;
                    }
                }
            }
        }

        return counter;
    }
}
