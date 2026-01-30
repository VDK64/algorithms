package org.example.leetcode;

public class HIndex {

    public int hIndex(int[] citations) {
        int max = 0;

        for (int citation : citations) {
            max = Math.max(max, citation);
        }

        int[] indices = new int[max + 1];

        for (int index : citations) {
            indices[index]++;
        }

        int h = 1;
        int counts = 0;

        for (int i = indices.length - 1; i >= 0; i--) {
            int count = indices[i];
            counts += count;
            if (counts >= i) {
                h = i;
                break;
            }
        }

        return h;
    }
}