package org.example.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeSort {

    public static List<Integer> sort(List<Integer> input) {
        if (input == null || input.isEmpty()) {
            return List.of();
        }

        return mergeSort(input);
    }

    private static List<Integer> mergeSort(List<Integer> input) {
        if (input.size() == 1) {
            return input;
        }

        int half = input.size() / 2;

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            if (i < half) {
                leftList.add(input.get(i));
            } else {
                rightList.add(input.get(i));
            }
        }

        List<Integer> mergedLeft = mergeSort(leftList);
        List<Integer> mergedRight = mergeSort(rightList);

        return merge(mergedLeft, mergedRight);
    }

    private static List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> leftIterator = leftList.iterator();
        Iterator<Integer> rightIterator = rightList.iterator();
        Integer leftCurrent;
        Integer rightCurrent;

        while (leftIterator.hasNext() || rightIterator.hasNext()) {
            if (leftIterator.hasNext()) {
                leftCurrent = leftIterator.next();
            } else {
                leftCurrent = null;
            }

            if (rightIterator.hasNext()) {
                rightCurrent = rightIterator.next();
            } else {
                rightCurrent = null;
            }

            if (leftCurrent != null && rightCurrent != null) {
                if (leftCurrent > rightCurrent) {
                    result.add(rightCurrent);
                    result.add(leftCurrent);
                } else {
                    result.add(leftCurrent);
                    result.add(rightCurrent);
                }
            } else if (leftCurrent != null) {
                result.add(leftCurrent);

            } else if (rightCurrent != null) {
                result.add(rightCurrent);
            }
        }

        return result;
    }
}