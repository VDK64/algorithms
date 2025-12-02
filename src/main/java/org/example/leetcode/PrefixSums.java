package org.example.leetcode;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.HashMap;
import java.util.Map;

public class PrefixSums {

  public long maxSubarraySum(int[] nums, int k) {
    Map<Integer, Long> prefixMap = new HashMap<>();
    prefixMap.put(0, 0L);
    long preffixSum = 0L;
    long result = Long.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      preffixSum += nums[i];
      int currentIndex = (i + 1) % k;
      Long currentPrefix = prefixMap.get(currentIndex);
      if (currentPrefix != null) {
        result = max(preffixSum - currentPrefix, result);
      }
      long currentMinimum = min(
          preffixSum, prefixMap.getOrDefault(currentIndex, Long.MAX_VALUE));
      prefixMap.put(currentIndex, currentMinimum);
    }

    return result;
  }
}