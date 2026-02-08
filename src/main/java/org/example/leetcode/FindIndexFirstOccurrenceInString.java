package org.example.leetcode;

public class FindIndexFirstOccurrenceInString {

    public int strStr(String haystack, String needle) {
        int left;
        int right;
        int needleIndex = 0;
        int result = -1;
        char[] hArray = haystack.toCharArray();
        char[] nArray = needle.toCharArray();

        for (int i = 0; i < hArray.length; i++) {
            if (hArray[i] == nArray[0] && i + nArray.length - 1 < hArray.length) {
                left = i;
                result = i;
                right = left + nArray.length - 1;

                for (int j = left; j <= right; j++) {
                    if (hArray[j] == nArray[needleIndex]) {
                        needleIndex++;
                    } else {
                        needleIndex = 0;
                        result = -1;
                        break;
                    }
                }

                if (needleIndex == nArray.length) {
                    return result;
                }
            }
        }

        return result;
    }
}
