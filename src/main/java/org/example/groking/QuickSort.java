package org.example.groking;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {


    public List<Integer> sort(List<Integer> input) {
        if (input == null) {
            return List.of();
        }

        if (input.size() < 2) {
            return input;
        }

        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        int pivotIndex = input.size() / 2;
        Integer pivot = input.get(pivotIndex);

        for (int i = 0; i < input.size(); i++) {
            Integer current = input.get(i);
            if (current > pivot) {
                greater.add(current);
            } else if (i != pivotIndex) {
                less.add(current);
            }
        }

        List<Integer> sortedLess = sort(less);
        List<Integer> sortedGreater = sort(greater);

        List<Integer> result = new ArrayList<>(sortedLess);
        result.add(pivot);
        result.addAll(sortedGreater);

        return result;
    }

    public int[] sort(int[] input) {
        quickSort(input, 0, input.length - 1);

        return input;
    }

    private void quickSort(int[] input, int low, int high) {
        if (low >= high) return;
        int pivotIndex = low + (high - low) / 2;
        int pivot = input[pivotIndex];
        int i = low;
        int j = high;

        while (i <= j) {
            while (input[i] < pivot) i++;
            while (input[j] > pivot) j--;

            if (i <= j) {
                int temp = input[j];
                input[j] = input[i];
                input[i] = temp;
                i++;
                j--;
            }
        }
        if (low < j) quickSort(input, low, j);
        if (high > j) quickSort(input, i, high);
    }


}