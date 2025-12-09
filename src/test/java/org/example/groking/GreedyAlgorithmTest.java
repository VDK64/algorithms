package org.example.groking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GreedyAlgorithmTest {

  private GreedyAlgorithm underTest;

  @BeforeEach
  void setUp() {
    underTest = new GreedyAlgorithm();
  }

  @Test
  void shouldFindRadioSet() {
    Set<String> statesNeeded = new HashSet<>(Set.of(
        "mt", "wa", "or", "id", "nv", "ut", "ca", "az"
    ));

    Map<String, Set<String>> stations = new HashMap<>(Map.of(
        "kone", Set.of("id", "nv", "ut"),
        "ktwo", Set.of("wa", "id", "mt"),
        "kthree", Set.of("or", "nv", "ca"),
        "kfour", Set.of("nv", "ut"),
        "kfive", Set.of("ca", "az")
    ));

    List<String> result = underTest.findRadioSet(statesNeeded, stations);

    Set<Set<String>> validSolutions = Set.of(
        Set.of("kone", "ktwo", "kthree", "kfive"),
        Set.of("ktwo", "kthree", "kfour", "kfive")
    );

    assertThat(new HashSet<>(result)).isIn(validSolutions);
  }
}