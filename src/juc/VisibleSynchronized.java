package juc;

/**
 * 验证synchronized可见性
 */
public class VisibleSynchronized {
    private static int shareValue = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        synchronized (lock) {
                            try {
                                Thread.sleep(1000);
                                System.out.println("Thread1 : " + shareValue);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            shareValue = 10;
                        }
                    }
                }
        ).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    while (true){
                        System.out.println("Thread2 : " + shareValue);
                    }
                }
            }
        }).start();
    }
}
