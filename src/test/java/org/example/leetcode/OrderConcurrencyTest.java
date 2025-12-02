package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OrderConcurrencyTest {

  private OrderConcurrency orderConcurrency;
  private List<String> array;

  @BeforeEach
  void setUp() {
    orderConcurrency = new OrderConcurrency();
    array = new CopyOnWriteArrayList<>();
  }

  @ParameterizedTest
  @MethodSource("provideTestData")
  void should(int[] ints) {
    Thread[] threads = createThreads(ints);
    startThreads(threads);
    waitForThreads(threads);
    assertThat(array).containsExactly("first", "second", "third");
  }

  private void waitForThreads(Thread[] threads) {
    Arrays.stream(threads)
        .forEach(thread -> {
          try {
            thread.join();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        });
  }

  private Thread[] createThreads(int[] ints) {
    return Arrays.stream(ints)
        .mapToObj(value -> new OutputThread(new OrderConcurrency(), array, value))
        .toArray(Thread[]::new);

  }

  private void startThreads(Thread[] threads) {
    Arrays.stream(threads)
        .forEach(Thread::start);
  }

  private static Stream<Arguments> provideTestData() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 3}),
        Arguments.of(new int[]{1, 3, 2}),
        Arguments.of(new int[]{3, 2, 1})
    );
  }

  private static final class OutputThread extends Thread {

    private final OrderConcurrency orderConcurrency;
    private final List<String> array;
    private final int number;

    public OutputThread(OrderConcurrency orderConcurrency, List<String> array, int number) {
      this.orderConcurrency = orderConcurrency;
      this.array = array;
      this.number = number;
    }

    @Override
    public void run() {
      switch (number) {
        case 1 -> {
          try {
            orderConcurrency.first(() -> array.add("first"));
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }

        case 2 -> {
          try {
            orderConcurrency.second(() -> array.add("second"));
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
        case 3 -> {
          try {
            orderConcurrency.third(() -> array.add("third"));
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
    }
  }
}