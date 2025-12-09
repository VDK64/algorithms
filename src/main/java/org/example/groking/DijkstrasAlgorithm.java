package org.example.groking;

import static java.util.Comparator.comparingInt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class DijkstrasAlgorithm {

  private final List<String> shortestPath;
  private int totalCost;

  public DijkstrasAlgorithm() {
    this.shortestPath = new ArrayList<>();
    this.totalCost = 0;
  }

  public List<String> findShortestPathWithNodes(Node root, Node end) {
    Queue<Node> nodeCostsQueue = new PriorityQueue<>(comparingInt(Node::getCost));
    root.setCost(0);
    nodeCostsQueue.add(root);

    while (!nodeCostsQueue.isEmpty()) {
      Node currentNode = nodeCostsQueue.poll();
      Set<Edge> relates = currentNode.getRelates();
      for (Edge relate : relates) {
        Node endNode = relate.getEnd();
        int edgeCost = relate.getCost();
        int currentNodeCost = currentNode.getCost();

        int path = currentNodeCost + edgeCost;
        if (path < endNode.getCost()) {
          if (!endNode.isProcessed()) {
            endNode.setCost(path);
            endNode.setPreviousStep(currentNode);
            nodeCostsQueue.remove(endNode);
            nodeCostsQueue.add(endNode);
          }
        }
      }

      currentNode.setProcessed(true);
    }

    this.totalCost = end.getCost();
    return findShortestPathWithNodes(end);
  }

  public List<String> findShortestPathWithAdjacentVertexes(
      Map<String, Map<String, Integer>> graph,
      Map<String, String> parents,
      Map<String, Integer> costs,
      String end) {

    Set<String> processed = new HashSet<>();
    String currentNode = findMinimalCost(costs, processed);

    while (currentNode != null) {
      Map<String, Integer> relates = graph.get(currentNode);

      for (Entry<String, Integer> entry : relates.entrySet()) {
        String key = entry.getKey();
        Integer value = entry.getValue();

        Integer initialCost = costs.get(currentNode);
        int result = initialCost + value;

        if (result < costs.get(key) && !processed.contains(currentNode)) {
          parents.put(key, currentNode);
          costs.put(key, result);
        }

      }

      processed.add(currentNode);
      currentNode = findMinimalCost(costs, processed);
    }

    List<String> path = new ArrayList<>();
    path.add(end);
    String current = parents.get(end);
    while (current != null) {
      path.add(current);
      current = parents.get(current);
    }

    Collections.reverse(path);
    return path;
  }

  private String findMinimalCost(Map<String, Integer> costs, Set<String> processed) {
    return costs.entrySet().stream()
        .filter(e -> !processed.contains(e.getKey()))
        .min(comparingInt(Entry::getValue))
        .map(Entry::getKey)
        .orElse(null);
  }

  private List<String> findShortestPathWithNodes(Node end) {
    this.shortestPath.add(end.getName());
    while (end.getPreviousStep() != null) {
      this.shortestPath.add(end.getPreviousStep().getName());
      end = end.getPreviousStep();
    }

    Collections.reverse(this.shortestPath);
    return this.shortestPath;
  }

  public int getTotalCost() {
    return totalCost;
  }

  public static final class Node {

    private final long id = new Random().nextLong();

    private final String name;
    private boolean processed;
    private int cost;
    private final Set<Edge> relates;
    private Node previousStep;

    public Node(String name) {
      this.name = name;
      this.relates = new HashSet<>();
      this.processed = false;
      this.cost = Integer.MAX_VALUE;
      this.previousStep = null;
    }

    public long getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public boolean isProcessed() {
      return processed;
    }

    public int getCost() {
      return cost;
    }

    public void setCost(int cost) {
      this.cost = cost;
    }

    public Set<Edge> getRelates() {
      return relates;
    }

    public Node getPreviousStep() {
      return previousStep;
    }

    public void setPreviousStep(Node previousStep) {
      this.previousStep = previousStep;
    }

    public void addRelates(Set<Edge> edge) {
      this.relates.addAll(edge);
    }

    public void setProcessed(boolean processed) {
      this.processed = processed;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Node node)) {
        return false;
      }
      return id == node.id && Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(id, name);
    }
  }

  public static final class Edge {

    private final long id = new Random().nextLong();

    private final Node start;
    private final Node end;
    private final int cost;

    public Edge(Node start, Node end, int cost) {
      this.start = start;
      this.end = end;
      this.cost = cost;
    }

    public Node getStart() {
      return start;
    }

    public Node getEnd() {
      return end;
    }

    public int getCost() {
      return cost;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Edge edge)) {
        return false;
      }
      return id == edge.id && cost == edge.cost && Objects.equals(start, edge.start)
          && Objects.equals(end, edge.end);
    }

    @Override
    public int hashCode() {
      return Objects.hash(id, start, end, cost);
    }
  }
}