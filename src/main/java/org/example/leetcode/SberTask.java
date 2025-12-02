package org.example.leetcode;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SberTask {

  public static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();
  public static final Condition FIRST_CONDITION = REENTRANT_LOCK.newCondition();
  public static final Condition SECOND_CONDITION = REENTRANT_LOCK.newCondition();

  public List<String> sequence() throws InterruptedException {
    List<String> out = new CopyOnWriteArrayList<>();

    Thread first = new Thread(() -> {
      for (int i = 0; i < 3; i++) {
        REENTRANT_LOCK.lock();
        try {
          while (out.size() % 2 == 1) {
            FIRST_CONDITION.await();
          }
          out.add("first");
          SECOND_CONDITION.signal();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        } finally {
          REENTRANT_LOCK.unlock();
        }
      }
    });

    Thread second = new Thread(() -> {
      for (int i = 0; i < 3; i++) {
        REENTRANT_LOCK.lock();
        try {
          while (out.size() % 2 == 0) {
            SECOND_CONDITION.await();
          }

          out.add("second");
          FIRST_CONDITION.signal();

        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        } finally {
          REENTRANT_LOCK.unlock();
        }
      }
    });

    first.start();
    second.start();
    first.join();
    second.join();

    return out;
  }
}