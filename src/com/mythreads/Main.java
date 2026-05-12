/**
 * Java program to create, start, yield and set priorities of threads.
 */

package com.mythreads;

/**
 * Main class.
 */
public class Main {

    // JVM entry point.
    public static void main(String[] args) {

        // Creating thread.
        Thread t1 = new MyThread();
        // Giving thread a name.
        t1.setName("FirstThread");
        // Setting a priority.
        t1.setPriority(10); // Maximal priority.
        // Starting thread.
        t1.start();

        // Creating thread.
        Thread t2 = new MyThread();
        // Giving thread a name.
        t2.setName("SecondThread");
        // Setting a priority.
        t2.setPriority(5);
        // Starting thread.
        t2.start();

        // Creating thread.
        Thread t3 = new MyThread();
        // Giving thread a name.
        t3.setName("ThirdThread");
        // Setting a priority.
        t3.setPriority(1); // Minimal priority.
        // Starting thread.
        t3.start();

    }
}

// MyThread class.
class MyThread extends Thread {

    public void run() {
        try {
            for(int i = 0; i < 5; i++) {

                System.out.println("For iteration i = " + i + " thread with name: " + Thread.currentThread().getName());

                if ("SecondThread".equals(Thread.currentThread().getName())) {

                    // Letting another threads with the same or higher priority to execute.
                    Thread.currentThread().yield();

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
