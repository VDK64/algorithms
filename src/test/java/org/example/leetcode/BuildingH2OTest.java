package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.jupiter.api.Test;

class BuildingH2OTest {

  private BuildingH2O buildingH2O;

  @Test
  void shouldCreateWater() throws InterruptedException {
    buildingH2O = new BuildingH2O();
    String water = "OOHHHH";
    List<String> list = new CopyOnWriteArrayList<>();
    List<Thread> threads = new ArrayList<>();

    for (Character character : water.toCharArray()) {
      if (character == 'H') {
        Thread hydrogenThread = new Thread(() -> {
          try {
            buildingH2O.hydrogen(() -> list.add("H"));
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        });
        threads.add(hydrogenThread);
        hydrogenThread.start();
      } else {
        Thread oxygenThread = new Thread(() -> {
          try {
            buildingH2O.oxygen(() -> list.add("O"));
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        });
        threads.add(oxygenThread);
        oxygenThread.start();
      }
    }

    threads.forEach(thread -> {
      try {
        thread.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    System.out.println(list);
    List<String> sublist = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      if (sublist.size() < 3) {
        sublist.add(list.get(i));
      }
      if (i % 3 == 0 && i != 0) {
        assertThat(sublist).containsExactlyInAnyOrder("H", "O", "H");
        sublist.clear();
        sublist.add(list.get(i));
      }
    }
  }
}