package org.example.leetcode;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {

    private final Lock lock;
    private final Condition fooCondition;
    private final Condition barCondition;
    private final AtomicBoolean firstLetter;
    private final int n;

    public FooBar(int n) {
        this.lock = new ReentrantLock();
        this.fooCondition = lock.newCondition();
        this.barCondition = lock.newCondition();
        this.firstLetter = new AtomicBoolean(true);
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!firstLetter.get()) {
                    fooCondition.await();
                }

                printFoo.run();
                firstLetter.set(false);
                barCondition.signal();
            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();

            try {
                while (firstLetter.get()) {
                    barCondition.await();
                }

                printBar.run();
                firstLetter.set(true);
                fooCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}