package org.example.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class BuildingH2O {

  private final Semaphore hydrogenSemaphore = new Semaphore(2);
  private final Semaphore oxygenSemaphore = new Semaphore(1);
  private final CyclicBarrier barrier = new CyclicBarrier(3);

  public BuildingH2O() {
  }

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    try {
      hydrogenSemaphore.acquire();
      releaseHydrogen.run();
      if (barrier.await() == 0) {
        releaseSemaphores();
      }
    } catch (BrokenBarrierException e) {
      throw new RuntimeException(e);
    }
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    try {
      oxygenSemaphore.acquire();
      releaseOxygen.run();
      if (barrier.await() == 0) {
        releaseSemaphores();
      }
    } catch (BrokenBarrierException e) {
      throw new RuntimeException(e);
    }
  }

  private void releaseSemaphores() {
    hydrogenSemaphore.release(2);
    oxygenSemaphore.release(1);
  }
}