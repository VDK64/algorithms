package org.example.groking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.example.groking.DynamicProgramming.Stuff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DynamicProgrammingTest {

  private DynamicProgramming underTest;

  @BeforeEach
  void setUp() {
    underTest = new DynamicProgramming();
  }

  @Test
  void shouldPackMostValuableBackPack() {
    List<Stuff> stuffs = List.of(
        new Stuff("laptop", 3, 2000),
        new Stuff("guitar", 1, 1500),
        new Stuff("iphone", 1, 1000),
        new Stuff("recorder", 4, 3000)
    );

    List<String> result = underTest.findMaxValuable(stuffs);

    assertThat(result).containsExactlyInAnyOrder("laptop", "guitar");
  }

  @Test
  void shouldFindPath() {
    List<Stuff> stuffs = List.of(
        new Stuff("W", 0.5, 7),
        new Stuff("T", 0.5, 6),
        new Stuff("S", 0.5, 8),
        new Stuff("N", 1, 9),
        new Stuff("B", 2, 9)
    );

    List<String> result = underTest.findMaxValuable(stuffs);

    assertThat(result).containsExactlyInAnyOrder("S", "W", "N");
  }
}