package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomizedSetTest {
    private RandomizedSet underTest;

    @BeforeEach
    void setUp() {
        underTest = new RandomizedSet();
    }

    @Test
    void shouldWorkWithSet() {
        RandomizedSet obj = new RandomizedSet();
        boolean param1 = obj.insert(0);
        boolean param2 = obj.insert(1);
        boolean param3 = obj.remove(0);
        boolean param4 = obj.insert(2);
        boolean param5 = obj.remove(1);
        int param6 = obj.getRandom();

        List<Object> params = List.of(param1, param2, param3, param4, param5, param6);
        List<Object> expected = List.of(true, true, true, true, true, 2);

        assertThat(params).isEqualTo(expected);
    }
}