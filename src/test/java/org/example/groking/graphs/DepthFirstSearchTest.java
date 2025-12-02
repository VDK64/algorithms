package org.example.groking.graphs;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.example.groking.graphs.DepthFirstSearch.Node;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InstancioExtension.class)
class DepthFirstSearchTest {

  private DepthFirstSearch underTest;

  @BeforeEach
  void setUp() {
    underTest = new DepthFirstSearch();
  }

  @Test
  void shouldFindSellerName() {
    TestData testData = createTestDataWithNamedNodes();

    String sellerName = underTest.findSellerName(testData.root, testData.graphs);

    assertThat(sellerName).isEqualTo("Jane");
  }

  @Test
  void shouldCountStepToSeller() {
    TestData testData = createTestDataWithNamedNodes();

    int step = underTest.findStepToSeller(testData.root, testData.graphs);

    assertThat(step).isEqualTo(4);
  }

  private TestData createTestDataWithNamedNodes() {
    Node anne = new Node("Anne", false);
    Node dorris = new Node("Dorris", false);
    Node brant = new Node("Brant", false);
    Node alesha = new Node("Alesha", false);
    Node wildur = new Node("Wildur", false);
    Node jane = new Node("Jane", true);
    Node sam = new Node("Sam", true);

    Map<Node, Set<Node>> graphs = new HashMap<>();
    graphs.put(sam, Set.of());
    graphs.put(jane, Set.of(sam));
    graphs.put(wildur, Set.of(jane));
    graphs.put(alesha, Set.of(wildur));
    graphs.put(dorris, Set.of(alesha));
    graphs.put(brant, Set.of(alesha));
    graphs.put(anne, Set.of(dorris, brant));

    return new TestData(anne, graphs);
  }

  private TestData createTestDataWithLetterNodes() {
    Map<String, Node> nodes = new HashMap<>();
    Map<Node, Set<Node>> graphs = new HashMap<>();
    for (char ch = 'A'; ch <= 'Q'; ch++) {
      String letter = String.valueOf(ch);

      if (letter.equals("M")) {
        nodes.put(letter, new Node(letter, true));
      }

      nodes.put(letter, new Node(letter, false));
    }

    Node nodeA = nodes.get("A");
    Node nodeB = nodes.get("B");
    Node nodeC = nodes.get("C");
    Node nodeD = nodes.get("D");
    Node nodeE = nodes.get("E");
    Node nodeF = nodes.get("F");
    Node nodeG = nodes.get("G");
    Node nodeH = nodes.get("H");
    Node nodeI = nodes.get("I");
    Node nodeJ = nodes.get("J");
    Node nodeK = nodes.get("K");
    Node nodeL = nodes.get("L");
    Node nodeM = nodes.get("M");
    Node nodeN = nodes.get("N");
    Node nodeO = nodes.get("O");
    Node nodeP = nodes.get("P");
    Node nodeQ = nodes.get("Q");

    graphs.put(nodeA, Set.of(nodeB, nodeC));
    graphs.put(nodeB, Set.of(nodeD));
    graphs.put(nodeC, Set.of(nodeD));
    graphs.put(nodeD, Set.of(nodeE, nodeF));
    graphs.put(nodeE, Set.of(nodeG, nodeH, nodeI));
    graphs.put(nodeF, Set.of(nodeJ, nodeK, nodeL));
    graphs.put(nodeL, Set.of(nodeM));
    graphs.put(nodeM, Set.of(nodeN, nodeO, nodeP));
    graphs.put(nodeP, Set.of(nodeQ));

    return new TestData(nodeA, graphs);
  }

  private record TestData(Node root, Map<Node, Set<Node>> graphs) {

  }
}