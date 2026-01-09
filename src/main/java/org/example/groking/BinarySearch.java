package org.example.groking;

import java.util.Arrays;

public class BinarySearch {

    public int search(int[] input, int target) {
        int[] sorted = Arrays.stream(input)
                .sorted()
                .toArray();

        int start = 0;
        int end = input.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (sorted[middle] == target) {
                return middle;
            }

            if (sorted[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return -1;
    }
}
