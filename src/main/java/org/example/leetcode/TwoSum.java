package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int current = nums[i];
      int key = target - current;
      if (map.containsKey(key)) {
        return new int[]{map.get(key), i};
      }
      map.put(current, i);
    }

    return null;
  }
}