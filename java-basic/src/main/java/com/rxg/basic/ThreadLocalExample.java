package com.rxg.basic;

/*
 * http://ifeve.com/java-threadlocal的使用/
 */
class MyRunnable implements Runnable {

    private ThreadLocal threadLocal = new ThreadLocal();

    @Override
    public void run() {
        threadLocal.set((int) (Math.random() * 100D));
        try {
        Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadLocal.get());
    }
}

public class ThreadLocalExample {

	public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        thread1.start();
        thread2.start();
	}

}
