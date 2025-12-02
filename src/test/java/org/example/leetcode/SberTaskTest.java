package org.example.leetcode;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.equalTo;

import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SberTaskTest {

  private SberTask sberTask;

  @BeforeEach
  void setUp() {
    sberTask = new SberTask();
  }

  @Test
  void shouldCreateSequence() throws InterruptedException {
    List<String> sequence = sberTask.sequence();

    await().atMost(Duration.of(3, SECONDS.toChronoUnit()))
        .until(sequence::size, equalTo(6));

    assertThat(sequence)
        .containsExactly("first", "second", "first", "second", "first", "second");
  }

}