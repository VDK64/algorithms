package org.example.groking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.example.groking.DepthFirstSearch.Node;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@ExtendWith(InstancioExtension.class)
class DepthFirstSearchTest {

  private DepthFirstSearch underTest;

  @BeforeEach
  void setUp() {
    underTest = new DepthFirstSearch();
  }

  @ParameterizedTest
  @MethodSource("graphMapMethodSource")
  void shouldFindSellerName(TestData testData, String expectedSellerName, int expectedStep) {
    String sellerName = underTest.findSellerName(testData.root, testData.graphs);

    assertThat(sellerName).isEqualTo(expectedSellerName);
  }

  @ParameterizedTest
  @MethodSource("graphMapMethodSource")
  void shouldCountStepToSeller(TestData testData, String expectedSellerName, int expectedStep) {
    int step = underTest.findStepToSeller(testData.root, testData.graphs);

    assertThat(step).isEqualTo(expectedStep);
  }

  @Test
  void shouldReturnAllFiles_when_DepthFirstAlgorithm() {
    TestData testData = createTestDataForGetAllFiles();

    List<String> fileNames = underTest.getAllFilesDepthFirstAlgorithm(testData.root,
        testData.graphs());

    assertThat(fileNames).containsExactlyInAnyOrder("odyssey.png", "a.png", "space.png");
  }

  @Test
  void shouldReturnAllFiles_when_BreadthFirstAlgorithm() {
    TestData testData = createTestDataForGetAllFiles();

    List<String> fileNames = underTest.getAllFilesBreadthFirstAlgorithm(
        testData.root(), testData.graphs(), new ArrayList<>());

    assertThat(fileNames).containsExactlyInAnyOrder("odyssey.png", "a.png", "space.png");
  }

  @Disabled
  @Test
  void shouldTopologicalSort() {
    TestData testData = createTestDataForSort();
    List<String> sortNodeNames = underTest.topologicalSort(testData.root, testData.graphs);
    List<String> firstExpectedVariant = List.of("A", "B", "D", "E", "F");
    List<String> secondExpectedVariant = List.of("A", "B", "D", "E", "G");
    List<String> thirdExpectedVariant = List.of("A", "B", "D", "E", "H");
    List<String> fourthExpectedVariant = List.of("A", "C", "D", "E", "F");
    List<String> fifthExpectedVariant = List.of("A", "C", "D", "E", "G");
    List<String> sixthExpectedVariant = List.of("A", "C", "D", "E", "H");

    assertThat(sortNodeNames).satisfiesAnyOf(
        s -> assertThat(s).isEqualTo(firstExpectedVariant),
        s -> assertThat(s).isEqualTo(secondExpectedVariant),
        s -> assertThat(s).isEqualTo(thirdExpectedVariant),
        s -> assertThat(s).isEqualTo(fourthExpectedVariant),
        s -> assertThat(s).isEqualTo(fifthExpectedVariant),
        s -> assertThat(s).isEqualTo(sixthExpectedVariant)
    );
  }

  private TestData createTestDataForGetAllFiles() {
    Node pics = new Node("pics", false);
    Node odyssey = new Node("odyssey.png", true);
    Node innerFile = new Node("2001", false);
    Node a = new Node("a.png", true);
    Node space = new Node("space.png", true);

    Map<Node, Set<Node>> graphs = new HashMap<>();
    graphs.put(pics, Set.of(odyssey, innerFile));
    graphs.put(innerFile, Set.of(a, space));
    return new TestData(pics, graphs);
  }

  private static TestData createTestDataForSort() {
    Node nodeA = new Node("A", false);
    Node nodeB = new Node("B", false);
    Node nodeC = new Node("C", false);
    Node nodeD = new Node("D", false);
    Node nodeE = new Node("E", false);
    Node nodeF = new Node("F", false);
    Node nodeG = new Node("G", false);
    Node nodeH = new Node("H", false);

    Map<Node, Set<Node>> graphs = new HashMap<>();

    graphs.put(nodeA, Set.of(nodeB, nodeC));
    graphs.put(nodeB, Set.of(nodeD));
    graphs.put(nodeC, Set.of(nodeD));
    graphs.put(nodeD, Set.of(nodeE));
    graphs.put(nodeE, Set.of(nodeF, nodeG, nodeH));

    return new TestData(nodeA, graphs);
  }

  private static List<Arguments> graphMapMethodSource() {
    return List.of(
        Arguments.of(createTestDataWithNamedNodes(), "Jane", 4),
        Arguments.of(createTestDataWithLetterNodes(), "M", 5)
    );
  }

  private static TestData createTestDataWithNamedNodes() {
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

  private static TestData createTestDataWithLetterNodes() {
    Map<String, Node> nodes = new HashMap<>();
    Map<Node, Set<Node>> graphs = new HashMap<>();
    for (char ch = 'A'; ch <= 'Q'; ch++) {
      String letter = String.valueOf(ch);

      if (letter.equals("M")) {
        nodes.put(letter, new Node(letter, true));
      } else {
        nodes.put(letter, new Node(letter, false));
      }
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