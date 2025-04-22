package juc;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThread1 {
    private static volatile int cnt = 0;
    private static ReentrantLock lock = new ReentrantLock();

    public MultiThread1() {
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.SECONDS, new SynchronousQueue());

        for(int i = 0; i < 10; ++i) {
            executor.submit(() -> {
                lock.lock();
                if (cnt < 10) {
                    System.out.println(Thread.currentThread().getName() + " : " + cnt);
                    ++cnt;
                }

                lock.unlock();
            });
        }

        executor.shutdown();
    }
}

