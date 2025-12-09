package org.example.groking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GreedyAlgorithm {

  public List<String> findRadioSet(Set<String> statesNeeded, Map<String, Set<String>> stations) {
    List<String> stationList = new ArrayList<>();
    Set<String> currentNeeded = new HashSet<>(statesNeeded);

    while (!currentNeeded.isEmpty()) {
      Set<String> bestCoverage = Set.of();
      String bestStation = null;
      for (Entry<String, Set<String>> entry : stations.entrySet()) {
        String station = entry.getKey();
        Set<String> states = entry.getValue();

        HashSet<String> currentCoverage = new HashSet<>(currentNeeded);
        currentCoverage.retainAll(states);

        if (currentCoverage.size() > bestCoverage.size()) {
          bestCoverage = currentCoverage;
          bestStation = station;
        }
      }

      currentNeeded.removeAll(bestCoverage);
      stationList.add(bestStation);
      stations.remove(bestStation);
    }

    return stationList;
  }
}