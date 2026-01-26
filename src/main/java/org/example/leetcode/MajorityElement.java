package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> elements = new HashMap<>();
        int majority = 0;
        int majorityElement = Integer.MIN_VALUE;

        for (int num : nums) {
            elements.merge(num, 1, Integer::sum);
            Integer count = elements.get(num);

            if (count > majority) {
                majority = count;
                majorityElement = num;
            }
        }

        return majorityElement;
    }
}
