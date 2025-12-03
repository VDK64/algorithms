package org.example.groking.graphs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DepthFirstSearch {

  public String findSellerName(Node root, Map<Node, Set<Node>> graphs) {
    Deque<Node> searchingQueue = new LinkedList<>(graphs.get(root));
    Set<Node> searched = new HashSet<>();

    while (!searchingQueue.isEmpty()) {
      Node element = searchingQueue.pollFirst();
      if (!searched.contains(element)) {
        if (element.sign()) {
          return element.name();
        } else {
          searchingQueue.addAll(graphs.getOrDefault(element, Set.of()));
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
        if (element.sign()) {
          return step;
        } else {
          nested.addAll(graphs.getOrDefault(element, Set.of()));
          searched.add(element);
        }
      }
    }

    throw new RuntimeException("Seller not found");
  }

  public List<String> getAllFilesDepthFirstAlgorithm(Node root, Map<Node, Set<Node>> graphs) {
    Deque<Node> searchingQueue = new LinkedList<>(graphs.get(root));
    List<String> result = new ArrayList<>();

    while (!searchingQueue.isEmpty()) {
      Node element = searchingQueue.pollFirst();
      if (element.sign()) {
        result.add(element.name());
      } else {
        searchingQueue.addAll(graphs.getOrDefault(element, Set.of()));
      }
    }

    return result;
  }

  public List<String> getAllFilesBreadthFirstAlgorithm(
      Node root, Map<Node,
      Set<Node>> graphs,
      List<String> result
  ) {

    Set<Node> relateNodes = graphs.get(root);

    for (Node node : relateNodes) {
      if (node.sign()){
        result.add(node.name());
      } else {
        getAllFilesBreadthFirstAlgorithm(node, graphs, result );
      }
    }

    return result;
  }

  public List<String> topologicalSort(Node root, Map<Node, Set<Node>> graphs) {

    return null;
  }


  public record Node(String name, boolean sign) {

    @Override
    public String toString() {
      return "Node[" +
          "name=" + name + ", " +
          "sign=" + sign + ']';
    }
  }
}