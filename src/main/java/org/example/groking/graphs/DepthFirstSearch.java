package org.example.groking.graphs;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DepthFirstSearch {

  public String findSellerName(Node root, Map<Node, Set<Node>> graphs) {
    Deque<Node> searchingQueue = new LinkedList<>(graphs.get(root));
    Set<Node> searched = new HashSet<>();

    while (!searchingQueue.isEmpty()) {
      Node element = searchingQueue.pollFirst();
      if (!searched.contains(element)) {
        if (element.seller) {
          return element.name();
        } else {
          searchingQueue.addAll(graphs.get(element));
          searched.add(element);
        }
      }

    }

    throw new RuntimeException("Seller not found");
  }

  public int findStepToSeller(Node root, Map<Node, Set<Node>> graphs) {
    Deque<Node> searchingQueue = new LinkedList<>(graphs.get(root));
    Set<Node> nested = new HashSet<>();
    Set<Node> searched = new HashSet<>();
    int step = 1;

    while (!searchingQueue.isEmpty() || !nested.isEmpty()) {
      if (searchingQueue.isEmpty()) {
        searchingQueue.addAll(nested);
        step++;
      }

      Node element = searchingQueue.pollFirst();
      if (!searched.contains(element)) {
        if (element.seller()) {
          return step;
        } else {
          nested.addAll(graphs.get(element));
          searched.add(element);
        }
      }
    }

    throw new RuntimeException("Seller not found");
  }


  public record Node(String name, boolean seller) {

    @Override
    public String toString() {
      return "Node[" +
          "name=" + name + ", " +
          "seller=" + seller + ']';
    }
  }
}