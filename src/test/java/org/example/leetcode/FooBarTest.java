package org.example.leetcode;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class FooBarTest {

  private FooBar fooBar;

  @Test
  void should_WorkAsynchronously() throws InterruptedException {
    fooBar = new FooBar(2);

    List<Thread> threads = createThreads();
    startThread(threads);
    waitForThreadsEnd(threads);

    System.out.println();
  }

  private void waitForThreadsEnd(List<Thread> threads) {
    threads.forEach(thread -> {
      try {
        thread.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
  }

  private void startThread(List<Thread> threads) {
    threads.forEach(Thread::start);
  }

  private List<Thread> createThreads() {
    return Arrays.stream(Word.values())
        .map(word -> new ParallelWriter(fooBar, word))
        .map(Thread::new)
        .toList();
  }

  private static final class ParallelWriter implements Runnable {

    private final FooBar fooBar;

    private final Word word;

    private ParallelWriter(FooBar fooBar, Word word) {
      this.fooBar = fooBar;
      this.word = word;
    }

    @Override
    public void run() {
      if (Word.FOO.equals(word)) {
        try {
          fooBar.foo(() -> System.out.print(word.value));
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      } else if (Word.BAR.equals(word)) {
        try {
          fooBar.bar(() -> System.out.print(word.value));
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  private enum Word {

    FOO("foo"),
    BAR("bar");

    private final String value;

    Word(String value) {
      this.value = value;
    }
  }
}