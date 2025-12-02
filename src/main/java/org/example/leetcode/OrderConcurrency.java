package org.example.leetcode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderConcurrency {

  public static final Lock LOCK = new ReentrantLock();
  public static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();
  public static final Condition CONDITION = LOCK.newCondition();

  public OrderConcurrency() {
  }

  public void first(Runnable printFirst) throws InterruptedException {
    LOCK.lock();
    try {
      while (ATOMIC_INTEGER.get() != 0) {
        CONDITION.await();
      }
      printFirst.run();
      ATOMIC_INTEGER.incrementAndGet();
      CONDITION.signalAll();
    } finally {
      LOCK.unlock();
    }

  }

  public void second(Runnable printSecond) throws InterruptedException {
    LOCK.lock();
    try {
      while (ATOMIC_INTEGER.get() != 1) {
        CONDITION.await();
      }
      printSecond.run();
      ATOMIC_INTEGER.incrementAndGet();
      CONDITION.signalAll();
    } finally {
      LOCK.unlock();
    }

  }

  public void third(Runnable printThird) throws InterruptedException {
    LOCK.lock();
    try {
      while (ATOMIC_INTEGER.get() != 2) {
        CONDITION.await();
      }
      printThird.run();
      ATOMIC_INTEGER.getAndSet(0);
      CONDITION.signalAll();
    } finally {
      LOCK.unlock();
    }
  }
}