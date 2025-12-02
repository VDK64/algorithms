package org.example.leetcode;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

  private final AtomicInteger value = new AtomicInteger(0);
  private final AtomicBoolean zeroTime = new AtomicBoolean(true);
  private final Lock lock = new ReentrantLock();
  private final Condition evenCondition = lock.newCondition();
  private final Condition zeroCondition = lock.newCondition();
  private final Condition oddCondition = lock.newCondition();

  private final int n;

  public ZeroEvenOdd(int n) {
    this.n = n;
  }

  public void zero(IntConsumer printNumber) throws InterruptedException {
    try {
      lock.lock();
      while (value.get() < n) {

        while (!zeroTime.get()) {
          if (waitOrEnd()) {
            evenCondition.signal();
            oddCondition.signal();
            return;
          }
          zeroCondition.await();
        }

        printNumber.accept(0);
        value.incrementAndGet();
        zeroTime.set(false);
        evenCondition.signal();
        oddCondition.signal();
      }
    } finally {
      lock.unlock();
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    try {
      lock.lock();
      while (value.get() < n) {

        while ((value.get() % 2 != 0 || zeroTime.get())) {
          if (waitOrEnd()) {
            zeroCondition.signal();
            oddCondition.signal();
            return;
          }
          evenCondition.await();
        }

        printNumber.accept(value.get());
        zeroTime.set(true);
        zeroCondition.signal();
      }
    } finally {
      lock.unlock();
    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    try {
      lock.lock();
      while (value.get() < n || n == 1) {

        while ((value.get() % 2 == 0 || zeroTime.get())) {
          if (waitOrEnd()) {
            zeroCondition.signal();
            evenCondition.signal();
            return;
          }
          oddCondition.await();
        }

        printNumber.accept(value.get());
        zeroTime.set(true);

        zeroCondition.signal();
      }
    } finally {
      lock.unlock();
    }
  }

  private boolean waitOrEnd() {
    return value.get() >= n;
  }
}