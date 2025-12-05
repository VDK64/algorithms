package org.example.groking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.example.groking.DijkstrasAlgorithm.Edge;
import org.example.groking.DijkstrasAlgorithm.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DijkstrasAlgorithmTest {

  private DijkstrasAlgorithm underTest;

  @BeforeEach
  void setUp() {
    underTest = new DijkstrasAlgorithm();
  }

  @ParameterizedTest
  @MethodSource("source")
  void shouldFindShortestPath_when_NodesInfo(TestData testData,
      List<String> expected,
      int expectedCost) {

    List<String> path = underTest.findShortestPathWithNodes(testData.root, testData.end);
    int totalCost = underTest.getTotalCost();

    assertThat(path).containsExactly(expected.toArray(String[]::new));
    assertThat(totalCost).isEqualTo(expectedCost);
  }

  @Test
  void shouldFindShortestPath_when_AdjacentVertex() {

    Map<String, Map<String, Integer>> graph = new HashMap<>();
    Map<String, String> parents = new HashMap<>();
    Map<String, Integer> costs = new HashMap<>();

    graph.put("S", Map.of("B", 2, "A", 6));
    graph.put("B", Map.of("A", 3, "E", 5));
    graph.put("A", Map.of("E", 1));
    graph.put("E", Map.of());

    costs.put("A", Integer.MAX_VALUE);
    costs.put("B", Integer.MAX_VALUE);
    costs.put("E", Integer.MAX_VALUE);
    costs.put("S", 0);

    List<String> result = underTest.findShortestPathWithAdjacentVertexes(
        graph,
        parents,
        costs,
        "S",
        "E"
    );

    assertThat(result).containsExactly("S", "B", "A", "E");


  }

  private static List<Arguments> source() {
    return List.of(
        Arguments.of(createShortGraph(), List.of("S", "B", "A", "E"), 6),
        Arguments.of(createLongGraph(), List.of("A", "B", "D", "F", "H", "G", "J"), 87)
    );
  }

  private static TestData createLongGraph() {
    Node a = new Node("A");
    Node b = new Node("B");
    Node c = new Node("C");
    Node d = new Node("D");
    Node e = new Node("E");
    Node f = new Node("F");
    Node g = new Node("G");
    Node h = new Node("H");
    Node i = new Node("I");
    Node j = new Node("J");

    a.addRelates(Set.of(new Edge(a, b, 10)));
    b.addRelates(Set.of(new Edge(b, c, 12), new Edge(b, d, 3)));
    d.addRelates(Set.of(new Edge(d, e, 20), new Edge(d, f, 5)));
    e.addRelates(Set.of(new Edge(e, h, 11)));
    f.addRelates(Set.of(new Edge(f, h, 12)));
    h.addRelates(Set.of(new Edge(h, g, 7), new Edge(h, i, 3)));
    g.addRelates(Set.of(new Edge(g, j, 50)));
    i.addRelates(Set.of(new Edge(i, j, 100)));

    return new TestData(a, j);
  }

  private static TestData createShortGraph() {
    Node a = new Node("A");
    Node b = new Node("B");
    Node e = new Node("E");
    Node s = new Node("S");

    s.addRelates(Set.of(new Edge(s, a, 6), new Edge(s, b, 2)));
    b.addRelates(Set.of(new Edge(b, a, 3), new Edge(b, e, 5)));
    a.addRelates(Set.of(new Edge(a, e, 1)));

    return new TestData(s, e);
  }

  private record TestData(Node root, Node end) {

  }
}