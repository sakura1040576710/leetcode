package juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MultiThread2 {
    private Semaphore[] semaphores = new Semaphore[5];
    private volatile int num = 0;

    public MultiThread2() {
        this.semaphores[0] = new Semaphore(1);

        for(int i = 1; i < 5; ++i) {
            this.semaphores[i] = new Semaphore(0);
        }

    }

    public static void main(String[] args) {
        System.out.println("hello, world!");
        final MultiThread2 m = new MultiThread2();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new SynchronousQueue());

        for(int i = 0; i < 5; i++) {
            int finalI = i;
            executor.submit(new Runnable() {
                public void run() {
                    while(true) {
                        while(true) {
                            try {
                                m.semaphores[finalI].acquire();
                                if (m.num > 100) {
                                    return;
                                }

                                System.out.println(Thread.currentThread() + " : " + m.num);
                                m.num++;
                            } catch (InterruptedException var5) {
                                var5.printStackTrace();
                            } finally {
                                m.semaphores[(finalI + 1) % 5].release();
                            }
                        }
                    }
                }
            });
        }

        executor.shutdown();
    }
}

