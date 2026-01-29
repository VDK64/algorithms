package org.example.leetcode;

import java.util.*;

public class RepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> occurrences = new HashMap<>();
        Set<String> repeated = new HashSet<>();
        List<String> result = new ArrayList<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            if (right - left + 1 == 10) {
                String substring = s.substring(left, right + 1);
                occurrences.merge(substring, 1, Integer::sum);
                Integer times = occurrences.get(substring);
                if (times > 1 && !repeated.contains(substring)) {
                    repeated.add(substring);
                    result.add(substring);
                }

                left++;
            }
        }

        return result;
    }
}
