package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.IntConsumer;
import org.junit.jupiter.api.Test;

class ZeroEvenOddTest {

  @Test
  void shouldPrint() {
    List<Integer> result = new CopyOnWriteArrayList<>();
    ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);

    Thread firstThread = new Thread(() -> {
      try {
        zeroEvenOdd.even(command(result));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    Thread secondThread = new Thread(() -> {
      try {
        zeroEvenOdd.odd(command(result));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    Thread thirdThread = new Thread(() -> {
      try {
        zeroEvenOdd.zero(command(result));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    startThreads(firstThread, secondThread, thirdThread);
    waitThread(firstThread, secondThread, thirdThread);

    assertThat(result).containsExactly(0, 1, 0, 2, 0, 3, 0, 4, 0, 5);
  }

  private IntConsumer command(List<Integer> result) {
    return result::add;
  }

  private void command1() {
  }

  private void startThreads(Thread... threads) {
    Arrays.stream(threads).forEach(Thread::start);
  }

  private void waitThread(Thread... threads) {
    Arrays.stream(threads).forEach(thread -> {
      try {
        thread.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
  }
}