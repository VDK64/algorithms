package org.example.leetcode;

import java.util.*;

public class RandomizedSet {
    private final Map<Integer, Integer> map;
    private final List<Integer> setValues;
    private final Random random;

    public RandomizedSet() {
        this.random = new Random();
        this.map = new HashMap<>();
        this.setValues = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            setValues.add(val);
            map.put(val, setValues.size() - 1);
            return true;
        }

        return false;
    }

    public boolean remove(int val) {
        Integer value = map.remove(val);
        if (value != null) {
            setValues.remove(((Integer) val));
            return true;
        }

        return false;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(0, setValues.size());

        return setValues.get(randomIndex);
    }
}