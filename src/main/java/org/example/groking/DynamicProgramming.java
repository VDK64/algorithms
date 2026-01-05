package org.example.groking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparingDouble;

public class DynamicProgramming {


    public List<String> findMaxValuable(List<Stuff> stuffs) {

        List<Stuff> sortedStuffs = stuffs.stream()
                .sorted(comparingDouble(Stuff::weight))
                .toList();

        double minWeight = sortedStuffs.get(0).weight();
        double maxWeight = sortedStuffs.get(sortedStuffs.size() - 1).weight();

        Map<Double, Integer> mappedWeight = mapWeightToColumns(stuffs);

        Cell[][] cells = new Cell[stuffs.size()][mappedWeight.size()];

        for (int i = 0; i < sortedStuffs.size(); i++) {
            Stuff currentStuff = sortedStuffs.get(i);
            for (double j = minWeight; j < maxWeight + minWeight; j += minWeight) {
                int column = mappedWeight.get(j);
                if (i == 0) {
                    cells[i][column] = new Cell(new ArrayList<>(List.of(currentStuff.name())),
                            currentStuff.weight(),
                            currentStuff.cost());
                } else {
                    Cell previousCell = cells[i - 1][column];

                    double resultWeight = j - currentStuff.weight();
                    if (resultWeight < 0) {
                        cells[i][column] = previousCell;
                    } else if (resultWeight == 0) {
                        int cost = currentStuff.cost();
                        double previousCost = previousCell.cost();
                        if (cost > previousCost) {
                            cells[i][column] = new Cell(new ArrayList<>(List.of(currentStuff.name())),
                                    currentStuff.weight(), currentStuff.cost());
                        } else {
                            cells[i][column] = new Cell(previousCell.values(),
                                    previousCell.weight(), previousCell.cost());
                        }

                    } else {
                        Cell previousCellByWeight = cells[i - 1][mappedWeight.get(resultWeight)];
                        List<String> values = new ArrayList<>(previousCellByWeight.values());
                        values.add(currentStuff.name());
                        cells[i][column] = new Cell(
                                values,
                                previousCellByWeight.weight() + currentStuff.weight(),
                                previousCellByWeight.cost() + currentStuff.cost()
                        );
                    }
                }
            }
        }

        return cells[stuffs.size() - 1][mappedWeight.size() - 1].values();
    }

    public Map<Double, Integer> mapWeightToColumns(List<Stuff> input) {
        if (input == null || input.isEmpty()) {
            return Map.of();
        }

        Map<Double, Integer> resultMap = new HashMap<>();
        List<Double> list = input.stream()
                .map(Stuff::weight)
                .sorted()
                .toList();

        double max = list.get(list.size() - 1);
        double min = list.get(0);

        int counter = 0;
        for (double i = min; i < max + min; i += min) {
            resultMap.put(i, counter);
            counter++;
        }

        return resultMap;
    }

    private record Cell(List<String> values, double weight, double cost) {

    }

    public record Stuff(String name, double weight, int cost) {

    }
}